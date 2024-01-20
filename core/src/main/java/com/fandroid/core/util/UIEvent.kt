package com.fandroid.core.util

sealed class UiEvent {
    object Success: UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackbar(val message: com.fandroid.core.util.UiText): UiEvent()
}