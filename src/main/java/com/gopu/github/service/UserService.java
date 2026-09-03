package com.gopu.github.service;

import com.gopu.github.client.GithubClient;
import com.gopu.github.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private GithubClient client;


    public UserService(GithubClient client) {
        this.client = client;
    }

    public User getUser(String username) {
        return client.getUser(username);
    }
}
