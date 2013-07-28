package com.planningdev.kitmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;

/**
 * Created by nakamura on 2013/07/28.
 */
public class AsyncNetWorker extends AsyncTask<String, Integer, Long>
                            implements DialogInterface.OnCancelListener {
    Context context;

    public AsyncNetWorker(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Long doInBackground(String... params) {

        return 1L;
    }

    @Override
    protected void onCancelled() {

    }

    @Override
    protected void onPostExecute(Long result) {

    }

    @Override
    public void onCancel(DialogInterface dialog) {

    }
}
