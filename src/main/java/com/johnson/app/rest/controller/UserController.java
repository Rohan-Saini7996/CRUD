package com.johnson.app.rest.controller;

import com.johnson.app.rest.Repository.UserRepo;
import com.johnson.app.rest.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo repo;

    @GetMapping(value="/")
    public String getStarted(){
        return "Welcome";
    }

    @GetMapping(value="/users")
    public List<UserModel> getUsers(){
        return repo.findAll();
    }

    //@RequestMapping(value = "/add",method = RequestMethod.POST)
    @PostMapping(value="/save")
    public String saveUser(@RequestBody UserModel usermodel){
        repo.save(usermodel);
        return "saved..";
    }

    @PutMapping(value="/update/{id}")
    public String getUpdates(@PathVariable int id,@RequestBody UserModel user){
        UserModel updateUser=repo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        repo.save(updateUser);
        return "updated..";
    }

//    @DeleteMapping(value="/delete/{id}")
//    public String getDelete(@PathVariable int id,@RequestBody UserModel user){
//
//
//        UserModel deleteUser=repo.findById(id).get();
//        repo.delete(deleteUser);
//        return "Delete user with id :"+id;
//    }

    @DeleteMapping(value="/deletes/{id}")
    public String getDelete(@PathVariable int id){
        UserModel deleteUser=repo.findById(id).get();
        //repo.delete(deleteUser);
        repo.deleteById(id);
        return "Delete user with id :"+id;
    }


}
