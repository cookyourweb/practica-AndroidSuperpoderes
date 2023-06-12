package vero.practicaAndroidSuperpoderes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vero.practicaAndroidSuperpoderes.houston.HoustonScreen
import vero.practicaAndroidSuperpoderes.ui.login.LoginScreen
import vero.practicaAndroidSuperpoderes.ui.theme.PracticaAndroidSuperpoderesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaAndroidSuperpoderesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_10)
@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_6)
@Composable
fun GreetingPrewiew() {
    PracticaAndroidSuperpoderesTheme{
      HoustonScreen()
        
    }
}
