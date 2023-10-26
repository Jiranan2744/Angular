package com.example.Authorization.Controller;

import com.example.Authorization.Entity.SystemEntity;
import com.example.Authorization.Service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systems")
@CrossOrigin(origins = "http://localhost:4200/")
public class SystemController {

    @Autowired
    private SystemService systemService;

    // Rest API Crud - Create - POST
    // Read - GET
    // Delete - DELETE
    // Update - PUT

    // create system
    @PostMapping("/add")
    public SystemEntity createSystem(@RequestBody SystemEntity systemEntity){
        SystemEntity system1 = systemService.createSystem(systemEntity);
        return system1;
    }

    // Read system all
    @GetMapping("/get")
    public List<SystemEntity> getSystems(){
        return systemService.getSystems();
    }

    // Get system id
    @GetMapping("/user/{id}")
    public SystemEntity getSystemById(@PathVariable("id") long id){
        return systemService.getSystemById(id);
    }

    // Update system
    @PutMapping("/update/{id}")
    public SystemEntity updateSystemById(@RequestBody SystemEntity systemEntity, @PathVariable("id") long id){
        return systemService.updateSystem(systemEntity, id);
    }

    // Delete system
    @DeleteMapping("/delete/{id}")
    public String deleteSystem(@PathVariable("id") long id){
        systemService.deleteSystem(id);
        return "System Delete Successfully";
    }

}