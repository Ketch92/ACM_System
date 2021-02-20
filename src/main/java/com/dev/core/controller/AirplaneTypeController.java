package com.dev.core.controller;

import com.dev.core.entity.type.AirplaneType;
import com.dev.core.service.implementation.type.AirplaneTypeServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/airplane-types")
@RestController
public class AirplaneTypeController {
    
    private final AirplaneTypeServiceImpl airplaneTypeService;
    
    public AirplaneTypeController(AirplaneTypeServiceImpl airplaneTypeService) {
        this.airplaneTypeService = airplaneTypeService;
    }
}
