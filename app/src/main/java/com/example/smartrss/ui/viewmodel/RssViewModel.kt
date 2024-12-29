package com.example.smartrss.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartrss.data.models.RssFeed
import com.example.smartrss.data.repository.RssRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RssViewModel(private val rssRepository: RssRepository) : ViewModel() {

    private val _rssFeed = MutableStateFlow<RssFeed?>(null)
    val rssFeed: StateFlow<RssFeed?> get() = _rssFeed

    fun loadRssFeed(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val feed = rssRepository.fetchRssFeed(url)
            _rssFeed.value = feed
        }
    }
}
