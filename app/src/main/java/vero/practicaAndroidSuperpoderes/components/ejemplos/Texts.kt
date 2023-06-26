package vero.practicaAndroidSuperpoderes.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MyText() {
    Text(text = "Hola")
}

@Preview(showBackground = true)
@Composable
fun MyText1() {
    Text(
        text = "Hola",
        fontSize = 20.sp,
        color = Color.Blue,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    )
}


@Preview(showBackground = true)
@Composable
fun MyText2() {
    Text(
        text = "Hola",
        style = MaterialTheme.typography.h4.copy(color = Color.Blue)
    )
}

