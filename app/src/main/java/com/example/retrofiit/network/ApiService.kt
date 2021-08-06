package com.example.retrofiit.network

import com.example.retrofiit.utils.User
import retrofit2.http.GET

interface ApiService {

    @GET("list?page=34")
    suspend fun getUsers(): List<User>

}