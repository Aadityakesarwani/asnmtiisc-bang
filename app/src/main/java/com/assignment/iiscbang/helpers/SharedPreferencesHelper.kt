package com.assignment.iiscbang.helpers

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class PreferencesHelper @Inject constructor(@ApplicationContext context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun isLoggedIn(): Boolean {
        return preferences.getBoolean(LOGGED_IN, false)
    }

    fun setLoggedInUser(userId: String) {
        preferences.edit {
            putBoolean(LOGGED_IN, true)
            putString(USER_ID, userId)
        }
    }

    fun clearLoggedInUser() {
        preferences.edit {
            putBoolean(LOGGED_IN, false)
            remove(USER_ID)
        }
    }

    fun isFirstLaunch(): Boolean {
        val isFirstRun = preferences.getBoolean(IS_FIRST_LAUNCH, true)
        if (isFirstRun) {
            preferences.edit {
                putBoolean(IS_FIRST_LAUNCH, false)
            }
        }
        return isFirstRun
    }

    companion object {
        private const val LOGGED_IN = "logged_in"
        private const val USER_ID = "user_id"
        private const val IS_FIRST_LAUNCH = "is_first_launch"
    }
}
