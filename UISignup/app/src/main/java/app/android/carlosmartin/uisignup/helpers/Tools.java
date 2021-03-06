package app.android.carlosmartin.uisignup.helpers;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by carlos.martin on 30/11/2017.
 */

public class Tools {
    public static boolean isValidEmail(CharSequence target) {
        boolean valid = (!TextUtils.isEmpty(target) &&
                Patterns.EMAIL_ADDRESS.matcher(target).matches());

        if (valid) {
            String[] splited = target.toString().split("@");
            String domain = splited[1];
            Log.d("DOMAIN", domain);
            valid = (domain.equals("sigma.se") || domain.equals("sigmatechnology.se"));
        }

        return valid;
    }

    public static boolean isValidPassword(final String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();

    }
}
