package com.marcoscouto.crudmongo.resources;

import com.marcoscouto.crudmongo.domain.Post;
import com.marcoscouto.crudmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> response = postService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post response = postService.findById(id);
        if(response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post){
        Post response = postService.save(post);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post post){
        Post response = postService.update(id, post);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        postService.delete(id);
        return ResponseEntity.ok().build();
    }

}
