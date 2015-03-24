/*
User activity for extending the loader to be able to call functions from
multiple extensions.

How to use:
1) Edit to import and call relevant extension code.
2) Rebuild any time you edit via s3eAndroidUserActivity_android_java.mkb
*/

package com.nickchops.s3eAndroidUserActivity;

import com.ideaworks3d.marmalade.LoaderAPI;
import com.ideaworks3d.marmalade.LoaderActivity;

// Import packages from any extensions you need to call. e.g.

// For https://github.com/nickchops/s3eAndroidFullscreen
//import com.nickchops.s3eAndroidFullscreen.s3eAndroidFullscreen;

// For https://github.com/nickchops/s3eAndroidController
//import com.nickchops.s3eAndroidController.s3eAndroidControllerActivity;
//import android.os.Bundle;
//import android.view.KeyEvent;
//import android.view.MotionEvent;

// Add calls to any extensions you are using as instructed
// s3eAndroidController and s3eAndroidFullscreen are shown as examples
// Add/comment out as needed
public class s3eAndroidUserActivity extends LoaderActivity
{
    // For s3eAndroidFullscreen
    /*
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        s3eAndroidFullscreen.onWindowFocusChanged(hasFocus);
    }
    */
    
    // For s3eAndroidController
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        s3eAndroidControllerActivity.onCreate(savedInstanceState, this);
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return s3eAndroidControllerActivity.onKeyDown(keyCode, event) ? true : super.onKeyDown(keyCode, event);
    }
    
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return s3eAndroidControllerActivity.onKeyUp(keyCode, event) ? true : super.onKeyUp(keyCode, event);
    }
    
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return s3eAndroidControllerActivity.onGenericMotionEvent(event) ? true : super.onGenericMotionEvent(event);
    }
    */
}
