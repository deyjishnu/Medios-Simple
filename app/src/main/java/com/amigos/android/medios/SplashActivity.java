package com.amigos.android.medios;

import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jishnu Dey on 2/24/2017.
 */
public class SplashActivity extends AppCompatActivity {

    PrefManager prefManager;

    @Override
    protected void onStart() {
        super.onStart();

        prefManager = new PrefManager(this);

        // Checking for first time launch
        if (prefManager.isFirstTimeLaunch()) {
            // If 'First Time Launch'
            prefManager.setFirstTimeLaunch(false);
            /*TaskStackBuilder.create(this)
                    .addNextIntentWithParentStack(new Intent(this, MainActivity.class))
                    .addNextIntent(new Intent(this, IntroActivity.class))
                    .startActivities();*/

            //
            Intent intent = new Intent(this, IntroActivity.class);
            startActivity(intent);
            finish();
            //
        }

        else {
            // If not 'First Time Launch'
            //prefManager.setFirstTimeLaunch(false);
            TaskStackBuilder.create(this)
                    .addNextIntentWithParentStack(new Intent(this, MainActivity.class))
                    //.addNextIntent(new Intent(this, IntroActivity.class))
                    .startActivities();
        }

    }
}
