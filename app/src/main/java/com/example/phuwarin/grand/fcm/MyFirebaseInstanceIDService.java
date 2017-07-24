package com.example.phuwarin.grand.fcm;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Phuwarin on 2/15/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this,
                "Firebase Token = " + refreshedToken,
                Toast.LENGTH_SHORT)
                .show();
        Log.i(TAG, refreshedToken);
    }
}
