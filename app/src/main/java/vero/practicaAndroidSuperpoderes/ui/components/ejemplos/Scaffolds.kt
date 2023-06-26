package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vero.practicaAndroidSuperpoderes.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold() {
    Scaffold(topBar = {
        MyTopbar()
    }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .background(Color.Blue))
    }
}

@Composable
fun MyTopbar(){
    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription ="" )
}

@Preview
@Composable
fun MyScaffold_Preview() {
    MyScaffold()
}
