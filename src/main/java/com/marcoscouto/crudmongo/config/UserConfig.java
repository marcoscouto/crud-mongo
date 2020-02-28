package com.marcoscouto.crudmongo.config;

import com.marcoscouto.crudmongo.domain.User;
import com.marcoscouto.crudmongo.repositories.UserRepository;
import com.marcoscouto.crudmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class UserConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.findAll() != null) userRepository.deleteAll();

        List<User> users = new ArrayList<>();
        users.add(new User(null, "John", 29));
        users.add(new User(null, "Paul", 30));
        users.add(new User(null, "Ringo", 42));
        users.add(new User(null, "Gerge", 33));
        userRepository.saveAll(users);

    }
}
