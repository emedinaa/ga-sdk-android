package com.emedinaa.ga;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.HitBuilders;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeActivity extends ActionBarActivity {

    @Bind(R.id.btnAction)Button btnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        MyApplication.tracker().setScreenName("Home screen");

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.tracker().send(new HitBuilders.EventBuilder()
                        .setCategory("UI")
                        .setAction("Action")
                        .setLabel("Home Action")
                        .build());
                gotoMain();
            }
        });
    }

    private void gotoMain() {

        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
