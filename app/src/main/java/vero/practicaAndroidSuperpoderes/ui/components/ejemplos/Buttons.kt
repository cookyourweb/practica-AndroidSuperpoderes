package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(enabled: Boolean = true) {
    Button(
        onClick = { /*TODO*/ },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.Red,
            disabledBackgroundColor = Color.Green
        ),
        border = BorderStroke(3.dp, Color.Yellow)
    ) {
        Text(text = "Click me!")
    }
}

@Preview
@Composable
private fun MyButton_Preview(){
    MyButton()
}


@Preview
@Composable
private fun MyButton_Preview_Disabled(){
    MyButton(false)
}




