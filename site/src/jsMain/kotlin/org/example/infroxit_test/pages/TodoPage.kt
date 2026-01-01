package org.example.infroxit_test.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

import org.jetbrains.compose.web.css.rgb

import org.example.infroxit_test.Todo

@Page("/todo")
@Composable
fun TodoPage() {
    var todos by remember { mutableStateOf(listOf<Todo>()) }
    var newTodoText by remember { mutableStateOf("") }

    fun addTodo() {
        if (newTodoText.isNotBlank()) {
            todos = todos + Todo(
                id = todos.size + 1,
                text = newTodoText.trim()
            )
            newTodoText = ""
        }
    }

    Column(
        modifier = Modifier
            .maxWidth(400.px)
            .padding(16.px)
            .gap(24.px)
    ) {
        TextInput(
            text = newTodoText,
            onTextChange = { newTodoText = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.px)
                .borderRadius(8.px)
                .padding(8.px)
        )

        Button(
            onClick = { addTodo() },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.px)
        ) {
            SpanText("Add Todo")
        }

        Column(
            modifier = Modifier
                .gap(8.px)
                .padding(top = 12.px)
        ) {
            for (todo in todos) {
                SpanText(
                    "- ${todo.text}",
                    modifier = Modifier
                        .backgroundColor(rgb(211, 211, 211))  // LightGray color
                        .padding(8.px)
                        .borderRadius(6.px)
                )

            }
        }
    }
}
