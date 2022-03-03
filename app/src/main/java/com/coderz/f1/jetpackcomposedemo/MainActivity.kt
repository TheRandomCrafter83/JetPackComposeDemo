package com.coderz.f1.jetpackcomposedemo

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.coderz.f1.jetpackcomposedemo.ui.theme.JetPackComposeDemoTheme

val Items:ArrayList<Item> = ArrayList()
lateinit var context: Context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    context = LocalContext.current
                    loadList()
                    MyList()
                }
            }
        }
    }
}

fun loadList(){
    for (i in 1..100){
        Items.add(Item("Item $i"))
    }
}

@Composable
fun MyList(){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
    ){
        itemsIndexed(Items){_, item->
            Text(item.Text, modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        Toast.makeText(context,item.Text,Toast.LENGTH_SHORT).show()
                    } ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeDemoTheme {
        loadList()
        MyList()
    }
}