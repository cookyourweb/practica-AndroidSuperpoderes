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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        //los modifiers son comportamiiento y apariencia que se puede ver
        //se van concatenando los modifiers y cuando tengo el objeto lo construyo con el builld
        modifier = modifier.background(Color.Green).padding(36.dp).background(Color.Red).clickable { Log.d("CLICK", "CLICK PANTALLA") },
        color = Color.White

    )
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_10)
@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_6)
@Composable
fun GreetingPrewiew() {
    PracticaAndroidSuperpoderesTheme{
        Greeting(name ="Android" )
        
    }
}

@Preview
@Composable
fun GreetingPreview2() {
    PracticaAndroidSuperpoderesTheme {
        Greeting("Ios")
    }


}