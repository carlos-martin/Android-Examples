package app.android.carlosmartin.listviewexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.android.carlosmartin.listviewexample.R;
import app.android.carlosmartin.listviewexample.adapters.AdapterMainListCell;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView listView;
    private AdapterMainListCell adapter;
    private List<String> listContent;
    private int counter;
    private String toSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.observerContent();
        this.initUI();

    }

    private void initUI() {
        //ActionBar title
        setTitle("App Name!");

        //ListView
        this.listView = findViewById(R.id.listView);
        this.listView.setOnItemClickListener(this);

        //Adapter
        this.adapter = new AdapterMainListCell(this, R.layout.list_item, this.listContent);

        this.listView.setAdapter(this.adapter);

        registerForContextMenu(listView);

    }

    private void observerContent() {
        this.listContent = new ArrayList<String>();
        this.counter = 0;
    }

    //MARK: - Action bar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                this.listContent.add("Added n."+(++this.counter));
                this.adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //MARK: - ListView functions
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        /*
        Toast.makeText(
                MainActivity.this,
                "Clicked: " + this.listContent.get(position),
                Toast.LENGTH_SHORT).show();
         */
        this.toSend = this.listContent.get(position);
        if (this.toSend == null || this.toSend.isEmpty()) {
            this.toSend = "This cell message is empty or null";
        }

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("message", this.toSend);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(listContent.get(info.position));

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete_item:
                this.listContent.remove(info.position);
                this.adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}