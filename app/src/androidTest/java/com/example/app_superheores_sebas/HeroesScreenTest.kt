package com.example.app_superheores_sebas

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToNode
import com.example.app_superheores_sebas.model.HeroesRepository
import com.example.app_superheores_sebas.ui.theme.SuperheroesTheme
import org.junit.Rule
import org.junit.Test

class HeroesScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test fun lightThemeCanScrollToSebasgod() = checkHeroes(false)
    @Test fun darkThemeCanScrollToSebasgod() = checkHeroes(true)

    private fun checkHeroes(darkTheme: Boolean) {
        composeRule.setContent {
            SuperheroesTheme(darkTheme = darkTheme) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    HeroesList(HeroesRepository.heroes)
                }
            }
        }
        composeRule.onNodeWithText("Nick the Night and Day").assertIsDisplayed()
        composeRule.onNode(hasScrollAction())
            .performScrollToNode(androidx.compose.ui.test.hasText("Sebasgod"))
        composeRule.onNodeWithText("Sebasgod").assertIsDisplayed()
        composeRule.onNodeWithText("Domina Kotlin y derrota bugs con su poder legendario.")
            .assertIsDisplayed()
    }
}
