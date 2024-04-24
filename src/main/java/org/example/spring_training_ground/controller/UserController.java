package org.example.spring_training_ground.controller;

import org.example.spring_training_ground.model.User;
import org.example.spring_training_ground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        userRepository.save(user);
        return "User created successfully.";
    }

    @GetMapping("/user/{id}")
    public Object getUserById(@PathVariable Long id){
        User user=userRepository.findById(id).orElse(null);
        if(user!=null){
            return user;
        }
        else{
            return "User not found";
        }
    }

    @PutMapping("/user/{id}")
    public Object updateUserById(@PathVariable Long id,@RequestBody User updatedUser){
        User user=userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setName(updatedUser.getName());
            user.setJobRole(updatedUser.getJobRole());
            user.setAge(updatedUser.getAge());
            userRepository.save(user);
            return "User updated successfully.";
        }
        else{
            return "User not found";
        }
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User deleted successfully.";
        }
        else{
            return "User not found";
        }
    }

}
