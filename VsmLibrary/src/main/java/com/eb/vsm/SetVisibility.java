package com.eb.vsm;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Egorbo on 07.12.2014.
 */
public class SetVisibility extends Setter {
    private int value;

    public SetVisibility(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode())
            return;

        value = getAttributes(R.styleable.SetVisibility).getInt(R.styleable.SetVisibility_visibility, 0);
    }

    @Override
    public void apply() {
        View view = getTarget();
        view.setVisibility(value);
    }
}
