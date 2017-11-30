package app.android.carlosmartin.uisignup.onboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import app.android.carlosmartin.uisignup.R;
import app.android.carlosmartin.uisignup.models.Office;

public class SignupPasswordActivity extends AppCompatActivity {

    //DataSource
    private String userName;
    private String userEmail;
    private Office userOffice;
    private String userPassword;

    //UI
    private TextView textViewPassword;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_password);
        this.initUI();
    }

    private void initUI() {
        setTitle("Password");

        this.textViewPassword = findViewById(R.id.textViewPassword);
        this.textViewPassword.setText("ADD A PASSWORD FOR YOUR ACCOUNT");

        this.editTextPassword = findViewById(R.id.editTextPassword);
        this.editTextPassword.setHint("Enter password...");

        //Fetching data from the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.userName = bundle.getString("user_name");
            this.userEmail = bundle.getString("user_email");
            this.userOffice = (Office) bundle.getSerializable("user_office");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu_signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.next_bar_button_item:
                this.createUserAccount();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void createUserAccount() {
    }
}
