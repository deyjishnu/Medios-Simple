package com.amigos.android.medios;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

/**
 * Created by Jishnu Dey on 2/24/2017.
 * For more details, visit: https://github.com/TangoAgency/material-intro-screen
 */

public class IntroActivity extends MaterialIntroActivity{

    private PrefManager prefManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        /*prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
                prefManager.setFirstTimeLaunch(false);
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
                finish();
        }*/

        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.first_slide_background)
                        .buttonsColor(R.color.first_slide_buttons)
                        .image(R.drawable.img_love_music)
                        .title("Do you love Music?")
                        .description("Try Medios")
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("But before that, we need a small help");
                    }
                }, "Let's start"));

        /*addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.second_slide_background)
                .buttonsColor(R.color.second_slide_buttons)
                .title("Want more?")
                .description("Go on")
                .build());

        addSlide(new CustomSlide());*/

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.third_slide_background)
                        .buttonsColor(R.color.third_slide_buttons)
                        //.possiblePermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.READ_SMS})
                        .neededPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE})
                        .image(R.drawable.img_equipment)
                        .title("We need some permissions")
                        .description("to play music")
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Yup! That's all we need");
                    }
                }, "Ok then?"));

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.fourth_slide_background)
                .buttonsColor(R.color.fourth_slide_buttons)
                .title("That's it")
                .description("Would you like to try?")
                .build());
    }

    @Override
    public void onFinish() {
        super.onFinish();
        Toast.makeText(this, "Try this library in your project! :)", Toast.LENGTH_SHORT).show();
    }
}