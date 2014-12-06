package com.example.VisualStateExample;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Egorbo on 06.12.2014.
 */
public class Setter extends View {
    private String targetProperty;
    private String value;
    private int valueId;
    private int targetResourceId;

    public Setter(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode())
            return; //http://stackoverflow.com/questions/18258719/using-custom-attributes-in-custom-views-while-in-preview-layout O_o

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Setter, 0, 0);
        targetProperty = a.getString(R.styleable.Setter_targetProperty);
        value = a.getString(R.styleable.Setter_value);
        valueId = a.getResourceId(R.styleable.Setter_refValue, 0);
        targetResourceId = a.getResourceId(R.styleable.Setter_targetId, 0);
    }

    public void apply(){
        View view = getRootView().findViewById(targetResourceId);
        PropertyHandlersRegistry.HandlePropertyChange(view, targetProperty, value, valueId);
    }
}
