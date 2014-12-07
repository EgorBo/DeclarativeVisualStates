package com.eb.vsm;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.security.InvalidParameterException;
import java.util.HashMap;

/**
 * Created by Egorbo on 02.12.2014.
 */
public class VisualStateManager extends ViewGroup {

    private String defaultStateName;
    private boolean needsSetupDefaultState = false;
    private HashMap<String, VisualState> visualStates = new HashMap<String, VisualState>();
    private String currentState;
    private OnStateChangeListener onStateChangeListener;

    public VisualStateManager(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.VisualStateManager, 0, 0);
        defaultStateName = a.getString(R.styleable.VisualStateManager_defaultStateName);
        needsSetupDefaultState = !TextUtils.isEmpty(defaultStateName);
    }

    @Override
    public void addView(View child, LayoutParams params) {
        super.addView(child, params);
        if (child instanceof VisualState){
            VisualState vs = (VisualState)child;
            String stateName = vs.getStateName();
            visualStates.put(stateName, vs);
        }
    }

    @Override
    protected void onLayout(boolean b, int i, int i2, int i3, int i4) {
        if (needsSetupDefaultState){
            needsSetupDefaultState = false;
            goToState(defaultStateName);
        }
    }

    public void goToState(String stateName){
        String prevState = currentState;
        currentState = stateName;
        VisualState state = visualStates.get(stateName);
        if (state == null){
            throw new InvalidParameterException("state was not found");
        }
        state.go();

        if (onStateChangeListener != null){
            onStateChangeListener.onStateChanged(prevState, stateName);
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener){
        this.onStateChangeListener = onStateChangeListener;
    }

    public String getCurrentState(){
        return currentState;
    }
}
