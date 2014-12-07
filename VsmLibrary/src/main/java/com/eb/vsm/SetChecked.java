package com.eb.vsm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;

/**
 * Created by Egorbo on 07.12.2014.
 */
public class SetChecked extends Setter {

    private final boolean checked;

    public SetChecked(Context context, AttributeSet attrs) {
        super(context, attrs);
        checked = getAttributes(R.styleable.SetChecked).getBoolean(R.styleable.SetChecked_checked, false);
    }

    @Override
    public void apply() {
        View view = getTarget();
        if (view instanceof CheckBox){
            ((CheckBox)view).setChecked(checked);
        }
        if (view instanceof RadioButton){
            ((RadioButton)view).setChecked(checked);
        }
        if (view instanceof Switch){
            ((Switch)view).setChecked(checked);
        }
    }
}
