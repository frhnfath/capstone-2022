package com.frhnfath.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.lang.UnsupportedOperationException

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service Running...")
        return START_STICKY
    }

    companion object {
        internal val TAG = MyService::class.java.simpleName
    }
}