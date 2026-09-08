package com.gopu.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    public String type;
    public Repo repo;
    public String created_at;

}
