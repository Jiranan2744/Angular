package com.example.Authorization.Service;

import com.example.Authorization.Entity.SystemEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SystemService {

    // create system
    public SystemEntity createSystem(SystemEntity systemEntity);

    // read system
    public List<SystemEntity> getSystems();

    // read system by ID
    public SystemEntity getSystemById(long id);

    // delete system
    public void deleteSystem(long id);

    // update system
    public SystemEntity updateSystem(SystemEntity systemEntity, long id);

}
