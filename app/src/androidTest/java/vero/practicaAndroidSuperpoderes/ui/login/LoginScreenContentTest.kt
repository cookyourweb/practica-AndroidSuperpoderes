package vero.practicaAndroidSuperpoderes.ui.login



import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import vero.practicaAndroidSuperpoderes.ui.login.LoginScreenContent
import org.junit.Rule
import org.junit.Test

class LoginScreenContentTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun given_empty_fieldWhenCorrectDataThenEnableLoginButton(){
        // Given
        composeRule.setContent {
            LoginScreenContent(state = false, onLoginClicked = {_,_ ->})
        }
        Thread.sleep(3000)

        // When
        Thread.sleep(3000)
        // WHEN
        composeRule.onNodeWithText("Email").performTextInput("juanje@jj.com")
        composeRule.onNodeWithText("Password").performTextInput("12345678")

        Thread.sleep(3000)
        // THEN
        composeRule.onNodeWithText("Login").assertIsEnabled()
    }

    @Test
    fun given_empty_fieldWhen_Incorrect_DataThenDisableLoginButton(){
        with(composeRule){
            // Given
            setContent {
                LoginScreenContent(state = false, onLoginClicked = {_,_ ->})
            }
            Thread.sleep(3000)

            // When
            Thread.sleep(3000)
            // WHEN
            onNodeWithText("Email").performTextInput("juanje")
            onNodeWithText("Password").performTextInput("12345678")

            Thread.sleep(3000)
            // THEN
            onNodeWithText("Login").assertIsNotEnabled()
        }
    }

    @Test
    fun given_screen_when_launched_then_logo_is_displayed() {
        with(composeRule){
            setContent {
                LoginScreenContent(state = false, onLoginClicked = {_,_ ->})
            }

            onNodeWithContentDescription("App Icon").assertIsDisplayed()
        }
    }

    @Test
    fun given_screen_when_launched_then_password_visible_icon_is_displayed_and_enabled() {
        with(composeRule){
            setContent {
                LoginScreenContent(state = false, onLoginClicked = {_,_ ->})
            }

            onNodeWithTag("Password_tag").assertExists().assertIsDisplayed().assertIsEnabled()
        }
    }

    @Test
    fun multiple_selecction() {
        with(composeRule){
            setContent {
                LoginScreenContent(state = false, onLoginClicked = {_,_ ->})
            }

            onAllNodesWithText("Password_tag")
        }
    }

}
