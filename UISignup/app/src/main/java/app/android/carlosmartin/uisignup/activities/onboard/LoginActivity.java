package app.android.carlosmartin.uisignup.activities.onboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.android.carlosmartin.uisignup.R;

public class LoginActivity extends AppCompatActivity {

    //DataSource
    private String userEmail;
    private String userPassword;

    //UI
    private TextView textViewEmail;
    private TextView textViewPassword;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
    }

    private void initUI() {
        setTitle("Login");

        this.textViewEmail = findViewById(R.id.textViewUserEmail);
        this.textViewEmail.setText("E-MAIL");

        this.textViewPassword = findViewById(R.id.textViewUserPassword);
        this.textViewPassword.setText("PASSWORD");

        this.editTextEmail = findViewById(R.id.editTextUserEmail);
        this.editTextEmail.setHint("Enter your email...");
        this.editTextEmail.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            saveEmailFieldAction();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        this.editTextPassword = findViewById(R.id.editTextUserPassword);
        this.editTextPassword.setHint("Enter your password...");
        this.editTextPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            savePasswordFieldAction();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu_done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.next_bar_button_item:
                this.loginAction();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void loginAction() {
        int error_counter = 0;
        this.saveEmailFieldAction();
        this.savePasswordFieldAction();

        if (this.userEmail == null) {
            String error_message = "Email field cannot be empty";
            Toast.makeText(LoginActivity.this, error_message, Toast.LENGTH_LONG);
            error_counter++;
        }

        if (this.userPassword == null) {
            String error_message = "Password field cannot be empty";
            Toast.makeText(LoginActivity.this, error_message, Toast.LENGTH_LONG);
            error_counter++;
        }

        if (error_counter == 0) {
            //TODO: Try to log in.
        }
    }

    private void saveEmailFieldAction() {
        if (this.editTextEmail.getText() != null &&
                !this.editTextEmail.getText().toString().isEmpty()) {
            this.userEmail = this.editTextEmail.getText().toString();
            Log.d("LOGIN","User email: " + this.userEmail);
        }
    }

    private void savePasswordFieldAction() {
        if (this.editTextPassword.getText() != null &&
                !this.editTextPassword.getText().toString().isEmpty()) {
            this.userPassword = this.editTextPassword.getText().toString();
            Log.d("LOGIN","User password: " + this.userPassword);
        }
    }
}
