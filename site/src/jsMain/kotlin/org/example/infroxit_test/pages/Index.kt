package org.example.infroxit_test.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier

import org.jetbrains.compose.web.css.px
import com.varabyte.kobweb.compose.ui.modifiers.padding

@Page
@Composable
fun IndexPage() {
    Column(
        modifier = Modifier.padding(20.px)
    ) {
        SpanText("Home Page")
        Link(
            path = "/todo"
        ) {
            SpanText("Go to Todo App")
        }
    }
}
