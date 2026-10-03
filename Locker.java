public class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    // Write-only: no getter for the code exists anywhere in this class.
    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }
        return false; // rejected, code stays the same
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678")); // true
        System.out.println(l.changeCode("0000", "9999")); // false, code is still "5678"
    }
}