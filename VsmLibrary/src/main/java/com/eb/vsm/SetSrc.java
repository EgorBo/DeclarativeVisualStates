package com.eb.vsm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Egorbo on 07.12.2014.
 */
public class SetSrc extends Setter {
    private int resourceId;

    public SetSrc(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode())
            return;

        resourceId = getAttributes(R.styleable.SetSrc).getResourceId(R.styleable.SetSrc_src, 0);
    }

    @Override
    public void apply() {
        View view = getTarget();
        if (view instanceof ImageView){
            ((ImageView)view).setImageResource(resourceId);
        }
        if (view instanceof ImageButton){
            ((ImageButton)view).setImageResource(resourceId);
        }
    }
}
