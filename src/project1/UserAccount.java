package project1;


public class UserAccount {
    private String username;
    private String password;
    private String role;
    private String facultyId;


    public UserAccount() {
        this("", "", "", "");
    }


    public UserAccount(String username, String password, String role, String facultyId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.facultyId = facultyId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public boolean checkPassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toFileLine() {
        return username + "|" + password + "|" + role + "|" + facultyId;
    }


    @Override
    public String toString() {
        String details = username + " (" + role + ")";
        if (!facultyId.isEmpty()) {
            details += " - Faculty ID: " + facultyId;
        }
        return details;
    }
}
