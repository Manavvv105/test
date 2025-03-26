public class SyntaxErrorTest {

    public static void main(String[] args) {
        System.out.println("Starting program..."  // ❌ Missing closing parenthesis and semicolon

        int number = 10  // ❌ Missing semicolon

        if (number > 5)  // ❌ Missing opening brace {
            System.out.println("Number is greater than 5");

        String text = "Test string";  // ✅ Correct line
        System.out.println(text)  // ❌ Missing semicolon
    }
}
