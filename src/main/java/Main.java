import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter username: ");
        String username = sc.nextLine();

        GithubClient client = new GithubClient();
        User user = client.getUser(username);


        if (user != null) {
            System.out.println("username: " + user.login);
            System.out.println("bio: " + user.bio);
            System.out.println("Followers: " + user.followers);
            System.out.println("Following: " + user.following);
            System.out.println("Public repos: " + user.public_repos);
        }
    }
}
