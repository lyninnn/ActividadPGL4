package com.example.actividadpgl

import android.icu.text.UnicodeSet.SpanCondition
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividadpgl.ui.theme.ActividadPGLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkMode= remember { mutableStateOf(false) }
            ActividadPGLTheme(darkTheme = darkMode.value) {
                Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background)
                {
                    Content(darkMode=darkMode)
                }}
        }
    }
}

@Composable
fun Content(darkMode: MutableState<Boolean>){
    Column(modifier = Modifier.fillMaxWidth()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally) {
        BotonNormal()
        Space()
        BotonNormal2()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()
        Space()
        BotonSwitch()
        Space()
        DarkMode(darkMode=darkMode)
        Space()
        FloatinAction()
    }
}
@Composable
fun BotonNormal(){
    Button(onClick = {}) {
        Text(text="Mi Boton", fontSize = 30.sp)
    }
}
@Composable
fun BotonNormal2(){
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(
        containerColor = Color.Red
    )) {
        Text(text="Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonTexto(){
    TextButton(onClick = {}) {
        Text(text="Mi Boton", fontSize = 30.sp)
    }
}
@Composable
fun BotonOutline(){
    OutlinedButton(onClick = {},border = BorderStroke(3.dp,Color.Blue)) {
        Text(text="Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono(){
    IconButton(onClick = {}) {
        Icon(
            Icons.Filled.Home,
            contentDescription="Icono",
            tint= Color.Red,
            modifier = Modifier.size(50.dp)
       )
    }
}

@Composable
fun  BotonSwitch(){
    var switched by remember { mutableStateOf(false) }

    Switch(checked = switched, onCheckedChange = {switched=it},
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            checkedTrackColor = Color.Green,
            uncheckedThumbColor = Color.Blue,
            uncheckedTrackColor = Color.Magenta
        )
        )
}

@Composable
fun DarkMode(darkMode: MutableState<Boolean>){
    Button(onClick = {darkMode.value=!darkMode.value}) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "DarkMode")
        Spacer(modifier = Modifier.width(5.dp))
        Text(text= "Dark Mode", fontSize = 30.sp)
    }
}

@Composable
fun FloatinAction(){
    FloatingActionButton(onClick = {/*TODO*/},
        containerColor =Color.Blue,
        contentColor=Color.White
        ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
    }
}


@Composable
fun Space(){
    Spacer(modifier = Modifier.height(10.dp))
}