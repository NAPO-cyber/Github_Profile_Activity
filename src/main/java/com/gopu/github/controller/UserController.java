package com.gopu.github.controller;

import com.gopu.github.model.User;
import com.gopu.github.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/api/users/{username}")
    public User getUser(@PathVariable String username) {
        return service.getUser(username);
    }

    public void run() {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter username: ");
        String username = sc.nextLine();

        User user = service.getUser(username);

        if (user != null) {
            System.out.println("username: " + user.login);
            System.out.println("bio: " + user.bio);
            System.out.println("Followers: " + user.followers);
            System.out.println("Following: " + user.following);
            System.out.println("Public repos: " + user.public_repos);
        }
    }
}
