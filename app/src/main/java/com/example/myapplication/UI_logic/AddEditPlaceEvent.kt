package com.example.myapplication.UI_logic

import androidx.compose.ui.focus.FocusState

sealed class AddEditPlaceEvent{
    data class EnteredName(val value: String): AddEditPlaceEvent()
    data class EnteredDescription(val value: String): AddEditPlaceEvent()
    data class SavePlace(val name: String): AddEditPlaceEvent()

}

