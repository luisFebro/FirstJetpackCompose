package com.febro.firstjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.febro.firstjetpackcompose.ui.theme.FirstJetpackComposeTheme

// ref: https://www.youtube.com/watch?v=6_wK_Ud8--0&t=3s
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var name by remember {
                mutableStateOf("")
            }

            var names by remember {
                mutableStateOf(listOf<String>())
            }

            FirstJetpackComposeTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(value = name, onValueChange = { text -> name = text }, modifier = Modifier
                            .weight(1f)
                            .border(3.dp, Color.Black, RectangleShape))
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if(name.isNotBlank()) {
                                names = names + name
                                name = ""
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }

                    NameList(names = names, Modifier.fillMaxSize())
                }
            }
        }
    }
}

// Reusable Components
@Composable
fun NameList(
    names: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(names) { currentName ->
            Text(
                text = currentName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Divider(modifier = Modifier.border(1.dp, Color.LightGray, RectangleShape))
        }
    }
}


@Composable
fun ButtonCounter() {
    // Remember the value produced by calculation. calculation will only be evaluated during the composition. Recomposition will always return the value produced by composition.
    // by is used to avoid writing count.value every single time when retrieving the current state
    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString(), fontSize = 30.sp)
        Button(onClick = {
            count++
        }) {
            Text(text = "Click me!")
        }
    }
}

@Composable
fun Greeting(name: String) {
    // LazyRow
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) { i ->
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
    }
    // Column
    // Row
//    Box(
//        // Box
//        contentAlignment = Alignment.Center,
//        // Column
////        horizontalAlignment = Alignment.CenterHorizontally,
////        verticalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .background(Color.LightGray)
//            .size(400.dp),
//    ) {
//        Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.align(
//            Alignment.TopEnd).size(150.dp))
//
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = null,
//            modifier = Modifier
//                .background(Color.Black)
//                .align(Alignment.TopStart)
//        )
//
//        Text(
//            text = "Hello $name!",
//            fontSize = 30.sp,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(16.dp)
//                .align(Alignment.BottomEnd)
//        )
//        Text(
//            text = "Some other Text",
//            fontSize = 30.sp,
//            color = Color.DarkGray,
//        )
//    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstJetpackComposeTheme {

    }
}