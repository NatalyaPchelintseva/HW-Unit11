import java.util.Arrays;

public class Student {
    private String name;
    private int courseNumber;
    private String email;
    private int[] marks;
    private final int countOfMarks = 4;

    public Student() {
        name = "no name";
        courseNumber = 0;
        email = "no email";
        marks = new int[countOfMarks];
    }

    public String getName() {
        return name;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getEmail() {
        return email;
    }

    public int[] getMarks() {
        return marks;
    }

    public int getCountOfMarks() {
        return countOfMarks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courseNumber=" + courseNumber +
                ", email='" + email + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
