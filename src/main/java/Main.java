import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter username: ");
        String username = sc.nextLine();

        String url = "https://api.github.com/users/" + username;

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(response.body(), User.class);

            System.out.println("username: " + user.login);
            System.out.println("bio: " + user.bio);
            System.out.println("Followers: " + user.followers);
            System.out.println("Following: " + user.following);
            System.out.println("Public repos: " + user.public_repos);


        } catch (Exception e) {
            // ignore
        }
    }
}
