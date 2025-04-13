public class PMDTest {

    public void test() {
        String password = "admin123"; // HardcodedPassword
        System.out.println("Logging in..."); // SystemPrintln

        int[] arr = {1, 2, 3};
        for (int i = 0; i <= arr.length; i++) { // AvoidArrayIndexOutOfBounds
            System.out.println(arr[i]);
        }

        String unused = "I am never used"; // UnusedLocalVariable
    }

    public static void main(String[] args) {
        new PMDTest().test();
    }
}
