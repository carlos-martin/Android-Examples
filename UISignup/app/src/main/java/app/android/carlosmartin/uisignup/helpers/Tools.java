package app.android.carlosmartin.uisignup.helpers;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

/**
 * Created by carlos.martin on 30/11/2017.
 */

public class Tools {
    public final static boolean isValidEmail(CharSequence target) {
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
}
