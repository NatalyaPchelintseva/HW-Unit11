import java.io.*;

public class FileUtils {
    public static void writeLineToTXTFile(String filename, String line) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
        bufferedWriter.write(line);
        bufferedWriter.close();
    }

    public static void appendLineToTXTFile(String filename, String line) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));
        bufferedWriter.write(line);
        bufferedWriter.close();
    }

    public void loadAllDataFromTXTFile(String fileName, Student[] array) {
        try {
            uploadLinesFromTXTFile(fileName, array);
        }
        catch (FileNotFoundException exception) {
            System.out.println("file not found: " + exception.getMessage());
            exception.printStackTrace();
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    private void uploadLinesFromTXTFile(String filename, Student[] array) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String lineFromFile = reader.readLine();
        int index = 0;
        while (lineFromFile != null) {
            array[index] = parseDataFromFileToStudent(lineFromFile);
            lineFromFile = reader.readLine();
            index++;
        }
        reader.close();
    }

    private Student parseDataFromFileToStudent(String line) {
        Student s = new Student();
        String[] dataFromLine = line.split(";");
        s.setName(dataFromLine[0]);
        s.setCourseNumber(Integer.parseInt(dataFromLine[1]));
        s.setEmail(dataFromLine[2]);
        int[] marks = new int[s.getCountOfMarks()];
        for (int i = 0; i < s.getCountOfMarks(); i++) {
            marks[i] = Integer.parseInt(dataFromLine[i + 3]);
        }
        s.setMarks(marks);
        return s;
    }
}
