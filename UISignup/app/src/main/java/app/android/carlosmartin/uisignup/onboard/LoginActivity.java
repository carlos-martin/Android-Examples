package app.android.carlosmartin.uisignup.onboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.android.carlosmartin.uisignup.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
    }

    private void initUI() {
        setTitle("Login");
    }
}
