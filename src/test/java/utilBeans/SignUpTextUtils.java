package utilBeans;

import java.security.SecureRandom;
import java.util.Random;

public class SignUpTextUtils {

    //random string builder to create too long username
    public String generateRandomString(int length) {
        String char_lower = "abcdefghijklmnopqrstuvwxyz";
        String char_upper = char_lower.toUpperCase();
        String number = "0123456789";

        String dataForRandomString = char_lower + char_upper + number;
        SecureRandom random = new SecureRandom();

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder randomStringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            int randomCharAt = random.nextInt(dataForRandomString.length());
            char randomChar = dataForRandomString.charAt(randomCharAt);

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
