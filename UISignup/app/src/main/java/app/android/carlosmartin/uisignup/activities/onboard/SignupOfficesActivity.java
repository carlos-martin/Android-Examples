package app.android.carlosmartin.uisignup.activities.onboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.android.carlosmartin.uisignup.R;
import app.android.carlosmartin.uisignup.models.Office;
import app.android.carlosmartin.uisignup.adapters.onboard.SignupOfficesListAdapter;

public class SignupOfficesActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    //DataSource
    private String userName;
    private String userEmail;
    private Office userOffice;
    private List<Office> officeList;

    //UI
    private TextView textViewOffice;
    private ListView listView;
    private SignupOfficesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_offices);

        this.observerOffice();
        this.initUI();
    }

    private void initUI() {
        setTitle("Office");

        this.textViewOffice = findViewById(R.id.textViewOffice);
        this.textViewOffice.setText("WHAT'S YOUR SIGMA OFFICE?");

        this.listView = findViewById(R.id.officeListView);
        this.listView.setOnItemClickListener(this);

        this.adapter = new SignupOfficesListAdapter(this, R.layout.list_item_offices, this.officeList);
        this.listView.setAdapter(this.adapter);
        registerForContextMenu(listView);

        //Fetching data from the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.userName = bundle.getString("user_name");
            this.userEmail = bundle.getString("user_email");
        }
    }

    private void observerOffice() {
        this.officeList = new ArrayList<Office>() {{
            add(new Office("000","Jönköping"));
            add(new Office("001","Göteborg"));
            add(new Office("002","Linköping"));
        }};
    }

    //MARK: - List view function

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.userOffice = this.officeList.get(position);
        this.goToSignUpPasswordActivity();
    }

    private void goToSignUpPasswordActivity() {
        Intent intentToPassword = new Intent(SignupOfficesActivity.this,
                SignupPasswordActivity.class);
        intentToPassword.putExtra("user_name",  this.userName);
        intentToPassword.putExtra("user_email", this.userEmail);
        intentToPassword.putExtra("user_office", this.userOffice);
        startActivity(intentToPassword);

    }


}
