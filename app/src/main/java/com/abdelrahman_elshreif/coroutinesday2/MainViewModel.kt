package com.abdelrahman_elshreif.coroutinesday2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _searchText = MutableSharedFlow<String>(replay = 1)

    private val _filteredNames = MutableStateFlow<List<String>>(emptyList())
    val filteredNames = _filteredNames.asStateFlow()

    private val names =
        listOf("Ahmed", "Omar", "Mohamed", "Nader", "Abdelrahman", "Mahmoud", "Youssef")

    fun onSearchQueryChanged(query: String) {
        viewModelScope.launch {
            _searchText.emit(query)
            _filteredNames.value = if (query.isNotEmpty() && query.isNotBlank()) {
                names.filter { it.startsWith(query, ignoreCase = true) }
            } else {
                emptyList()
            }
        }
    }
}

