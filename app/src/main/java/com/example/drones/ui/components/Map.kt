package com.example.drones.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.drones.R
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline

@Composable
fun OpenStreetMap(
    fromLat: Double,
    fromLng: Double,
    toLat: Double,
    toLng: Double,
    modifier: Modifier = Modifier
) {
    AndroidView(factory = { context ->
        val mapView = MapView(context)
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.setMultiTouchControls(true)
        val controller = mapView.controller

        controller.setZoom(14.5)
        controller.animateTo(GeoPoint(fromLat, fromLng))
        val fromMarker = Marker(mapView)
        val fromPoint = GeoPoint(fromLat, fromLng)
        fromMarker.position = fromPoint
        fromMarker.icon = ContextCompat.getDrawable(context, R.drawable.from_pin)
        fromMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)

        val toMarker = Marker(mapView)
        val toPoint = GeoPoint(toLat, toLng)
        toMarker.position = toPoint
        toMarker.icon = ContextCompat.getDrawable(context, R.drawable.to_pin)
        toMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)

        val polyline = Polyline(mapView)
        polyline.addPoint(fromPoint)
        polyline.addPoint(toPoint)
        mapView.overlays.add(polyline)
        mapView.overlays.add(fromMarker)
        mapView.overlays.add(toMarker)

        mapView
    }, modifier = modifier)
}