package com.eb.vsm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Egorbo on 07.12.2014.
 */
public class SetEnabled extends Setter {
    private boolean value;

    public SetEnabled(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode())
            return;

        value = getAttributes(R.styleable.SetEnabled).getBoolean(R.styleable.SetEnabled_enabled, false);
    }

    @Override
    public void apply() {
        View view = getTarget();
        view.setEnabled(value);
    }
}
