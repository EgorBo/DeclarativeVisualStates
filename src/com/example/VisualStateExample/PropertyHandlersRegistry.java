package com.example.VisualStateExample;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.InvalidParameterException;
import java.util.HashMap;

/**
 * Created by Egorbo on 06.12.2014.
 */
public class PropertyHandlersRegistry {

    private static HashMap<String, PropertyHandler> propertyHandlers = new HashMap<String, PropertyHandler>();

    static {
        /*
        * Built-in handlers:
        * */
        AddHandler("visibility", new PropertyHandler(){
            @Override
            public void Handle(View view, String value, int valueId) {
                if (value.equalsIgnoreCase("VISIBLE")) view.setVisibility(View.VISIBLE);
                else if (value.equalsIgnoreCase("INVISIBLE")) view.setVisibility(View.INVISIBLE);
                else if (value.equalsIgnoreCase("GONE")) view.setVisibility(View.GONE);
            }
        });
        AddHandler("text", new PropertyHandler(){
            @Override
            public void Handle(View view, String value, int valueId) {
                if (view instanceof TextView){
                    ((TextView)view).setText(value);
                }
                if (view instanceof EditText){
                    ((EditText)view).setText(value);
                }
            }
        });
        AddHandler("src", new PropertyHandler() {
            @Override
            public void Handle(View view, String value, int valueId) {
                if (view instanceof ImageView){
                    ((ImageView)view).setImageResource(valueId);
                }
                if (view instanceof ImageButton){
                    ((ImageView)view).setImageResource(valueId);
                }
            }
        });
    }

    public static void AddHandler(String propertyName, PropertyHandler handler){
        propertyHandlers.put(propertyName, handler);
    }

    public static void HandlePropertyChange(View view, String propertyName, String stringValue, int valueId){
        PropertyHandler handler = propertyHandlers.get(propertyName);
        if (handler != null) {
            handler.Handle(view, stringValue, valueId);
        } else {
            throw new InvalidParameterException("handler for this property is not registered");
        }
    }
}
