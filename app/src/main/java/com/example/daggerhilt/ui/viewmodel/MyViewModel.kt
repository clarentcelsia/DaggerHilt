package com.example.daggerhilt.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.model.Data
import com.example.daggerhilt.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo: MyRepository,
) : ViewModel() {

    private var _collectData : MutableStateFlow<List<Data>> = MutableStateFlow(ArrayList())

    fun collectData(): StateFlow<List<Data>> {
        fetchData()
        return _collectData
    }

    fun insertData(data: Data) = viewModelScope.launch {
        repo.insertData(data)
    }

    private fun fetchData() = viewModelScope.launch {
        repo.fetchData().collect {
            _collectData.value = it
        }
    }
}