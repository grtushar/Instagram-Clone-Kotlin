package com.grtushar.instagram.screens

import android.app.Application
import com.grtushar.instagram.common.firebase.FirebaseAuthManager
import com.grtushar.instagram.data.firebase.FirebaseFeedPostsRepository
import com.grtushar.instagram.data.firebase.FirebaseNotificationsRepository
import com.grtushar.instagram.data.firebase.FirebaseSearchRepository
import com.grtushar.instagram.data.firebase.FirebaseUsersRepository
import com.grtushar.instagram.screens.notifications.NotificationsCreator
import com.grtushar.instagram.screens.search.SearchPostsCreator

class InstagramApp : Application() {
    val usersRepo by lazy { FirebaseUsersRepository() }
    val feedPostsRepo by lazy { FirebaseFeedPostsRepository() }
    val notificationsRepo by lazy { FirebaseNotificationsRepository() }
    val authManager by lazy { FirebaseAuthManager() }
    val searchRepo by lazy { FirebaseSearchRepository() }

    override fun onCreate() {
        super.onCreate()
        NotificationsCreator(notificationsRepo, usersRepo, feedPostsRepo)
        SearchPostsCreator(searchRepo)
    }
}