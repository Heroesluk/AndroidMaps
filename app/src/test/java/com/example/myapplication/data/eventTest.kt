package com.example.myapplication.data

import androidx.activity.viewModels
import com.example.myapplication.MainViewModel
import com.example.myapplication.R
import com.example.myapplication.UI_logic.Event
import com.example.myapplication.model.Location
import com.example.myapplication.model.Place
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EventTest {
    lateinit var viewModel: MainViewModel


    @org.junit.jupiter.api.BeforeEach
    fun setUp() {

        viewModel = MainViewModel();

    }
    @Test
    fun test1(){
        Assertions.assertEquals(viewModel.getPlaces().size ,4)
        viewModel.onEvent(Event.RemovePlaceEvent)
        Assertions.assertEquals(viewModel.getPlaces().size ,3)

    }



}
