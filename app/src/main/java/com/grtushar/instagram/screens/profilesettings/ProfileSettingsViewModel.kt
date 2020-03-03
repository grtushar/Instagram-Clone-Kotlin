package com.grtushar.instagram.screens.profilesettings

import com.grtushar.instagram.common.AuthManager
import com.grtushar.instagram.screens.common.BaseViewModel
import com.google.android.gms.tasks.OnFailureListener

class ProfileSettingsViewModel(private val authManager: AuthManager,
                               onFailureListener: OnFailureListener) :
        BaseViewModel(onFailureListener),
        AuthManager by authManager