import java.util.Random;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public class BuggyPMDTest {

    public static void main(String[] args) {
        // Hardcoded password
        String password = "admin123"; // HardcodedPassword

        // Catching generic exception with empty catch block
        try {
            int x = 10 / 0;
        } catch (Exception e) { // AvoidCatchingGenericException + EmptyCatchBlock
        }

        // Return from finally block
        try {
            returnFromFinally();
        } catch (Exception ignored) {}

        // Inefficient string concatenation
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i; // UseStringBufferForStringAppends
        }

        // Object creation in loop
        for (int i = 0; i < 3; i++) {
            Random r = new Random(); // AvoidInstantiatingObjectsInLoops
            System.out.println(r.nextInt());
        }

        // Array index out-of-bounds
        int[] nums = {1, 2, 3};
        System.out.println(nums[5]); // AvoidArrayIndexOutOfBounds

        // Using == for strings
        String a = "hello";
        String b = new String("hello");
        if (a == b) { // UseEqualsToCompareStrings
            System.out.println("Equal?");
        }

        // Insecure crypto mode and IV
        try {
            byte[] key = new byte[16];
            byte[] iv = new byte[16];
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // InsecureCryptoMode
            cipher.init(Cipher.ENCRYPT_MODE, null, new IvParameterSpec(iv)); // InsecureCryptoIv
        } catch (Exception ignored) {}

        // Weak hashing algorithm
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // WeakHashFunction
            byte[] hash = md.digest("hello".getBytes());
        } catch (Exception ignored) {}
    }

    public static int returnFromFinally() {
        try {
            return 1;
        } finally {
            return 2; // ReturnFromFinallyBlock
        }
    }
}
