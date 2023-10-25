
import java.util.HashMap;

public class NonCompliantAWSSDKCode {
    private static HashMap<Integer, String> data = new HashMap<>();

    public static void main(String[] args) {
        // Adding elements to the HashMap without proper synchronization
        for (int i = 0; i < 1000; i++) {
            final int key = i;
            final String value = "Value" + i;

            new Thread(() -> {
                data.put(key, value);
            }).start();
        }

        // Simulate a failure by exiting the program prematurely
        System.exit(1);
    }
}

