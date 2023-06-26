package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vero.practicaAndroidSuperpoderes.ui.login.AppLogo


@Composable
fun MyLazyColumn() {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {

        item {
            Text(
                text = "Listado de elementos",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        items(10) {
            Text(
                "Elemento $it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }

        item {
            Text(
                text = "Listado de elementos",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        items(10) {
            Text(
                "Elemento $it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }


        item {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Cargar más")
            }
        }
    }
}

@Composable
fun MyLazyColumn2() {
    Column(Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)){
            item {
                Text(
                    text = "Listado de elementos",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            items(10) {
                Text(
                    "Elemento $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }

        LazyColumn(modifier = Modifier.weight(1f)){
            item {
                Text(
                    text = "Listado de elementos 2",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            items(10) {
                Text(
                    "Elemento otro $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyLazyColumn_Preview2() {
    MyLazyColumn2()
}

@Composable
fun MyLazyColumn3() {
    Column(Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)){
            item {
                Text(
                    text = "Listado de elementos",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            items(10) {
                LazyRow{
                    items(10){
                        AppLogo()
                    }
                }
            }
        }

        LazyColumn(modifier = Modifier.weight(1f)){
            item {
                Text(
                    text = "Listado de elementos 2",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            items(10) {
                Text(
                    "Elemento otro $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyLazyColumn_Preview3() {
    MyLazyColumn3()
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyLazyColumn_Preview() {
    MyLazyColumn()
}
