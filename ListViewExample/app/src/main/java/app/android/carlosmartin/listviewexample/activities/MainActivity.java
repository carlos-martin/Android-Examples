package app.android.carlosmartin.listviewexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

            @Override
            public boolean onItemLongClick(String content, int position) {
                removeContent(position);
                return true;
            }
        });

        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.adapter);
    }

    private void observerContent() {
        this.listContent = new ArrayList<String>();
        this.counter = 0;
    }

    private void addContent(int position) {
        this.listContent.add(position, "Added n."+(++this.counter));
        this.adapter.notifyItemInserted(position);
        this.layoutManager.scrollToPosition(position);
    }

    private void removeContent(int position) {
        this.listContent.remove(position);
        this.adapter.notifyItemRemoved(position);
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
                this.addContent(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}