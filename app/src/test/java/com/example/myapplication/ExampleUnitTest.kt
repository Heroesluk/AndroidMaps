package com.example.myapplication

import com.example.myapplication.model.Entry
import com.example.myapplication.model.Event
import com.example.myapplication.model.Place
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val entry = Entry(
            10, "Ato ramen", "Visit at ato ramen", Event("08-10-2023"), 1,
            Place("Piotrkowska")
        )


    }
}