package app.android.carlosmartin.listviewexample.helpers;

import java.util.Random;

/**
 * Created by carlos.martin on 27/11/2017.
 */

public class Tools {
    private static final int MAX_LENGTH = 20;

    public static String randomSting() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(MAX_LENGTH);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}
