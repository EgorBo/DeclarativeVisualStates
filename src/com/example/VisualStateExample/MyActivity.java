package com.example.VisualStateExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MyActivity extends Activity {

    private VisualStateManager visualStateManager;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        visualStateManager = (VisualStateManager)findViewById(R.id.visualStateManager);

        visualStateManager.goToState("Guest");
        ((ImageButton)findViewById(R.id.facebookButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualStateManager.goToState("Moderator");
            }
        });
    }
}
