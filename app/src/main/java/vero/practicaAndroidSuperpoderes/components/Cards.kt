package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vero.practicaAndroidSuperpoderes.R


@Composable
fun MyCards() {
    Card(colors = CardDefaults.cardColors()){
        Column {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription ="" )
            Text("Hola", modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCards_Preview() {
    MyCards()
}
