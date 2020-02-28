package com.marcoscouto.crudmongo.repositories;

import com.marcoscouto.crudmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
