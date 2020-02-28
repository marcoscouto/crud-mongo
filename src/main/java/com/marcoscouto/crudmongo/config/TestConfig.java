package com.marcoscouto.crudmongo.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcoscouto.crudmongo.domain.Post;
import com.marcoscouto.crudmongo.domain.User;
import com.marcoscouto.crudmongo.repositories.PostRepository;
import com.marcoscouto.crudmongo.repositories.UserRepository;
import com.marcoscouto.crudmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.findAll() != null) userRepository.deleteAll();
        if(postRepository.findAll() != null) postRepository.deleteAll();

        List<User> users = new ArrayList<>();

        User user1 = new User(null, "John", 29);
        User user2 = new User(null, "Paul", 30);
        User user3 = new User(null, "Ringo", 42);
        User user4 = new User(null, "George", 33);

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam id rhoncus leo. Vestibulum et fermentum purus. Praesent vel aliquet turpis. Sed eu feugiat erat. Duis ultricies vulputate leo eu ullamcorper. Donec suscipit consequat scelerisque. Fusce egestas tellus lacus. Morbi semper eleifend lectus, eu ultricies dui pellentesque non. Sed in eros et risus mattis tempus ac nec justo. Cras ac ex eu risus laoreet faucibus. Sed tempor nisl sit amet tortor mattis vestibulum. Praesent porttitor erat mauris, nec vulputate nisl cursus et. Sed ultricies elit vel est viverra, sed luctus nisi dignissim. Donec suscipit velit elit, id hendrerit nulla pulvinar porttitor. Vivamus quam ex, pulvinar vitae dignissim sed, scelerisque vel nisi.\n" +
                "\n" +
                "Aliquam nisl ante, pharetra et quam quis, imperdiet volutpat erat. Donec cursus neque justo, a blandit sapien facilisis non. Morbi eleifend laoreet diam quis sagittis. Nullam a aliquet quam, non bibendum nunc. Duis ac velit est. Quisque nec varius nunc, convallis laoreet lacus. Fusce mattis ex justo, et tincidunt ipsum condimentum eu. Nullam ultrices maximus bibendum. Sed ut est tincidunt, venenatis magna eu, lacinia leo. Pellentesque vitae dolor mauris. Ut et convallis nisl. Mauris mattis est a luctus pharetra. Integer sed enim leo.\n" +
                "\n" +
                "Maecenas nec ex ac justo egestas consectetur gravida ac lorem. Donec dapibus turpis nunc, nec commodo nunc gravida a. Sed non ultrices sem. Nullam eget malesuada quam, a tempor velit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer fringilla purus libero, nec molestie sem condimentum in. Aenean eu justo iaculis, fermentum massa in, convallis neque. Quisque id malesuada orci. Nam et nulla vestibulum, venenatis mi id, consectetur erat. Donec faucibus convallis aliquet. Nam a vestibulum odio, eu lobortis ante. Integer dapibus aliquet finibus. Maecenas sit amet ultrices leo, sit amet volutpat arcu.\n" +
                "\n" +
                "Maecenas iaculis urna nec suscipit tempor. Donec iaculis cursus nunc, a egestas turpis lobortis id. Curabitur sit amet odio vitae sapien feugiat scelerisque a et purus. Curabitur laoreet metus et tincidunt ultricies. Vivamus tempor libero a augue mattis, sed tincidunt lacus ultricies. Morbi tincidunt nulla sed rhoncus fermentum. Nunc in arcu sit amet mi pulvinar feugiat vitae nec ipsum. In vel faucibus dui. Etiam et elit venenatis, cursus lacus vitae, laoreet erat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc eu porta nibh, a imperdiet enim. Integer pretium eu nisl sit amet posuere. Fusce egestas tempor magna eget ultrices.\n" +
                "\n" +
                "Nulla sit amet turpis cursus, molestie risus ac, laoreet justo. Etiam eget erat malesuada, laoreet dolor sit amet, gravida orci. Proin at justo convallis, porta neque ultrices, finibus nisi. Ut sollicitudin elit ac arcu tempor vehicula. In posuere condimentum sapien quis porta. Proin venenatis mollis tempus. Maecenas volutpat volutpat erat eget viverra.";

        Post post1 = new Post(null, "Stairway to heaven", text, LocalDateTime.now(), user1);
        Post post2 = new Post(null, "November Rain", text, LocalDateTime.now(), user2);
        Post post3 = new Post(null, "Fairy Tale", text, LocalDateTime.now(), user1);
        Post post4 = new Post(null, "Hey Jude", text, LocalDateTime.now(), user3);

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        user1.getPosts().addAll(Arrays.asList(post1, post3));
        user2.getPosts().add(post2);
        user3.getPosts().add(post4);

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));




    }
}
