package com.gopu.github;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {

    private final GithubClient client;

    public Main(GithubClient client) {
        this.client = client;
    }

    public void run() {

            Scanner sc = new Scanner(System.in);

            System.out.print("enter username: ");
            String username = sc.nextLine();

            User user = client.getUser(username);

            if (user != null) {
                System.out.println("username: " + user.login);
                System.out.println("bio: " + user.bio);
                System.out.println("Followers: " + user.followers);
                System.out.println("Following: " + user.following);
                System.out.println("Public repos: " + user.public_repos);
            }
        }

    public static void main (String[]args){

        ApplicationContext context = new AnnotationConfigApplicationContext("com.gopu.github");

        GithubClient client = context.getBean(GithubClient.class);
        System.out.println(client);

        Main app = context.getBean(Main.class);
        app.run();
    }
}