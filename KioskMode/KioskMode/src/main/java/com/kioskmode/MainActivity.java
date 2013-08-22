package com.kioskmode;

import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"$$$ onCreate");

        collapseStatusBar();

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);

        setContentView(R.layout.activity_main);

//        marquee(((View)findViewById(R.id.hack)),getResources().getString(R.string.hello_world));
    }

    private void collapseStatusBar(){
        try{
        Object service = this.getSystemService("statusbar");
        Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
        Method collapse = null;
            Log.d(TAG,"Build version "+Build.VERSION.SDK_INT);
            if(Build.VERSION.SDK_INT > 16)
                collapse = statusbarManager.getMethod("collapsePanels");
            else
                collapse = statusbarManager.getMethod("collapse");
        collapse.setAccessible(true);
        collapse.invoke(service);
        }
        catch(InvocationTargetException e){
            e.printStackTrace();
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
        catch(NoSuchMethodException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
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

//        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
        super.onAttachedToWindow();
        Log.d(TAG,"onAttachedToWindow");
    }
}
