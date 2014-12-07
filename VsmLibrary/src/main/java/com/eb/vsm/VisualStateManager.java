package com.eb.vsm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Egorbo on 02.12.2014.
 */
public class VisualStateManager extends ViewGroup {

    private HashMap<String, VisualState> visualStates = new HashMap<String, VisualState>();

    public VisualStateManager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        if (child instanceof VisualState){
            VisualState vs = (VisualState)child;
            visualStates.put(vs.getStateName(), vs);
        }
    }

    @Override
    protected void onLayout(boolean b, int i, int i2, int i3, int i4) {}

    public void goToState(String stateName){
        VisualState state = visualStates.get(stateName);
        if (state == null){
            throw new InvalidParameterException("state was not found");
        }
        state.go();
    }
}
