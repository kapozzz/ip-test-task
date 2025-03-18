package com.kapozzz.ip_test_task.domain.repositories

interface PreferencesRepository {

    fun isFirstStart(): Boolean

    fun setFirstStart(value: Boolean)

}