public class AttendanceSheet {
    private final String[] students;
    private int presentCount;

    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}