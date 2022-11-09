package com.arturofilio.studentadmin.Estate;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EstateService {
    private EstateDataAccessService estateDataAccessService;

    public EstateService(EstateDataAccessService estateDataAccessService) {
        this.estateDataAccessService = estateDataAccessService;
    }

    public List<Estate> getAllEstates() {
        return estateDataAccessService.selectAllEstates();   
    }
}
