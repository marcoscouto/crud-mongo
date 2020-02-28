package com.marcoscouto.crudmongo.repositories;

import com.marcoscouto.crudmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
