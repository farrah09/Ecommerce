package com.fandroid.ecommerce

import androidx.lifecycle.ViewModel
import com.fandroid.core_ui.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel() {
    val navigationChannel = appNavigator.navigationChannel

}
