package com.example.sms

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.telephony.SmsMessage
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MySmsReceiver : BroadcastReceiver() {
    //private var notificationManager: NotificationManagerCompat? = null

    private val importance = NotificationManager.IMPORTANCE_HIGH
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {

            for (sms : SmsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent))
            {
                Toast.makeText(context, sms.displayMessageBody,Toast.LENGTH_LONG).show()
               // val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                val notification: Notification = NotificationCompat.Builder(context, App.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_forum_)
                    .setContentTitle("SMS RECU")
                    .setContentText(sms.displayOriginatingAddress)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setAutoCancel(true)
                    .build()
                notificationManager!!.notify(1, notification)








        }
    }
}

