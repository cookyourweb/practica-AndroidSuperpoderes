package vero.practicaAndroidSuperpoderes.components

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.Red)


    ) {


        Box(
            modifier = Modifier
                .size(100.dp)
                .background(androidx.compose.ui.graphics.Color.Blue)
                .align(Alignment.BottomCenter)
        ){
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(androidx.compose.ui.graphics.Color.White)
                    .align(Alignment.BottomCenter)
            )
        }


    }
}

@Preview
@Composable
fun BoxExercise() {
    Box(modifier = Modifier
        .size(100.dp)
        .background(androidx.compose.ui.graphics.Color.Green)) {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(androidx.compose.ui.graphics.Color.Red))

        Box(modifier = Modifier
            .align(Alignment.BottomStart)
            .width(30.dp)
            .height(30.dp)
            .background(androidx.compose.ui.graphics.Color.Black))

        Box(modifier = Modifier
            .padding(10.dp)
            .align(Alignment.CenterEnd)
            .width(20.dp)
            .height(20.dp)
            .background(androidx.compose.ui.graphics.Color.Blue))

        Box(modifier = Modifier
            .padding(10.dp)
            .align(Alignment.TopStart)
            .width(10.dp)
            .height(10.dp)
            .background(androidx.compose.ui.graphics.Color.White))

        Box(modifier = Modifier
            .padding(5.dp)
            .align(Alignment.Center)
            .width(25.dp)
            .fillMaxHeight()
            .background(androidx.compose.ui.graphics.Color.LightGray))
    }
}
