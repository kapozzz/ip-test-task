package com.kapozzz.ip_test_task.data.impl

import android.content.Context
import android.content.SharedPreferences
import com.kapozzz.ip_test_task.domain.repositories.PreferencesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PreferencesRepository {

    private companion object {
        const val PREFS_NAME = "MyAppPreferences"
        const val KEY_FIRST_START = "isFirstStart"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override fun isFirstStart(): Boolean {
        return sharedPreferences.getBoolean(KEY_FIRST_START, true)
    }

    override fun setFirstStart(value: Boolean) {
        sharedPreferences.edit()
            .putBoolean(KEY_FIRST_START, value)
            .apply()
    }
}