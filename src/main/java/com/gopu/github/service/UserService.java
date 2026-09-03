package com.gopu.github;

import org.springframework.beans.factory.annotation.Autowired;
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
