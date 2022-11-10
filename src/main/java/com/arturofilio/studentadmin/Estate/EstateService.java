package com.arturofilio.studentadmin.Estate;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EstateService {
    private EstateDataAccessService estateDataAccessService;

    public EstateService(EstateDataAccessService estateDataAccessService) {
        this.estateDataAccessService = estateDataAccessService;
    }

    List<Estate> getAllEstates() {
        return estateDataAccessService.selectAllEstates();   
    }

    void createEstate(Estate estate) {
        UUID newEstateId = UUID.randomUUID();
        estateDataAccessService.insertEstate(estate, newEstateId);
    }
}
