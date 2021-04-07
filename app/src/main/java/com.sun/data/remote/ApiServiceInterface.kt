package com.sun.data.remote

import com.sun.data.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface apiService for declare api endpoint
 */
interface ApiServiceInterface {
    @GET("orgs/framgia/repos")
    suspend fun getPosts(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Post>
}
