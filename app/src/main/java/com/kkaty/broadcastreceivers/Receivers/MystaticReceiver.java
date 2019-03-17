package com.kkaty.broadcastreceivers.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import com.kkaty.broadcastreceivers.StringManipulator;

public class MystaticReceiver extends BroadcastReceiver {

    private static final String TAG = MystaticReceiver.class.getSimpleName() + "_TAG";

    TextView tvMain;

    public MystaticReceiver(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean airplaneState = intent.getBooleanExtra("state", false);
                Log.d(TAG, "onReceive: Airplane" + airplaneState);

                break;

            case Intent.ACTION_HEADSET_PLUG:
                int headsetState = intent.getIntExtra("state", -1);
                Log.d(TAG, "onReceive: Headset" + headsetState);

                break;
            case StringManipulator.ACTION_STRING_MANIPULATOR:

                String manipulatedString = intent.getStringExtra("KEY_STRING");
                Log.d(TAG, "onReceive: " + manipulatedString);
                Log.d(TAG, "onReceive: "+ Thread.currentThread().getName());
                tvMain.setText(manipulatedString);

        }

    }
}
