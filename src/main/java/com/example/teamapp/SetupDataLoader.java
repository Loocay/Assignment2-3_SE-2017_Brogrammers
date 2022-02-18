package com.example.teamapp;

import com.example.teamapp.dto.UserDto;
import com.example.teamapp.models.Auth.UserEntity;
import com.example.teamapp.services.PostCommentService;
import com.example.teamapp.services.PostService;
import com.example.teamapp.services.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final UserService userService;
    private final PostService postService;
    private final PostCommentService postCommentService;

    public SetupDataLoader(UserService userService, PostService postService, PostCommentService postCommentService) {
        this.userService = userService;
        this.postService = postService;
        this.postCommentService = postCommentService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // create users
        System.out.println("Hello!\n" +
                "{username: Adilet, password: 1234}\n" +
                "{username: Bek, password: 1234}\n" +
                "They are friends c:");
        UserDto user1 = new UserDto("Adilet", "1234");
        boolean isUserExist = userService.isUserExist(user1);
        if (isUserExist) {
            System.out.println("SetupDataLoader: Setup already done");
            return;
        }
        UserDto user2 = new UserDto("Bek", "1234");
        userService.saveUser(user1);
        userService.saveUser(user2);

        UserEntity user1Entity = userService.findUserByUsername(user1.getUsername());
        UserEntity user2Entity = userService.findUserByUsername(user2.getUsername());
        user1Entity.getFriends().add(user2Entity);
        user2Entity.getFriends().add(user1Entity);

        System.out.println("SetupDataLoader: completed setup\n");
    }
}
