package com.fandroid.weather_data.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LocationService @Inject constructor(
    private val context: Context,
    private val permissionManager: PermissionManager
) {

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    private val locationRequest: LocationRequest by lazy {
        LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 10000 // Update location every 10 seconds
            fastestInterval = 5000 // Fastest update interval (in milliseconds)
        }
    }

    @SuppressLint("MissingPermission")
    suspend fun getCurrentLocation(): Location {
        if (!permissionManager.isLocationPermissionGranted()) {
            throw LocationPermissionException("Location permission not granted")
        }

        return withContext(Dispatchers.Main) {
            suspendCancellableCoroutine { continuation ->
                fusedLocationClient.requestLocationUpdates(
                    locationRequest,
                    object : LocationCallback() {
                        override fun onLocationResult(locationResult: LocationResult) {
                            val location = locationResult.lastLocation
                            if (location != null) {
                                fusedLocationClient.removeLocationUpdates(this)
                                continuation.resume(location)
                            } else {
                                continuation.resumeWithException(LocationNotAvailableException("Location not available"))
                            }
                        }

                        override fun onLocationAvailability(locationAvailability: LocationAvailability) {
                            if (!locationAvailability.isLocationAvailable) {
                                fusedLocationClient.removeLocationUpdates(this)
                                continuation.resumeWithException(LocationNotAvailableException("Location not available"))
                            }
                        }
                    },
                    Looper.getMainLooper()
                )
            }
        }
    }


        // Custom exceptions
    class LocationNotAvailableException(message: String) : Exception(message)
    class LocationPermissionException(message: String) : Exception(message)
}

