package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyTextField(){
    var text = "texto prueba" +
        "mas  \nsalto de linea"
    TextField(value = text, onValueChange = {
        text = it
    }, leadingIcon = {
        Icon(imageVector = Icons.Default.Search, "Search")
    }, trailingIcon = {
        Icon(imageVector = Icons.Default.Close, "Close")
    }, placeholder = {
        Text("Hint")
    }, maxLines = 1, singleLine = true, keyboardOptions = KeyboardOptions())
}

@Preview(showBackground = true)
@Composable
private fun MyTextField_Preview(){
    MyTextField()
}
