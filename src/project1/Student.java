package project1;

public abstract class Student {
    public abstract void assignAdvisor(FacultyMember advisor);
    public abstract Student[] getAdvisees();
}
class Student { 
        private String id;
    private String name;
    private String major;
    private int currentSemester;
    public Student(String id, String name, String major, int currentSemester) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.currentSemester = currentSemester;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getMajor() { 
        return major;
    }
    public int getCurrentSemester() {
        return currentSemester;
    }
    
}
class FacultyMember { }
