package com.example.Authorization.Controller;

import com.example.Authorization.Entity.GroupEntity;
import com.example.Authorization.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:4200/")
public class GroupController {

    @Autowired
    private GroupService groupService;

    // Rest API Crud - Create - POST
    // Read - GET
    // Delete - DELETE
    // Update - PUT

    // create group
    @PostMapping("/add")
    public GroupEntity createGroup(@RequestBody GroupEntity groupEntity){
        GroupEntity group1 = groupService.createGroup(groupEntity);
        return group1;
    }

    // Read group all
    @GetMapping("/get")
    public List<GroupEntity> getGroups(){
        return groupService.getGroups();
    }

    // Get group id
    @GetMapping("/get/{id}")
    public GroupEntity getGroupById(@PathVariable("id") int id){
        return groupService.getGroupById(id);
    }

    // Update group
    @PutMapping("/update/{id}")
    public GroupEntity updateGroupById(@RequestBody GroupEntity groupEntity, @PathVariable("id") int id){
        return groupService.updateGroup(groupEntity, id);
    }

    // Delete group
    @DeleteMapping("/delete/{id}")
    public String deleteGroup(@PathVariable("id") int id){
        groupService.deleteGroup(id);
        return "User Delete Successfully";
    }
}
