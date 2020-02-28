package com.marcoscouto.crudmongo.resources;

import com.marcoscouto.crudmongo.domain.User;
import com.marcoscouto.crudmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> response = userService.findAll();
        if(response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
        User response = userService.findById(id);
        if(response == null) ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User response = userService.save(user);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user){
        User response = userService.update(id, user);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
