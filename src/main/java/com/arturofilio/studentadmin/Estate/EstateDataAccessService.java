package com.arturofilio.studentadmin.Estate;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class EstateDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EstateDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Estate> selectAllEstates() {
        String sql = 
                    "SELECT " + 
                    "estate_id, " + 
                    "address, " + 
                    "squared_feet, " + 
                    "rented, " + 
                    "type " + 
                    "FROM estate;";
        return jdbcTemplate.query(sql, mapEstateFromDb());
    }

    private RowMapper<Estate> mapEstateFromDb() {
        return (resultSet, i) -> {
            String estateIdStr = resultSet.getString("estate_id");
            UUID estateId = UUID.fromString(estateIdStr);
            String address = resultSet.getString("address");
            int squaredFeet = resultSet.getInt("squared_feet");
            Boolean rented = resultSet.getBoolean("rented");
            String typeStr = resultSet.getString("type");
            Estate.EstateType type = Estate.EstateType.valueOf(typeStr);
            return new Estate(estateId, address, type, squaredFeet, rented);
        };
    }

    public int insertEstate(Estate estate, UUID estateId) {
        String sql = 
            "INSERT INTO estate (estate_id, address, squared_feet, rented, type) " + 
            "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            estateId, 
            estate.getAddress(),
            estate.getSquaredFeet(),
            estate.getRented(),
            estate.getType().name()
        );
    }

}
