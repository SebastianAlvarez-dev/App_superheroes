package com.example.app_superheores_sebas

import com.example.app_superheores_sebas.model.HeroesRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test fun heroesHaveUniqueResourcesAndIncludeSebasgod() {
        val heroes = HeroesRepository.heroes
        assertEquals(7, heroes.size)
        assertEquals(7, heroes.map { it.nameRes }.distinct().size)
        assertEquals(7, heroes.map { it.imageRes }.distinct().size)
        assertTrue(heroes.all { it.nameRes != 0 && it.descriptionRes != 0 && it.imageRes != 0 })
        assertEquals(R.string.hero_sebasgod, heroes.last().nameRes)
    }
}
