package com.gopu.github.controller;

import com.gopu.github.model.User;
import com.gopu.github.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
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
