package com.fandroid.weather_presentation.welcome

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WelcomeScreen() {

    val viewModel: WelcomeViewModel = hiltViewModel()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ){ permissions ->

        if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        ) {
            viewModel.onPermissionGranted()
        } else {
            viewModel.onPermissionDenied()
        }

    }


    Text(text = "telcome", modifier = Modifier.size(18.dp))

    if(!viewModel.isLocationPermissionGranted()){
        SideEffect {
            launcher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION))
        }

    }else{
        viewModel.onPermissionGranted()
    }


}

@Composable
@Preview
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
