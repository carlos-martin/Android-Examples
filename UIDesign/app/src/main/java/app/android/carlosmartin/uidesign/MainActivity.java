package app.android.carlosmartin.uidesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //UI variables
    private Button   nextButton;
    private EditText messageEditText;

    //Internal logic variables
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nextButton =       (Button)    findViewById(R.id.buttonMain);
        this.messageEditText =  (EditText)  findViewById(R.id.editTextMessage);

        this.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked();
            }
        });
    }

    public void buttonClicked() {
        // Go the the second activity and send a variable
        this.message = messageEditText.getText().toString();
        if (this.message == null || this.message.isEmpty()){
            this.message = "messageEditText is empty";
        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("message", this.message);
        startActivity(intent);
    }

}
