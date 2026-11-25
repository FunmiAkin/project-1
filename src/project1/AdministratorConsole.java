package project1;

import java.util.Scanner;

public class AdministratorConsole {

    public static void main(String[] args) {
        AccountManager manager = new AccountManager("data/users.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Academic Advisement - Account Management Demo");
        while (true) {
            System.out.println("\n1. Log in");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }
            if (!choice.equals("1")) {
                System.out.println("Invalid option.");
                continue;
            }

            System.out.print("Username: ");
            String username = scanner.nextLine().trim();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            UserAccount account = manager.login(username, password);

            if (account == null) {
                System.out.println("Invalid username or password.");
            } else if (account.getRole().equals("ADMIN")) {
                System.out.println("Administrator login successful.");
                runAdminMenu(scanner, manager);
            } else {
                System.out.println("Faculty login successful for " + account.getUsername() + ".");
                System.out.println("Faculty advising menu will be added by another group member.");
            }
        }
    }

    public static void runAdminMenu(Scanner scanner, AccountManager manager) {
        while (true) {
            System.out.println("\nAdministrator Account Menu ");
            System.out.println("1. View faculty login accounts");
            System.out.println("2. Create faculty login account");
            System.out.println("3. Update faculty account password");
            System.out.println("0. Log out");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.showFacultyAccounts();
                    break;
                case "2":
                    System.out.print("New username: ");
                    String username = scanner.nextLine().trim();
                    System.out.print("New password: ");
                    String password = scanner.nextLine();
                    System.out.print("Faculty ID (must match a faculty record later): ");
                    String facultyId = scanner.nextLine().trim();
                    if (manager.createFacultyAccount(username, password, facultyId)) {
                        System.out.println("Faculty account saved.");
                    }
                    break;
                case "3":
                    System.out.print("Faculty username: ");
                    String target = scanner.nextLine().trim();
                    System.out.print("New password: ");
                    String newPassword = scanner.nextLine();
                    if (manager.changeFacultyPassword(target, newPassword)) {
                        System.out.println("Password updated and saved.");
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
