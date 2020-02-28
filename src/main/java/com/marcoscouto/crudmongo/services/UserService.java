package com.marcoscouto.crudmongo.services;

import com.marcoscouto.crudmongo.domain.User;
import com.marcoscouto.crudmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).get();
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(String id, User newUser){
        User user = findById(id);
        if(user == null) return null;
        updateUser(user, newUser);
        return userRepository.save(user);
    }

    private User updateUser(User user, User newUser){
        if(newUser.getName() != "" && newUser.getName() != null) user.setName(newUser.getName());
        if(newUser.getAge() != null) user.setAge(newUser.getAge());
        return user;
    }

}
