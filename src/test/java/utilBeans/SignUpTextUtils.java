package utilBeans;

import java.security.SecureRandom;
import java.util.Random;

public class SignUpTextUtils {

    //random string builder to create too long username
    public String generateRandomString(int length) {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder randomStringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            int randomCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char randomChar = DATA_FOR_RANDOM_STRING.charAt(randomCharAt);

            randomStringBuilder.append(randomChar);
        }

        return randomStringBuilder.toString();
    }

    public int generateRandomInt() {
        //Add random positive int after username to make it unique
        Random random = new Random();
        return random.nextInt(20000);
    }

}
