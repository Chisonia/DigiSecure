package com.techdetect.digisecure.mapcoomponents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class GeofenceReceiver : BroadcastReceiver() {
    private lateinit var key: String
    lateinit var text: String

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            val geofencingEvent = intent?.let { GeofencingEvent.fromIntent(it) }
            val geofencingTransition = geofencingEvent?.geofenceTransition

            if (geofencingTransition == Geofence.GEOFENCE_TRANSITION_ENTER || geofencingTransition == Geofence.GEOFENCE_TRANSITION_DWELL) {
                // Retrieve data from intent
                key = intent.getStringExtra("key")!!
                text = intent.getStringExtra("message")!!

                val firebase = Firebase.database
                val reference = firebase.getReference("reminders")
                val reminderListener = object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val reminder = snapshot.getValue<Reminder>()
                        if (reminder != null) {
                            MapsActivity
                                .showNotification(
                                    context.applicationContext,
                                    "Location\nLat: ${reminder.lat} - Lon: ${reminder.lon}"
                                )
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        println("reminder:onCancelled: ${error.details}")
                    }

                }
                val child = reference.child(key)
                child.addValueEventListener(reminderListener)

                // remove geofence
                val triggeringGeofences = geofencingEvent.triggeringGeofences
                if (triggeringGeofences != null) {
                    MapsActivity.removeGeofences(context, triggeringGeofences)
                }
            }
        }
    }
}