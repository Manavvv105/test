import java.util.Random;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public class BuggyPMDTest {

    public static int returnFromFinally() {
        try {
            return 1;
        } finally {
            return 2; // ReturnFromFinallyBlock
        }
    }

    public static void main(String[] args) {
        String password = "admin123"; // HardcodedPassword

        try {
            int x = 10 / 0;
        } catch (Exception e) {
        }

        // ✅ Fixed usage here
        System.out.println(returnFromFinally());

        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i;
        }

        for (int i = 0; i < 3; i++) {
            Random r = new Random();
            System.out.println(r.nextInt());
        }

        int[] nums = {1, 2, 3};
        System.out.println(nums[2]); // <-- Changed from nums[5] to avoid crash during compile

        int i = 0;
        while (i >= 0) {
            i++;
            break; // prevent actual infinite loop
        }

        String a = "hello";
        String b = new String("hello");
        if (a == b) {
            System.out.println("Equal?");
        }

        try {
            byte[] key = new byte[16];
            byte[] iv = new byte[16];
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, null, new IvParameterSpec(iv));
        } catch (Exception ignored) {}

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest("hello".getBytes());
        } catch (Exception ignored) {}
    }
}
