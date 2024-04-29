package com.techdetect.digisecure.mapcoomponents

data class Reminder(
    var key: String = "",
    var lat: Double = 0.0,
    var lon: Double = 0.0,
    var phoneName: String = "",
    var modelNumber: String = "",
    var serialNumber: String = "",
)