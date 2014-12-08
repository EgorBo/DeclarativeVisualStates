DeclarativeVisualStates
=======================

Imagine we have a view of some user's profile and this view may be sligtly different depending on current user's role (guest, member or moderator), in other words the view has three similiar states:

![Alt text](http://habrastorage.org/files/f43/cbc/03f/f43cbc03f9214660bedef583cbead60f.png)

How will you design it? Three different activities? Extract common UI into fragments? One single layout and control visibility via code? I suggest a solution where you can declare those states in a single layout xml file and just call goToState(i.e. "Moderator") in code (moving shit from code into xml). This approach is similiar to C# VisualStateManager we have in XAML world.

[Code](https://github.com/EgorBo/DeclarativeVisualStates/blob/master/app/src/main/java/com/eb/vsm/app/MainActivity.java) now looks clean!
```java
public class MainActivity extends Activity {

    private VisualStateManager visualStateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visualStateManager = (VisualStateManager)findViewById(R.id.visualStateManager);

        //init view with "guest" state.
        visualStateManager.goToState("Guest");

        //go to "moderator" state on FB button click
        ((ImageButton)findViewById(R.id.facebookButton)).setOnClickListener(
            new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualStateManager.goToState("Moderator");
            }
        });
    }
}
```

[Xml](https://github.com/EgorBo/DeclarativeVisualStates/blob/master/app/src/main/res/layout/activity_main.xml):

```xml
<Button android:id="@+id/banButton" android:visibility="gone"
        android:layout_width="250dp"  android:layout_height="wrap_content"
        android:text="Ban"/>

<ImageButton android:id="@+id/facebookButton" android:visibility="visible"
             android:layout_width="250dp" android:layout_height="60dp"
             android:background="@null" android:src="@drawable/fb" 
             android:scaleType="fitXY" />

<com.eb.vsm.VisualStateManager android:id="@+id/visualStateManager" style="@style/vsm">

    <!--GUEST state-->
    <com.eb.vsm.VisualState style="@style/vsm" vs:stateName="Guest">
        <com.eb.vsm.SetText style="@style/vsm"
                            vs:targetId="@id/status"
                            vs:text="You entered as guest"/>
        <com.eb.vsm.SetVisibility style="@style/vsm"
                                  vs:targetId="@id/addToFriendsButton"
                                  vs:visibility="gone"/>
        <com.eb.vsm.SetVisibility style="@style/vsm"
                                  vs:targetId="@id/banButton"
                                  vs:visibility="gone"/>
        <com.eb.vsm.SetVisibility style="@style/vsm"
                                  vs:targetId="@id/facebookButton"
                                  vs:visibility="visible"/>
        <com.eb.vsm.SetSrc style="@style/vsm"
                           vs:targetId="@id/photo"
                           vs:src="@drawable/unknown_avatar"/>
    </com.eb.vsm.VisualState>

    <!--MEMBER state-->
    <com.eb.vsm.VisualState style="@style/vsm" vs:stateName="Member">
        <com.eb.vsm.SetText style="@style/vsm"
                            vs:targetId="@id/status"
                            vs:text="You entered as member"/>
        <com.eb.vsm.SetVisibility style="@style/vsm"
                                  vs:targetId="@id/addToFriendsButton"
                                  vs:visibility="visible"/>
```
