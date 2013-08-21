package com.kioskmode;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
//        marquee(((View)findViewById(R.id.hack)),getResources().getString(R.string.hello_world));
    }

    private void marquee(final View view,String text){
          if(view instanceof TextView){





                          TextView tv = (TextView)view;
                          String s = tv.getText().toString();
                          tv.setText(s+"\n"+getResources().getString(R.string.hello_world));




          }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onAttachedToWindow() {

        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
        super.onAttachedToWindow();
    }


    
}
