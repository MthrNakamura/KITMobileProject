package com.planningdev.kitmobile;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetailInfoActivity extends ListActivity {
    private String[] mString = {"aaa", "bbb", "ccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ArrayAdapter<String> infoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mString);
        setListAdapter(infoAdapter);
    }

    protected void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        String item = (String)listView.getItemAtPosition(position);
        this.setTitle(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail_info, menu);
        return true;
    }
    
}
