import java.util.Random;



public class PMDTest {



    // Unused variable (dead local store)

    private static final String UNUSED_CONSTANT = "I am not used";



    public static void main(String[] args) {

        // Null assignment leading to potential NullPointerException

        String name = null;

        if (name.equals("PMD")) {  // NullPointerException

            System.out.println("Name matches PMD");

        }



        // Inefficient string concatenation in a loop

        String result = "";

        for (int i = 0; i < 100; i++) {

            result += i + ", ";  // Inefficient, should use StringBuilder

        }

        System.out.println(result);



        // Avoid instantiating new objects inside a loop

        for (int i = 0; i < 10; i++) {

            Random random = new Random();//Mo new Random inside loop

            System.out.println(random.nextInt());

        }

        //Array Index out of bounds

        int[] array = {1,2,3,4};

        System.out.println(array[6]);


        

        int[] array_one = {1,2,3};

        System.out.println(array[8]);



        // Unused local variable

        int unusedVariable = 42;



    }

}

