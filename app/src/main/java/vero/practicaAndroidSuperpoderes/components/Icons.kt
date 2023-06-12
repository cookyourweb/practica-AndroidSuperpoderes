package vero.practicaAndroidSuperpoderes.components

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import vero.practicaAndroidSuperpoderes.R


@Composable
fun MyIcon() {
    Icon(painter = painterResource(id = R
        .drawable.ic_launcher_foreground), contentDescription = "Logo")
    Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.Green)
}


@Preview(showBackground = true)
@Composable
private fun MyIcon_Preview() {
    MyIcon()
}
