package com.eb.vsm;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Egorbo on 06.12.2014.
 */
public abstract class Setter extends View {
    private int targetResourceId;
    private Context context;
    private AttributeSet attrs;

    public Setter(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attrs = attrs;
        this.context = context;

        TypedArray a = getAttributes(R.styleable.Setter);
        targetResourceId = a.getResourceId(R.styleable.Setter_targetId, 0);
    }

    public abstract void apply();

    protected TypedArray getAttributes(int[] defStyleAttr){
        return context.getTheme().obtainStyledAttributes(attrs, defStyleAttr, 0, 0);
    }

    protected <T extends View> T getTarget(){
        return (T)getRootView().findViewById(targetResourceId);
    }
}
