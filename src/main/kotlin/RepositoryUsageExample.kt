package com.jiyingcao

import com.jiyingcao.javdb_api.exception.ApiException
import com.jiyingcao.javdb_api.repository.ApiRepository

/**
 * Repository使用示例
 */
class RepositoryUsageExample {
    
    private val repository = ApiRepository()
    
    suspend fun example() {
        // 方式1: 获取纯数据
        repository.getStartupData().fold(
            onSuccess = { startupData ->
                println("获取成功: ${startupData.settings?.version}")
                // 处理成功数据
            },
            onFailure = { exception ->
                when (exception) {
                    is ApiException -> {
                        println("API错误 [${exception.code}]: ${exception.message}")
                    }
                    else -> {
                        println("网络错误: ${exception.message}")
                    }
                }
            }
        )
        
        // 方式2: 获取完整响应
        repository.getStartupResponse().fold(
            onSuccess = { response ->
                println("响应状态: ${response.success}")
                if (response.isSuccess()) {
                    // 处理成功数据
                    response.data?.let { data ->
                        println("处理启动数据...")
                    }
                }
            },
            onFailure = { exception ->
                println("请求失败: ${exception.message}")
            }
        )
    }
}