package com.grtushar.instagram.screens.search

import androidx.lifecycle.Observer
import android.util.Log
import com.grtushar.instagram.common.BaseEventListener
import com.grtushar.instagram.common.Event
import com.grtushar.instagram.common.EventBus
import com.grtushar.instagram.data.SearchRepository
import com.grtushar.instagram.models.SearchPost

class SearchPostsCreator(searchRepo: SearchRepository) : BaseEventListener() {
    init {
        EventBus.events.observe(this, Observer {
            it?.let { event ->
                when (event) {
                    is Event.CreateFeedPost -> {
                        val searchPost = with(event.post) {
                            SearchPost(
                                    image = image,
                                    caption = caption,
                                    postId = id)
                        }
                        searchRepo.createPost(searchPost).addOnFailureListener {
                            Log.d(TAG, "Failed to create search post for event: $event", it)
                        }
                    }
                    else -> {
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "SearchPostsCreator"
    }
}