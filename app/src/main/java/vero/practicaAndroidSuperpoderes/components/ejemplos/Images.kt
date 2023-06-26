package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vero.practicaAndroidSuperpoderes.R


@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Logo",
        alpha = 0.5f,
        modifier = Modifier.size(100.dp, 20.dp),
        contentScale = ContentScale.FillBounds
    )
}

@Preview
@Composable
private fun MyImage_Preview() {
    MyImage()
}

@Composable
fun MyImage1() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Logo",
        modifier = Modifier
            .clip(CircleShape)
            .border(BorderStroke(3.dp, Color.Blue), shape = CircleShape)
    )
}

@Preview
@Composable
private fun MyImage1_Preview() {
    MyImage1()
}

