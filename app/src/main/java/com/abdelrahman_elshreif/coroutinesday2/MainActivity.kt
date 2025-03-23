package com.abdelrahman_elshreif.coroutinesday2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman_elshreif.coroutinesday2.ui.theme.CoroutinesDay2Theme
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SearchScreen(viewModel)
        }
    }
}


@Composable
fun SearchBar(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onClear: () -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Type Here to Search") },
        singleLine = true
    )
}

@Composable
fun SearchScreen(viewModel: MainViewModel) {
    val searchText = remember {
        mutableStateOf(TextFieldValue(""))
    }

    val filteredNames = viewModel.filteredNames.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(48.dp),
    ) {
        SearchBar(
            query = searchText.value,
            onQueryChange = { newText ->
                searchText.value = newText
                viewModel.onSearchQueryChanged(newText.text)
            },
            onClear = {
                searchText.value = TextFieldValue("")
                viewModel.onSearchQueryChanged("")
            }
        )

        LazyColumn {
            items(filteredNames.value) { item ->
                Text(text = item, modifier = Modifier.padding(16.dp))
            }
        }

    }
}