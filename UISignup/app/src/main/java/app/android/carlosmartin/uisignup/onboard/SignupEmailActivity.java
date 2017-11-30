package app.android.carlosmartin.uisignup.onboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.android.carlosmartin.uisignup.R;

public class SignupEmailActivity extends AppCompatActivity {

    //DataSource
    private String userName;
    private String userEmail;

    //UI
    private TextView textViewEmail;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_email);
        this.initUI();
    }

    private void initUI() {
        setTitle("E-mail");

        this.textViewEmail = findViewById(R.id.textViewOffice);
        this.textViewEmail.setText("WHAT'S YOUR SIGMA E-MAIL?");

        this.editTextEmail = findViewById(R.id.editTextEmail);
        this.editTextEmail.setHint("Enter your email...");

        //Fetching data from the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.userName = bundle.getString("user_name");
        }
    }

    //MARK: - Action bar menu

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
                this.goToSignUpOfficeActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToSignUpOfficeActivity() {
        this.userEmail = this.editTextEmail.getText().toString();

        if (this.userEmail.isEmpty()) {
            Toast.makeText(SignupEmailActivity.this,
                    "Email text field cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            Intent intentToOffice = new Intent(SignupEmailActivity.this,
                    SignupOfficesActivity.class);
            intentToOffice.putExtra("user_name",  this.userName);
            intentToOffice.putExtra("user_email", this.userEmail);
            startActivity(intentToOffice);
        }
    }
}