package com.example.myage

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myage.ui.theme.MyAgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAgeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyComponent()
                }
            }
        }
    }
}

@Composable
fun MyComponent() {

    var age = remember {
        mutableStateOf(0)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()

    ){
        Text(
            text = "Qual é sua idade?",
            color = Color(0XFFED4D2D),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Pressione os botões para informar sua idade?",
            fontSize = 14.sp,
            color = Color(0XFF666666),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Black,
//            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Text(
            text = "${age.value}",
            color = Color(0XFF666666),
            fontSize = 50.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(25.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
            ) {


            Button(
                onClick = {
                        age.value--
                                              },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFED4D2D)),
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "-",
                    fontSize = 40.sp

                )
            }
            Spacer(
                modifier = Modifier.width(20.dp)
            )

            Button(
                onClick = {
                          age.value++
                          Log.i("MyAge", "MyAge: ${age.value}")
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFED4D2D)),
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 40.sp
                )
            }

        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun MyPreviewComponent() {
    MyComponent()
}