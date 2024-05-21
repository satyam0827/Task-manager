package com.example.taskmanager

import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskImage(
                        stringResource(id = R.string.complete_text),
                        stringResource(id = R.string.greet_text)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskImage(text1: String, text2: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ){
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription =null,
        )
        TaskText(
            text1 = text1,
            text2 = text2
        )
    }

}

@Composable
fun TaskText(text1: String, text2: String, modifier: Modifier = Modifier){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text1,
            fontWeight = FontWeight. Bold,
            textAlign = TextAlign.Center,
            modifier= Modifier.padding(top = 28.dp, bottom = 8.dp)
        )

        Text(
            text = text2,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
            )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    TaskManagerTheme {
        TaskImage(
            stringResource(id = R.string.complete_text),
            stringResource(id = R.string.greet_text)
        )
    }
}