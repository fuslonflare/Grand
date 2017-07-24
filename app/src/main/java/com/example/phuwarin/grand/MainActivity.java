package com.example.phuwarin.grand;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity
        implements View.OnLongClickListener, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "TAG";

    private AppCompatTextView textBehavior;
    private AppCompatButton buttonMute;
    private FloatingActionButton floatingReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("LifecycleTrack", "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prototype_mockup);

        initialComponent();

        FirebaseMessaging.getInstance().subscribeToTopic("agedCare");
        Log.i("TokenTAG", FirebaseInstanceId.getInstance().getToken());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            textBehavior.setText(bundle.getString("message"));
            buttonMute.setEnabled(true);
        }
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void initialComponent() {
        textBehavior = (AppCompatTextView) findViewById(R.id.text_behavior);
        buttonMute = (AppCompatButton) findViewById(R.id.button_mute);
        floatingReport = (FloatingActionButton) findViewById(R.id.floating_report);

        buttonMute.setOnLongClickListener(this);
        floatingReport.setOnClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        if (view == buttonMute) {
            makeToast("Sound Stop");
            Log.d(TAG, "Sound Stop");
            textBehavior.setText("");
            buttonMute.setEnabled(false);
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
        Log.i("LifecycleTrack", "onStart");
        if (!textBehavior.getText().toString().equals("")) {
            Log.d(TAG, "Sound~!");
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i("LifecycleTrack", "onStop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.i("LifecycleTrack", "onPause");
        Log.d(TAG, "Sound Stop");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.i("LifecycleTrack", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("LifecycleTrack", "onResume");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.i("LifecycleTrack", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view == floatingReport) {
            startActivity(new Intent(MainActivity.this, ReportActivity.class));
        }
    }
}
