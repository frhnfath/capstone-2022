package com.dicoding.githubuserfix.layout

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.githubuserfix.R
import com.dicoding.githubuserfix.notifications.NotificationBroadcast
import kotlinx.android.synthetic.main.activity_notification.*
import java.util.prefs.AbstractPreferences

class NotificationActivity : AppCompatActivity() {
    private lateinit var notificationBroadcast: NotificationBroadcast
    private lateinit var mSharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.notification_settings)
        notificationBroadcast = NotificationBroadcast()
        mSharedPreferences = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        setSwitch()
        switchNotification.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                notificationBroadcast.setNotification(
                        this,
                        NotificationBroadcast.TYPE_DAILY,
                        getString(R.string.notification_text)
                )
            } else {
                notificationBroadcast.cancelNotification(this)
            }
            saveChange(isChecked)
        }
    }

    private fun saveChange(checked: Boolean) {
        val editor = mSharedPreferences.edit()
        editor.putBoolean(REMIND, checked)
        editor.apply()
    }

    private fun setSwitch() {
        switchNotification.isChecked = mSharedPreferences.getBoolean(REMIND, false)
    }

    companion object {
        private const val REMIND = "daily"
        const val PREFERENCES_NAME = "SettingPref"
    }
}