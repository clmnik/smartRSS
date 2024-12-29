package com.example.smartrss.data.rss

import com.example.smartrss.data.models.RssFeed
import com.example.smartrss.data.models.RssItem
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

class RssParser {
    fun parse(xml: String): RssFeed {
        val factory = XmlPullParserFactory.newInstance()
        val parser = factory.newPullParser()
        parser.setInput(xml.reader())

        var eventType = parser.eventType
        var title: String? = null
        var description: String? = null
        var link: String? = null
        var pubDate: String? = null
        val items = mutableListOf<RssItem>()

        while (eventType != XmlPullParser.END_DOCUMENT) {
            val tagName = parser.name
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    when (tagName) {
                        "item" -> {
                            title = null
                            description = null
                            link = null
                            pubDate = null
                        }
                        "title" -> title = parser.nextText()
                        "description" -> description = parser.nextText()
                        "link" -> link = parser.nextText()
                        "pubDate" -> pubDate = parser.nextText()
                    }
                }
                XmlPullParser.END_TAG -> {
                    if (tagName == "item") {
                        val item =
