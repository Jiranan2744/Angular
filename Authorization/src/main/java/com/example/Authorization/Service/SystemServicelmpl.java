package com.example.Authorization.Service;

import com.example.Authorization.Entity.SystemEntity;
import com.example.Authorization.Repo.SystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServicelmpl implements SystemService {

    @Autowired
    private SystemRepo systemRepo;

    @Override
    public SystemEntity createSystem(SystemEntity systemEntity) {
        return systemRepo.save(systemEntity);
    }

    @Override
    public List<SystemEntity> getSystems() {
        return (List<SystemEntity>) systemRepo.findAll();
    }

    @Override
    public SystemEntity getSystemById(long id) {
        return systemRepo.findById(id).get();
    }

    @Override
    public void deleteSystem(long id) {
        systemRepo.deleteById(id);

    }

    @Override
    public SystemEntity updateSystem(SystemEntity system, long id) {
       SystemEntity system1 = systemRepo.findById(id).get();
       system1.setName(system.getName());
       system1.setStatus(system.getStatus());

        return systemRepo.save(system1);
    }
}