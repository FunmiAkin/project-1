package project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class AccountManager {
    private UserAccount[] accounts = new UserAccount[100];
    private int count = 0;
    private final Path filePath;

    public AccountManager(String fileName) {
        filePath = Path.of(fileName);
        loadAccounts();
    }


    private void loadAccounts() {
        if (!Files.exists(filePath)) {
            System.out.println("Error: Cannot find " + filePath + ". Login accounts were not loaded.");
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split("\\|", -1);
                if (parts.length != 4 || parts[0].isBlank() || parts[1].isBlank()
                        || (!parts[2].equals("ADMIN") && !parts[2].equals("FACULTY"))
                        || (parts[2].equals("FACULTY") && parts[3].isBlank())) {
                    System.out.println("Skipping invalid account at line " + lineNumber);
                    continue;
                }
                if (findByUsername(parts[0]) != null || count == accounts.length
                        || (parts[2].equals("FACULTY") && facultyIdExists(parts[3]))) {
                    System.out.println("Skipping duplicate or excess account at line " + lineNumber);
                    continue;
                }
                accounts[count++] = new UserAccount(parts[0], parts[1], parts[2], parts[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading user accounts: " + e.getMessage());
        }
    }

    public UserAccount findByUsername(String username) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getUsername().equalsIgnoreCase(username)) {
                return accounts[i];
            }
        }
        return null;
    }

    public UserAccount findByUsername(String username, String role) {
        UserAccount account = findByUsername(username);
        if (account != null && account.getRole().equals(role)) {
            return account;
        }
        return null;
    }

    private boolean facultyIdExists(String facultyId) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getRole().equals("FACULTY")
                    && accounts[i].getFacultyId().equalsIgnoreCase(facultyId)) {
                return true;
            }
        }
        return false;
    }

    public UserAccount login(String username, String password) {
        UserAccount account = findByUsername(username);
        if (account != null && account.checkPassword(password)) {
            return account;
        }
        return null;
    }

    public boolean createFacultyAccount(String username, String password, String facultyId) {
        if (!validField(username) || !validField(password) || !validField(facultyId)) {
            System.out.println("All fields are required and cannot contain | characters.");
            return false;
        }
        if (findByUsername(username) != null || facultyIdExists(facultyId)) {
            System.out.println("That username or faculty ID is already registered.");
            return false;
        }
        if (count == accounts.length) {
            System.out.println("Account list is full.");
            return false;
        }

        accounts[count++] = new UserAccount(username, password, "FACULTY", facultyId);
        if (!saveAccounts()) {
            accounts[--count] = null; // Undo if saving failed.
            return false;
        }
        return true;
    }

    public boolean changeFacultyPassword(String username, String newPassword) {
        UserAccount account = findByUsername(username, "FACULTY");
        if (account == null || !validField(newPassword)) {
            System.out.println("Faculty account not found or invalid new password.");
            return false;
        }

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (accounts[i] == account) {
                index = i;
                break;
            }
        }
        UserAccount replacement = new UserAccount(account.getUsername(), newPassword,
                "FACULTY", account.getFacultyId());
        accounts[index] = replacement;
        if (!saveAccounts()) {
            accounts[index] = account;
            return false;
        }
        return true;
    }

    public void showFacultyAccounts() {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (accounts[i].getRole().equals("FACULTY")) {
                System.out.println(accounts[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No faculty accounts found.");
        }
    }

    private boolean validField(String value) {
        return value != null && !value.isBlank() && !value.contains("|")
                && !value.contains("\n") && !value.contains("\r");
    }

    private boolean saveAccounts() {
        Path temporaryFile = filePath.resolveSibling(filePath.getFileName() + ".tmp");
        try {
            try (BufferedWriter writer = Files.newBufferedWriter(temporaryFile)) {
                for (int i = 0; i < count; i++) {
                    writer.write(accounts[i].toFileLine());
                    writer.newLine();
                }
            }
            Files.move(temporaryFile, filePath,
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving user accounts: " + e.getMessage());
            return false;
        }
    }
}
