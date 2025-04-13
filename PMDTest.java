import java.util.Random;

public class PMDTest {

    // Unused variable
    private static final String UNUSED_CONSTANT = "Not used"; // UnusedLocalVariable

    public static void main(String[] args) {

        // Hardcoded password
        String password = "admin123"; // HardcodedPassword

        // System.out.println usage
        System.out.println("Starting PMD test..."); // SystemPrintln

        // Inefficient string concatenation in a loop
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i; // UseStringBufferForStringAppends
        }

        // Object creation in loop
        for (int i = 0; i < 3; i++) {
            Random r = new Random(); // AvoidInstantiatingObjectsInLoops
            System.out.println(r.nextInt()); // SystemPrintln again
        }

        // Array index out of bounds
        int[] nums = {1, 2, 3};
        System.out.println(nums[5]); // AvoidArrayIndexOutOfBounds

        // Empty catch block
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            // Empty on purpose // EmptyCatchBlock
        }
    }
}
