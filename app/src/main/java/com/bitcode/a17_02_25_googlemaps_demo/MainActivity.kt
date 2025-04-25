package com.bitcode.a17_02_25_googlemaps_demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bitcode.a17_02_25_googlemaps_demo.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(){
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }
}