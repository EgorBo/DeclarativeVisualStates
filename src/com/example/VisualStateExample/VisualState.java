package com.example.VisualStateExample;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Egorbo on 02.12.2014.
 */
public class VisualState extends ViewGroup {

    private String stateName;
    private ArrayList<Setter> setters = new ArrayList<Setter>();

    public VisualState(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode())
            return; //http://stackoverflow.com/questions/18258719/using-custom-attributes-in-custom-views-while-in-preview-layout O_o

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.VisualState, 0, 0);
        stateName = a.getString(R.styleable.VisualState_stateName);
    }

    public String getStateName(){
        return stateName;
    }

    @Override
    protected void onLayout(boolean changed, int i, int t, int r, int b) {}

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        if (child instanceof Setter){
            setters.add((Setter) child);
        }
    }

    public void go(){
        for (Setter setter : setters){
            setter.apply();
        }
    }
}
