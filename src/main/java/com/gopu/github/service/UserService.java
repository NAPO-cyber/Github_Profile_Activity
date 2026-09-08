package com.gopu.github.service;

import com.gopu.github.client.GithubClient;
import com.gopu.github.model.Event;
import com.gopu.github.model.Repo;
import com.gopu.github.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final GithubClient client;


    public UserService(GithubClient client) {
        this.client = client;
    }

    public User getUser(String username) {
        return client.getUser(username);
    }

    public Event[] getActivity(String username) {
        return client.getActivity(username);
    }

    public Repo[] getRepos(String username) {
        return client.getRepos(username);
    }

}
