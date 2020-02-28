package com.marcoscouto.crudmongo.services;

import com.marcoscouto.crudmongo.domain.Post;
import com.marcoscouto.crudmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    public Post findById(String id){
        return postRepository.findById(id).get();
    }

    public Post save(Post post){
        return postRepository.save(post);
    }

    public void delete(String id){
        postRepository.deleteById(id);
    }

    public Post update(String id, Post newPost){
        Post post = findById(id);
        if(post == null) return null;
        updatePost(post, newPost);
        return postRepository.save(post);
    }

    private Post updatePost(Post post, Post newPost){
        if(newPost.getAuthor() != null) post.setAuthor(newPost.getAuthor());
        if(newPost.getText() != null) post.setText(newPost.getText());
        if(newPost.getTitle() != null) post.setTitle(newPost.getTitle());
        return post;
    }




}
