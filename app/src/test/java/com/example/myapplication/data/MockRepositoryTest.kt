package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.Entry
import com.example.myapplication.model.Place
import org.junit.jupiter.api.Assertions

class MockRepositoryTest {
    lateinit var mockRepository: MockRepository

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
        mockRepository = MockRepository(
            mutableListOf(
                Entry(
                    0,
                    "Tower",
                    "High tower",
                    "21-10-2023",
                    1,
                    Place(0, "Street 10"),
                    R.drawable.ramen
                ),
                Entry(
                    1,
                    "Castle",
                    "Big Castle",
                    "21-11-2023",
                    5,
                    Place(1, "10,10"),
                    R.drawable.ramen
                ),
                Entry(
                    2,
                    "Restaurant",
                    "Good food",
                    "Plan to visit",
                    4,
                    Place(2, "Poland"),
                    R.drawable.ramen
                ),
                Entry(
                    3,
                    "Lake",
                    "Smell bad",
                    "Past",
                    2,
                    Place(3, "France"),
                    R.drawable.ramen
                ),

                )
        )

    }

    @org.junit.jupiter.api.Test
    fun getEntry() {
        // given
        var place0 = Entry(
            0,
            "Tower",
            "High tower",
            "21-10-2023",
            1,
            Place(0, "Street 10"),
            R.drawable.ramen
        )

        var place1 = Entry(
            1,
            "Castle",
            "Big Castle",
            "21-11-2023",
            5,
            Place(1, "10,10"),
            R.drawable.ramen
        )
        // when
        var repoPlace0 = mockRepository.getEntry(0)
        var repoPlace1 = mockRepository.getEntry(1)

        // then
        Assertions.assertEquals(repoPlace0, place0)
        Assertions.assertEquals(repoPlace1, place1)
    }

    @org.junit.jupiter.api.Test
    fun getEntries() {
        // when
        val places = mockRepository.getEntries()
        // then
        Assertions.assertEquals(places.size, 4)
    }

    @org.junit.jupiter.api.Test
    fun saveEntry() {
        // given
        var entry = Entry(
            7,
            "ABC",
            "ASASA tower",
            "21-10-2023",
            1,
            Place(0, "Street 10"),
            R.drawable.ramen
        )
        var entryIdExists = Entry(
            1,
            "ABSASAC",
            "ASASA tower",
            "21-10-2023",
            1,
            Place(0, "Street 10"),
            R.drawable.ramen
        )
        // then
        Assertions.assertTrue(mockRepository.saveEntry(entry))
        Assertions.assertFalse(mockRepository.saveEntry(entryIdExists))

    }

    @org.junit.jupiter.api.Test
    fun deleteEntry() {
    }

    @org.junit.jupiter.api.Test
    fun replaceEntry() {
    }

    @org.junit.jupiter.api.Test
    fun passAndEdit(){
        var test1 = Test1()
        Assertions.assertEquals(mockRepository.getEntries().size,4)
        test1.editRepository(mockRepository)
        Assertions.assertEquals(mockRepository.getEntries().size,3)
    }
}


class Test1 {
    public fun editRepository(repo: MockRepository){
        repo.deleteEntry(0);

    }
}