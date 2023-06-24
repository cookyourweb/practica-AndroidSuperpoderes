package vero.practicaAndroidSuperpoderes.ui.login

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vero.practicaAndroidSuperpoderes.R




@Composable
fun LoginScreen(viewModel: LoginViewModel, onLoginFinished: () -> (Unit)) {
    val state by viewModel.state.observeAsState()
LaunchedEffect(state){
    if(state == true){
        onLoginFinished()
    }
}

    /* LoginScreenContent(state = state == true, onLoginClicked ={ email, password ->
         viewModel.doFlow()
     })*/
     LoginScreenContent(state = state == true, onLoginClicked ={ email, password ->
 viewModel.doLogin(email,password)
     })
}

//todas las vistas van a  tener su viewModel. Renombramos fun LoginScreen a LoginScreenContent y creamos un composable nuevo
@Composable
fun LoginScreenContent(state:Boolean, onLoginClicked: (String, String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppLogo()
      //  val state by viewModel.state.observeAsState() //para saber si  ha ido bien la llamada
      //  val state by viewModel.state.collectAsState() //opcion de Flow

        //estados
        if (state){
            Text(text= "Success")

        }


        /*var email by remember {
            mutableStateOf("verserper@hotmail.com")
        }
        var password by remember {
            mutableStateOf("Qwe123!") //los states soon de compose y los state flow son de compose
        }*/
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var emailValid by remember {
            mutableStateOf(false)
        }

        var passwordValid by remember {
            mutableStateOf(false)
        }

        val enabled by remember {
            derivedStateOf { emailValid && passwordValid }  //Delivered state: Es una  forma de controlar que no se repinte hasta que  la condicion no esté cumplida
        }



        FormField( email,Icons.Default.Email, isPassword = false,
            onValueChange = {
                email = it
                emailValid = it.contains("@")
        }) {
            //FormLabel("Email", TextDecoration.Underline)//Lo quito para ell testing
            FormLabel("Email", TextDecoration.None)
        }
        FormField(password,leadingIcon = Icons.Default.Password,
            trailingIcon = Icons.Default.Visibility,
            isPassword = true,
            onValueChange = {

                password = it
                passwordValid = it.length > 6
            }
            ) {
            FormLabel("Password", TextDecoration.None)
        }
        LoginButton(enabled = enabled) {
            Log.d("StateLess", "$email $password")
          //  viewModel.doLogin(user, password)
            onLoginClicked(email, password)
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
        placeholder = {
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
    // Para generar el contexto de la vista
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp).testTag("Password_tag" ).semantics(mergeDescendants = true) {
            contentDescription = "Logo de la app Android Superpoderes"
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Icon",
            Modifier
                .clip(CircleShape)
                .border(BorderStroke(3.dp, Color.Black), shape = CircleShape)
                .background(Color.Green)
        )

        Text(stringResource(R.string.app_name), style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
    }
}

@Composable
fun LoginButton(enabled: Boolean, onClick: () -> Unit) {

    Button(onClick = onClick, modifier = Modifier.padding(8.dp), enabled = enabled) {
        Text(text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScree_Preview() {
    LoginScreenContent( false){ _, _  -> }
}
