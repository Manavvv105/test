import java.util.Random;

public class PMDTest {

    private static final String UNUSED_CONSTANT = "Not used"; // UnusedLocalVariable

    public static void main(String[] args) {

        String password = "admin123"; // HardcodedPassword

        System.out.println("Starting PMD test..."); // SystemPrintln

        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i; // UseStringBufferForStringAppends
        }

        for (int i = 0; i < 3; i++) {
            Random r = new Random(); // AvoidInstantiatingObjectsInLoops
            System.out.println(r.nextInt()); // SystemPrintln again
        }

        int[] nums = {1, 2, 3};
        System.out.println(nums[5]); // AvoidArrayIndexOutOfBounds

        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            // Empty on purpose // EmptyCatchBlock
        }
    }
}
