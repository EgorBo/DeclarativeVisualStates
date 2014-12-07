package com.eb.vsm.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.eb.vsm.VisualStateManager;


public class MainActivity extends Activity {

    private VisualStateManager visualStateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visualStateManager = (VisualStateManager)findViewById(R.id.visualStateManager);

        //init view with "guest" state.
        visualStateManager.goToState("Guest");

        //go to "moderator" state on FB button click
        ((ImageButton)findViewById(R.id.facebookButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualStateManager.goToState("Moderator");
            }
        });
    }
}
