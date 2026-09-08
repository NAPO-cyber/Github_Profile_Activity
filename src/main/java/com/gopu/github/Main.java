package com.gopu.github;

import com.gopu.github.config.AppConfig;
import com.gopu.github.controller.UserController;
import com.gopu.github.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {

    private final UserService service;

    public Main(UserService service) {
        this.service = service;
    }

    public static void main (String[]args){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserController controller = context.getBean(UserController.class);
        controller.run();
    }
}