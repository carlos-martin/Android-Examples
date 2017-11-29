package app.android.carlosmartin.listviewexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import app.android.carlosmartin.listviewexample.R;
import app.android.carlosmartin.listviewexample.adapters.AdapterMainListCell;

public class MainActivity extends AppCompatActivity {

    //Data Source
    private List<String> listContent;
    private int counter;

    //UI elements
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

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

        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new AdapterMainListCell(listContent, R.layout.list_item, new AdapterMainListCell.OnItemClickListener() {
            @Override
            public void onItemClick(String content, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("message", content);
                startActivity(intent);
            }
        });

        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.adapter);
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

/*
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
*/