package com.grtushar.instagram.common.firebase

import com.grtushar.instagram.common.AuthManager
import com.grtushar.instagram.common.toUnit
import com.grtushar.instagram.data.firebase.common.auth
import com.google.android.gms.tasks.Task

class FirebaseAuthManager : AuthManager {
    override fun signOut() {
        auth.signOut()
    }

    override fun signIn(email: String, password: String): Task<Unit> =
        auth.signInWithEmailAndPassword(email, password).toUnit()
}