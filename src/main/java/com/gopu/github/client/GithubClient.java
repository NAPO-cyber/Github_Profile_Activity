package com.gopu.github.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gopu.github.model.User;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GithubClient {

    public User getUser(String username) {

        String url = "https://api.github.com/users/" + username;

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(response.body(), User.class);

        } catch (Exception e) {
            // ignore
            return null;
        }
    }
}
