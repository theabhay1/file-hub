package com.example.filehub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filehub.data.FileRepository
import com.example.filehub.data.StorageInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val fileRepository = FileRepository()

    private val _storageInfo = MutableStateFlow(StorageInfo(0, 0))
    val storageInfo = _storageInfo.asStateFlow()

    init {
        fetchStorageInfo()
    }

    private fun fetchStorageInfo(){
        viewModelScope.launch {
            val info = fileRepository.getStorage()
            _storageInfo.value = info
        }
    }
}