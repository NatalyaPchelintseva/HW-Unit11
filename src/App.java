import java.io.*;

public class App {
    public static double getAverageMarkForStudent(Student student) {
        double sum = 0.0;
        for (int mark : student.getMarks()) {
            sum += mark;
        }
        return sum / student.getCountOfMarks();
    }

    public static double getAverageMarkForAllStudent(StudentArray studentArray) {
        double sum = 0.0;
        for (Student student : studentArray.getArray()) {
            sum += getAverageMarkForStudent(student);
        }
        return sum / studentArray.getLength();
    }

    public static void main(String[] args) throws IOException {
        StudentArray studentArray = new StudentArray(6);
        FileUtils fileUtils = new FileUtils();
        fileUtils.loadAllDataFromTXTFile("InputData.txt", studentArray.getArray());
        String lineWithNameAndAverageForStudent = "";
        for (Student student : studentArray.getArray()) {
            lineWithNameAndAverageForStudent += String.format("%s %.2f\n", student.getName(), getAverageMarkForStudent(student));
            fileUtils.writeLineToTXTFile("OutputData.txt", lineWithNameAndAverageForStudent);
        }
        String lineWithTotalAverage = String.format("\n---\nTotal average: %.2f", getAverageMarkForAllStudent(studentArray));
        fileUtils.appendLineToTXTFile("OutputData.txt", lineWithTotalAverage);
    }
}
