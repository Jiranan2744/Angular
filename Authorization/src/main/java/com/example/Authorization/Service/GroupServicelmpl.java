package com.example.Authorization.Service;

import com.example.Authorization.Entity.GroupEntity;
import com.example.Authorization.Repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServicelmpl implements GroupService {

    @Autowired
    private GroupRepo groupRepo;

    @Override
    public GroupEntity createGroup(GroupEntity groupEntity) {
        return groupRepo.save(groupEntity);
    }

    @Override
    public List<GroupEntity> getGroups() {
        return (List<GroupEntity>) groupRepo.findAll();
    }

    @Override
    public GroupEntity getGroupById(int id) {
        return groupRepo.findById(id).get();
    }

    @Override
    public void deleteGroup(int id) {
        groupRepo.deleteById(id);
    }

    @Override
    public GroupEntity updateGroup(GroupEntity groupEntity, int id) {
        GroupEntity group1 = groupRepo.findById(id).get();
        group1.setName(groupEntity.getName());
        group1.setStatus(groupEntity.getStatus());
        group1.setRole(groupEntity.getRole());

        return groupRepo.save(group1);
    }
}
