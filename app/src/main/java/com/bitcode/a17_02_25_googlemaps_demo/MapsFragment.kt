package com.bitcode.a17_02_25_googlemaps_demo

import android.Manifest
import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresPermission

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions

class MapsFragment : Fragment() {

    private lateinit var gMap: GoogleMap
    private lateinit var puneMarker: Marker
    private lateinit var mumbaiMarker: Marker

    private lateinit var circle: Circle
    private lateinit var polygon: Polygon
    private lateinit var polyline: Polyline

    @SuppressLint("MissingPermission")
    private val callback = OnMapReadyCallback { googleMap -> gMap = googleMap
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        initMapSettings()
        addMarkersOnMap()
        addShapes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun initMapSettings() {
        gMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        gMap.uiSettings.isMapToolbarEnabled = true
        gMap.uiSettings.isCompassEnabled = true
        gMap.uiSettings.isTiltGesturesEnabled = true
        gMap.uiSettings.isZoomControlsEnabled = true
        gMap.isBuildingsEnabled = true
        gMap.isMyLocationEnabled = true
        gMap.isIndoorEnabled = true
    }

    fun addMarkersOnMap() {
        var bitmapImage = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background)
        puneMarker = gMap.addMarker(
            MarkerOptions().position(LatLng(18.5091, 73.8325))
                .title("Pune")
                .rotation(30.0F)
                .snippet("This is Pune!")
                .zIndex(10.0F)
                .icon(bitmapImage as BitmapDescriptor?)
        )!!

        mumbaiMarker = gMap.addMarker(
            MarkerOptions().position(LatLng(19.076, 72.877))
                .title("Mumbai")
                .zIndex(10.0F)
                .rotation(45.0F)
                .snippet("This is Mumbai!")
        )!!
    }

    fun addShapes() {
        circle = gMap.addCircle(
            CircleOptions().center(LatLng(12.9716, 77.5946))
                .radius(1000.0)
                .strokeColor(Color.MAGENTA)
                .strokeWidth(10.0F)
                .fillColor(Color.YELLOW)
                .visible(true)
                .zIndex(30.0F)
        )

        polygon = gMap.addPolygon(
            PolygonOptions()
                .add(
                    LatLng(
                        18.5204, 73.8567
                    )
                )
                .add(
                    LatLng(
                        12.9716, 77.5946
                    )
                )
                .add(
                    LatLng(
                        17.6869, 83.2185
                    )
                )
                .add(
                    LatLng(
                        21.1458, 79.0882
                    )
                )
                .strokeWidth(15.0F)
                .strokeColor(Color.RED)
                .fillColor(Color.CYAN)
                .zIndex(10.0F)
        )

        polyline = gMap.addPolyline(
            PolylineOptions()
                .add(
                    LatLng(
                        28.7041,
                        77.1024
                    )
                )

                .add(
                    LatLng(
                        26.4499,
                        80.3319
                    )
                )
                .add(
                    LatLng(
                        22.7196,
                        75.8500
                    )
                )
                .add(
                    LatLng(
                        24.5926,
                        72.7156
                    )
                )
                .add(
                    LatLng(
                        28.7041,
                        77.1024
                    )
                )
                .width(10.0F)
                .color(Color.GREEN)
        )
    }
}