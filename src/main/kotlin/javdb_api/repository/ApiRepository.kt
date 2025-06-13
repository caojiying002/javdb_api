package com.jiyingcao.javdb_api.repository

import com.jiyingcao.javdb_api.ApiClient
import com.jiyingcao.javdb_api.exception.ApiException
import com.jiyingcao.javdb_api.response.ApiResponse
import com.jiyingcao.javdb_api.response.StartupData

/**
 * API Repository - 遵循Repository模式
 * 为将来的Android项目提供清晰的数据层架构
 */
class ApiRepository {
    
    private val apiService = ApiClient.apiService
    
    /**
     * 获取启动配置数据
     * @param lastAdId 上次广告ID
     * @param platform 平台类型
     * @param appChannel 应用渠道
     * @param appVersion 应用版本
     * @param appVersionNumber 应用版本号
     * @return Result封装的响应数据
     */
    suspend fun getStartupData(
        lastAdId: String? = null,
        platform: String = "android",
        appChannel: String = "official", 
        appVersion: String = "official",
        appVersionNumber: String = "1.9.29"
    ): Result<StartupData> {
        return try {
            val response = apiService.getStartup(
                lastAdId = lastAdId,
                platform = platform,
                appChannel = appChannel,
                appVersion = appVersion,
                appVersionNumber = appVersionNumber
            )
            
            if (response.isSuccess()) {
                val data = response.getDataOrThrow()
                Result.success(data)
            } else {
                Result.failure(
                    ApiException(
                        code = response.success,
                        message = response.getErrorMessage() ?: "Unknown API error"
                    )
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * 获取原始API响应（包含元数据）
     */
    suspend fun getStartupResponse(
        lastAdId: String? = null,
        platform: String = "android",
        appChannel: String = "official",
        appVersion: String = "official", 
        appVersionNumber: String = "1.9.29"
    ): Result<ApiResponse<StartupData>> {
        return try {
            val response = apiService.getStartup(
                lastAdId = lastAdId,
                platform = platform,
                appChannel = appChannel,
                appVersion = appVersion,
                appVersionNumber = appVersionNumber
            )
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}