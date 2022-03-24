public class StudentArray {
    private final Student[] array;
    private final int length;

    public StudentArray(int length) {
        this.length = length;
        array = new Student[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Student();
        }
    }

    public Student[] getArray() {
        return array;
    }

    public int getLength() {
        return length;
    }

}
