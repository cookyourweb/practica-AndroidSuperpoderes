package vero.practicaAndroidSuperpoderes.houston

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HoustonScreen2(){
    var counter = 0

    Log.d("HOUSTON_FUERA", counter.toString())

    Button(onClick = {
        Log.d("HOUSTON_ANTES", counter.toString())
        counter += 1
        Log.d("HOUSTON_DESPUES", counter.toString())
    }) {
        Text(text = counter.toString())
    }
}

@Composable
fun HoustonScreen3(){
    val counter = mutableStateOf<Int>(0)

    Log.d("HOUSTON_FUERA", counter.value.toString())

    Button(onClick = {
        Log.d("HOUSTON_ANTES", counter.value.toString())
        counter.value = counter.value + 1
        Log.d("HOUSTON_DESPUES", counter.value.toString())
    }) {
        Text(text = counter.value.toString())
    }
}

@Composable
fun HoustonScreenv3(){
    val counter = remember{
        mutableStateOf(0)
    }

    Log.d("HOUSTON_FUERA", counter.value.toString())

    Button(onClick = {
        Log.d("HOUSTON_ANTES", counter.value.toString())
        counter.value = counter.value + 1
        Log.d("HOUSTON_DESPUES", counter.value.toString())
    }) {
        Text(text = counter.value.toString())
    }
}

@Composable
fun HoustonScreen(){
    var counter by rememberSaveable{
        mutableStateOf(0)
    }

    Log.d("HOUSTON_FUERA", counter.toString())

    Button(onClick = {
        Log.d("HOUSTON_ANTES", counter.toString())
        counter += 1
        Log.d("HOUSTON_DESPUES", counter.toString())
    }) {
        Text(text = counter.toString())
    }
}

@Preview
@Composable
fun HoustonScreen_Preview(){
    HoustonScreen()
}
