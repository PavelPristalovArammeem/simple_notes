package com.pripav.simplenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pripav.simplenotes.ui.theme.SimpleNotesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        EditField()
                    }
                }
            }
        }
    }
}

@Composable
fun EditField() {
    var currentText by remember { mutableStateOf("") }

    val focusRequester = FocusRequester()

    OutlinedTextField(
        value = currentText,
        onValueChange = { currentText = it },
        label = { Text(stringResource(id = R.string.remember_hint)) },
        maxLines = 3,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .focusRequester(focusRequester)
            .padding(16.dp),
        singleLine = false
    )

    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleNotesTheme {
        EditField()
    }
}
