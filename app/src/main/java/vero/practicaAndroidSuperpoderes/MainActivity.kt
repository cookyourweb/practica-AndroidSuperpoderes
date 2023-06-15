package vero.practicaAndroidSuperpoderes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import dagger.hilt.android.AndroidEntryPoint
import vero.practicaAndroidSuperpoderes.components.MyCards
import vero.practicaAndroidSuperpoderes.components.MyImage
import vero.practicaAndroidSuperpoderes.components.MyLazyColumn
import vero.practicaAndroidSuperpoderes.components.MyLazyGrid
import vero.practicaAndroidSuperpoderes.components.MyRow2
import vero.practicaAndroidSuperpoderes.components.MyRow3
import vero.practicaAndroidSuperpoderes.components.MyScaffold
import vero.practicaAndroidSuperpoderes.houston.HoustonScreen
import vero.practicaAndroidSuperpoderes.ui.login.LoginScreen
import vero.practicaAndroidSuperpoderes.ui.login.LoginViewModel
import vero.practicaAndroidSuperpoderes.ui.theme.PracticaAndroidSuperpoderesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaAndroidSuperpoderesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   LoginScreen(viewModel)
                }
            }
        }
    }
}

