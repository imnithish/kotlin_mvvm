package com.imnstudios.justanotherproject.data.repositories

import com.imnstudios.justanotherproject.data.db.AppDatabase
import com.imnstudios.justanotherproject.data.db.entities.User
import com.imnstudios.justanotherproject.data.network.MyApi
import com.imnstudios.justanotherproject.data.network.SafeApiRequest
import com.imnstudios.justanotherproject.data.network.responses.AuthResponse

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)


    fun getUser() = db.getUserDao().getuser()
}