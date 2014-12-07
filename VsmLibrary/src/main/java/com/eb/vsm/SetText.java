package com.eb.vsm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Egorbo on 07.12.2014.
 */
public class SetText extends Setter {
    private String text;

    public SetText(Context context, AttributeSet attrs) {
        super(context, attrs);

        text = getAttributes(R.styleable.SetText).getString(R.styleable.SetText_text);
    }

    @Override
    public void apply() {
        View view = getTarget();
        if (view instanceof TextView) {//kotlin's smart-cast rules!
            ((TextView)view).setText(text);
        }
        if (view instanceof EditText) {
            ((EditText)view).setText(text);
        }
    }
}
