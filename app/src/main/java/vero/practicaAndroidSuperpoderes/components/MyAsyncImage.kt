package vero.practicaAndroidSuperpoderes.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

@Composable
fun MyAsyncImage() {
    var success by remember {
        mutableStateOf(false)
    }

    val painter =
        rememberAsyncImagePainter(
            model = "https://static.wikia.nocookie.net/batman/images/0/02/Facepaint.jpg/revision/latest/scale-to-width-down/1000?cb=20200207161842&path-prefix=es",
            onState = {
                Log.d("HOLA", it.toString())
                success = it is AsyncImagePainter.State.Success
            }
        )

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)) {
        Image(
            painter, contentDescription = "Joker", contentScale = ContentScale.Crop
        )
        if (!success) {
            Text(text = "Cargando", style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAsyncImage_Preview() {
    MyAsyncImage()
}
