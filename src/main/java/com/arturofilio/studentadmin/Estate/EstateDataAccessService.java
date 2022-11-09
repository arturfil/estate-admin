package com.arturofilio.studentadmin.Estate;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EstateDataAccessService {
    
    public List<Estate> selectAllEstates() {
        return List.of(
            new Estate(
                UUID.randomUUID(), "234 Queens Rd", 
                Estate.EstateType.House, 
                2342, 
                true
            ),
            new Estate(UUID.randomUUID(), "1438", 
                Estate.EstateType.Appartment, 
                890, 
                true
            )
        );
    }    
    
}
