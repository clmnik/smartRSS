package com.example.smartrss.data.repository

import com.example.smartrss.data.models.RssFeed
import com.example.smartrss.data.rss.RssParser
import java.net.URL

class RssRepository(private val rssParser: RssParser) {

    fun fetchRssFeed(url: String): RssFeed? {
        return try {
            val xml = URL(url).readText()
            rssParser.parse(xml)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
