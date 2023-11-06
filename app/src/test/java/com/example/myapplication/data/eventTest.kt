package com.example.myapplication.data

import com.example.myapplication.UI_logic.MainViewModel
import com.example.myapplication.UI_logic.PlaceEvent
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlaceEventTest {
    lateinit var viewModel: MainViewModel


    @org.junit.jupiter.api.BeforeEach
    fun setUp() {

        viewModel = MainViewModel();

    }
    @Test
    fun test1(){
        Assertions.assertEquals(viewModel.state.value.places.size ,4)
        viewModel.onEvent(PlaceEvent.RemovePlacePlaceEvent)
        Assertions.assertEquals(viewModel.state.value.places.size ,3)

    }



}
