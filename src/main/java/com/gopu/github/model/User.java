package com.gopu.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public String login;
    public String bio;
    public int followers;
    public int following;
    public int public_repos;

}
