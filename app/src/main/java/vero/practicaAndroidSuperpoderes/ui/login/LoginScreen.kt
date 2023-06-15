package vero.practicaAndroidSuperpoderes.ui.login

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import vero.practicaAndroidSuperpoderes.R


@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppLogo()
        val state by viewModel.state.observeAsState() //para saber si  ha ido bien la llamada
      //  val state by viewModel.state.collectAsState() //opcion de Flow

        //estados
        if (state == true){

        }


        var textemail by remember {
            mutableStateOf("")
        }
        var textpassword by remember {
            mutableStateOf("") //los states soon de compose y los state flow son de compose
        }

        FormField( textemail,Icons.Default.Email, isPassword = false,
            onValueChange = { textemail =  it
        }) {
            FormLabel("Email", TextDecoration.Underline)
        }
        FormField(textpassword,leadingIcon = Icons.Default.Password,
            trailingIcon = Icons.Default.Visibility,
            isPassword = true,
            onValueChange = { textpassword =  it
            }
            ) {
            FormLabel("Password", TextDecoration.LineThrough)
        }
        LoginButton(enabled = true) {
            Log.d("StateLess", "$textemail $textpassword")
           // viewModel.doLogin(textemail, textpassword)
        }
    }
}

@Composable
fun FormLabel(hint: String, textDecoration: TextDecoration) {
    Text(text = hint, textDecoration = textDecoration)
}

@Composable
fun FormField(
text: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector? = null,
    isPassword: Boolean = false,
    onValueChange:(String) -> (Unit),

    label: (@Composable () -> (Unit))? = null
) {


    var passwordVisible = false
    TextField(
        value = text,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = leadingIcon.name)
        },
        trailingIcon = {
            trailingIcon?.let {
                Icon(imageVector = it, contentDescription = trailingIcon.name)
            }
        },
        label = {
            if (label != null) {
                label()
            }
        },
        visualTransformation = if (isPassword) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )

}

@Preview
@Composable
fun AppLogo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Icon",
            Modifier
                .clip(CircleShape)
                .border(BorderStroke(3.dp, Color.Black), shape = CircleShape)
                .background(Color.Green)
        )

        Text("Android Superpoderes", style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
    }
}

@Composable
fun LoginButton(enabled: Boolean, onClick: () -> Unit) {

    Button(onClick = onClick, modifier = Modifier.padding(8.dp), enabled = enabled) {
        Text(text = "Login")
    }
}
/*
@Preview(showBackground = true)
@Composable
fun LoginScree_Preview() {
    LoginScreen()
}*/
