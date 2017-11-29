package app.android.carlosmartin.listviewexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import app.android.carlosmartin.listviewexample.R;

public class DetailActivity extends AppCompatActivity {

    //UI
    private TextView detailTextView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.initUI();
    }

    private void initUI() {
        //ActionBar title
        setTitle("Details");

        this.detailTextView = findViewById(R.id.textViewDetail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.message = bundle.getString("message");
            if (this.message == null) {
                this.message = "Key does not exists!";
            }
        } else {
            this.message = "Bundle is null";
        }

        this.detailTextView.setText(this.message);
    }
}
