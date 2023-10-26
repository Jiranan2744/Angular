package com.example.Authorization.Service;

import com.example.Authorization.Entity.GroupEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GroupService {

    // create group
    public GroupEntity createGroup(GroupEntity groupEntity);

    // read group
    public List<GroupEntity> getGroups();

    // read group by ID
    public GroupEntity getGroupById(int id);

    // delete group
    public void deleteGroup(int id);

    // update group
    public GroupEntity updateGroup(GroupEntity groupEntity, int id);

}
