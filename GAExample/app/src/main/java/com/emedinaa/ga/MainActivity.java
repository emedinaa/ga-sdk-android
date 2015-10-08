package com.emedinaa.ga;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.analytics.HitBuilders;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
    Tracker tracker = analytics.newTracker("UA-XXXX-Y"); // Send hits to tracker id UA-XXXX-Y

 // All subsequent hits will be send with screen name = "main screen"
     tracker.setScreenName("main screen");

     tracker.send(new HitBuilders.EventBuilder()
     .setCategory("UX")
     .setAction("click")
     .setLabel("submit")
     .build());

 // Builder parameters can overwrite the screen name set on the tracker.
     tracker.send(new HitBuilders.EventBuilder()
     .setCategory("UX")
     .setAction("click")
     .setLabel("help popup")
     .setScreenName("help popup dialog")
     .build());
 */
public class MainActivity extends ActionBarActivity {

    @Bind(R.id.eTxtEmail) EditText eTxtEmail;
    @Bind(R.id.eTxtPassword) EditText eTxtPassword;
    @Bind(R.id.btnLogin) Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //events
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.tracker().send(new HitBuilders.EventBuilder("UI", "login")
                        .setLabel("Main login")
                        .build());
                gotoHome();
            }
        });
        MyApplication.tracker().setScreenName("Main screen");
    }

    private void gotoHome() {
        // Log setting open event with category="ui", action="open", and label="settings"

        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
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
