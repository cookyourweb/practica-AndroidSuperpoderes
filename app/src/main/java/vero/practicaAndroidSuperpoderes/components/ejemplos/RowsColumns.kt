package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun RowColumnExercise() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Row(horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .background(Color.Blue)
                .size(50.dp))
            Box(modifier = Modifier
                .background(Color.Red)
                .size(100.dp))
            Box(modifier = Modifier
                .background(Color.Yellow)
                .size(150.dp))
        }

        Spacer(modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .height(20.dp))

        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier
                    .background(Color.Blue)
                    .size(50.dp))
                Box(modifier = Modifier
                    .background(Color.Red)
                    .size(100.dp))
                Box(modifier = Modifier
                    .background(Color.Yellow)
                    .size(150.dp))
            }
        }
        Spacer(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .background(Color.Black)
                .size(50.dp))
            Box(modifier = Modifier
                .background(Color.DarkGray)
                .size(50.dp))
            Box(modifier = Modifier
                .background(Color.Blue)
                .size(50.dp))
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        Row {
            Box(modifier = Modifier
                .background(Color.Green)
                .height(50.dp)
                .weight(1f))
            Box(modifier = Modifier
                .background(Color.Cyan)
                .height(50.dp)
                .weight(1f))
            Box(modifier = Modifier
                .background(Color.Magenta)
                .height(50.dp)
                .weight(1f))
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)) {
                Box(modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .weight(1f))
                Box(modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .weight(1f))
                Box(modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxWidth()
                    .weight(1f))
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(2f)) {
                Row(Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    Box(modifier = Modifier
                        .background(Color.White)
                        .fillMaxHeight()
                        .weight(1f))
                    Box(modifier = Modifier
                        .background(Color.Red)
                        .fillMaxHeight()
                        .weight(1f))
                    Box(modifier = Modifier
                        .background(Color.Yellow)
                        .fillMaxHeight()
                        .weight(1f))
                }
                Box(modifier = Modifier
                    .background(Color.Green)
                    .fillMaxWidth()
                    .weight(1f))
                Box(modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxWidth()
                    .weight(1f))
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(3f)) {
                Row(Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    Box(modifier = Modifier
                        .background(Color.Yellow)
                        .fillMaxHeight()
                        .weight(2f))
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)) {
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .fillMaxWidth()
                            .weight(1f))
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .fillMaxWidth()
                            .weight(1f))
                        Box(modifier = Modifier
                            .background(Color.Yellow)
                            .fillMaxWidth()
                            .weight(1f))
                    }
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)) {
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .fillMaxWidth()
                            .weight(1f))
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .fillMaxWidth()
                            .weight(1f))
                    }
                }
                Row(Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    Box(modifier = Modifier
                        .background(Color.White)
                        .fillMaxHeight()
                        .weight(1f))
                    Box(modifier = Modifier
                        .background(Color.White)
                        .fillMaxHeight()
                        .weight(1f))
                    Box(modifier = Modifier
                        .background(Color.Red)
                        .fillMaxHeight()
                        .weight(1f))
                }
                Box(modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .weight(1f))
            }
        }
    }//termina columa
}

@Composable
fun MyRow() {
    Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Green)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun MyRow2() {
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .weight(1.0f)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .weight(2.0f)
        )

    }
}

@Composable
fun MyRow3() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .weight(1.0f)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .weight(1.0f)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .weight(1.0f)
                .background(Color.Red)
        )
    }
}

