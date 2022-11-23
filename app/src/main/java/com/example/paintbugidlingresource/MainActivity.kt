package com.example.paintbugidlingresource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.paintbugidlingresource.ui.theme.PaintBugIdlingResourceTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaintBugIdlingResourceTheme {
                LazyColumnList()
            }
        }
    }
}

@Composable
fun LazyColumnList() {
    val list = listOf("A", "B", "C", "D")
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = list, itemContent = {
            ListItem()
        })
    }
}

@Composable
fun ListItem() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        val (statusIconRef, statusRef) = createRefs()

        // Commenting this Chain block makes the idling resource be resolved correctly.
        createHorizontalChain(
            statusIconRef,
            statusRef,
            chainStyle = ChainStyle.Packed(0f),
        )

        Icon(
            painter = painterResource(R.drawable.ui_ic_share),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(
                statusIconRef
            ) {
                start.linkTo(parent.start)
            }
        )

        Button(
            content = { Text(text = "Test") },
            onClick = { println("BUTTON CLICKED") },
            modifier = Modifier
                .testTag("BUTTON")
                .constrainAs(
                    statusRef
                ) {
                    start.linkTo(statusIconRef.end)
                }
        )
    }
}
