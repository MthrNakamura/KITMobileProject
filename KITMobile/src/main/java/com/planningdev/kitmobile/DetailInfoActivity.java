package com.planningdev.kitmobile;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetailInfoActivity extends ListActivity {
    private HashMap<String, String> urlTable;

    public DetailInfoActivity() {
        urlTable = new HashMap<String, String>();
        urlTable.put("yahoo", "http://www.yahoo.co.jp");
        urlTable.put("hikakinTV", "http://www.hikakintv.com");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set items into the UI List
        ArrayAdapter<String> infoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for (Iterator it = urlTable.entrySet().iterator(); it.hasNext(); ) {
            infoAdapter.add((String)((Map.Entry) it.next()).getKey());
        }
        //assign listed items
        setListAdapter(infoAdapter);
    }

    //display the detail page of user selected item
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        //check network connection
        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null || ! networkInfo.isConnected()) {
            //alert no network connection
            this.setTitle("No network");
            return ;
        }

        super.onListItemClick(listView, view, position, id);
        String item = (String)listView.getItemAtPosition(position);
        String url = urlTable.get(item);

        //implements network worker
        new AsyncNetWorker(this).execute(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail_info, menu);
        return true;
    }

}
