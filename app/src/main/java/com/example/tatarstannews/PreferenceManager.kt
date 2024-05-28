package com.example.tatarstannews

import android.content.Context
import android.content.SharedPreferences


class PreferenceManager(context: Context) {

    companion object {
        private const val PREF_NAME = "MyPrefs"
        private const val KEY_LOGIN = "login"
        private const val KEY_EMAIL = "email"
        private const val KEY_PASS = "pass"
        private const val KEY_TEST_PASSED = "test_passed"
        private const val KEY_USER_LEVEL = "user_level"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveUser(user: User) {
        preferences.edit().apply {
            putString(KEY_LOGIN, user.login)
            putString(KEY_EMAIL, user.email)
            putString(KEY_PASS, user.pass)
            apply()
        }
    }

    fun getUser(): User? {
        val login = preferences.getString(KEY_LOGIN, null)
        val email = preferences.getString(KEY_EMAIL, null)
        val pass = preferences.getString(KEY_PASS, null)

        return if (login != null && email != null && pass != null) {
            User(login, email, pass)
        } else {
            null
        }
    }

    fun clearUser() {
        preferences.edit().remove(KEY_LOGIN).remove(KEY_EMAIL).remove(KEY_PASS).apply()
    }

    fun hasUserPassedTest(): Boolean {
        return preferences.getBoolean(KEY_TEST_PASSED, false)
    }

    fun saveUserLevel(level: String) {
        preferences.edit().putString(KEY_USER_LEVEL, level).apply()
    }

    fun getUserLevel(): String? {
        return preferences.getString(KEY_USER_LEVEL, null)
    }

}
