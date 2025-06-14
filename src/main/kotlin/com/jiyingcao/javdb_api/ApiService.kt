package com.jiyingcao.javdb_api

import com.jiyingcao.javdb_api.response.*
import retrofit2.http.*

interface ApiService {

    /**
     * GET /api/v1/startup?last_ad_id=&platform=android&app_channel=official&app_version=official&app_version_number=1.9.29
     */
    @GET("api/v1/startup")
    suspend fun getStartup(
        @Query("last_ad_id") lastAdId: String? = null,
        @Query("platform") platform: String = "android",
        @Query("app_channel") appChannel: String = "official",
        @Query("app_version") appVersion: String = "official",
        @Query("app_version_number") appVersionNumber: String = "1.9.29"
    ): ApiResponse<StartupData>

}