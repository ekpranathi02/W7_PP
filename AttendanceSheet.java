public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        presentStudents = new String[maxClassSize];
        count = 0;
    }

    public void markPresent(String name) {
        if (!isPresent(name) && count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
        // if already present, do nothing (avoid duplicates)
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate, ignored

        System.out.println(sheet.getPresentCount()); // 2
        System.out.println(sheet.isPresent("Ben"));   // true
        System.out.println(sheet.isPresent("Chen"));  // false
    }
}