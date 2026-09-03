import java.util.Scanner;

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

        GithubClient client = new GithubClient();

        Main app = new Main(client);
        app.run();
    }
}