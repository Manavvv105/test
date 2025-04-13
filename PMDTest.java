public class PMDTest {

    // Unused constant
    private static final String UNUSED = "I am never used";  // PMD: UnusedLocalVariable

    public static void main(String[] args) {
        // Hardcoded password
        String password = "admin123";  // PMD: HardcodedPassword

        // Off-by-one loop
        int[] numbers = {1, 2, 3};
        for (int i = 0; i <= numbers.length; i++) {  // PMD: AvoidArrayIndexOutOfBounds
            System.out.println(numbers[i]);          // PMD: SystemPrintln
        }

        // System.out used
        System.out.println("End of main.");  // PMD: SystemPrintln
    }
}
