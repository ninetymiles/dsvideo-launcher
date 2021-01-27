package com.rex.launcher.dsvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        List<Intent> appList = new ArrayList<>();
        appList.add(new Intent(Intent.ACTION_MAIN).setClassName("com.synology.dsvideo", "com.synology.dsvideo.ui.WelcomeActivity"));
        appList.add(new Intent(Intent.ACTION_MAIN).setClassName("com.synology.dsvideo", "com.synology.dsvideo.SplashActivity"));

        for (Intent intent : appList) {
            if (launch(intent)) {
                break;
            }
        }
        finish();
    }

    private boolean launch(Intent intent) {
        try {
            startActivity(intent);
            return true;
        } catch (Exception ex) {
            Log.w(TAG, "Failed to launch intent - " + intent + "\n", ex);
            Toast.makeText(this, "Failed to launch intent - " + intent + "\n" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return false;
    }
}