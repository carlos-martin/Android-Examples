package app.android.carlosmartin.uidesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //connection to the activity element
        this.textView = (TextView) findViewById(R.id.textViewMain);

        //fetching data from the intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.message = bundle.getString("message");
            if (this.message == null) {
                this.message = "Key does not exists!";
            }
        } else {
            this.message = "Bundle is null";
        }

        this.textView.setText(this.message);
    }
}
