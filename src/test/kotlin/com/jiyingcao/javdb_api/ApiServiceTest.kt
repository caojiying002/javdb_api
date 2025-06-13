package com.jiyingcao.javdb_api

import com.jiyingcao.javdb_api.response.ApiResponse
import com.jiyingcao.javdb_api.response.StartupData
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Assertions.*

class ApiServiceTest {
    
    private lateinit var apiService: ApiService
    
    @BeforeEach
    fun setup() {
        apiService = ApiClient.apiService
    }
    
    @Test
    @DisplayName("测试启动接口 - 基本调用")
    fun `test startup endpoint with default parameters`(): Unit = runBlocking {
        try {
            val response: ApiResponse<StartupData> = apiService.getStartup()
            
            // 验证响应基本结构
            assertNotNull(response, "响应不应为null")
            println("响应状态: success=${response.success}")
            
            if (response.isSuccess()) {
                val data = response.data
                assertNotNull(data, "成功响应的data不应为null")
                
                // 打印关键信息用于验证
                println("=== 启动接口测试成功 ===")
                data?.let { startupData ->
                    println("是否启用启动广告: ${startupData.splashAd?.enabled}")
                    println("用户推广码: ${startupData.user?.promotionCode ?: "无"}")
                    println("最近关键词数量: ${startupData.recentKeywords?.size ?: 0}")
                    println("设置版本: ${startupData.settings?.version}")
                    println("日志启用状态: ${startupData.loggingEnabled}")
                    println("图片前缀: ${startupData.webImagePrefix}")
                }
            } else {
                println("API返回错误: ${response.getErrorMessage()}")
                // 根据业务需求决定是否fail测试
                // fail("API调用失败: ${response.getErrorMessage()}")
            }
            
        } catch (e: Exception) {
            println("网络请求异常: ${e.message}")
            e.printStackTrace()
            fail("网络请求发生异常: ${e.message}")
        }
    }
    
    @Test
    @DisplayName("测试启动接口 - 自定义参数")
    fun `test startup endpoint with custom parameters`(): Unit = runBlocking {
        try {
            val response = apiService.getStartup(
                lastAdId = "76",
                platform = "android",
                appChannel = "official",
                appVersion = "official",
                appVersionNumber = "1.9.29"
            )
            
            assertNotNull(response)
            println("自定义参数测试 - 响应状态: success=${response.success}")
            
            if (response.isSuccess()) {
                println("=== 自定义参数测试成功 ===")
                // 可以添加更多具体的验证逻辑
            }
            
        } catch (e: Exception) {
            println("自定义参数测试异常: ${e.message}")
            fail("自定义参数测试失败: ${e.message}")
        }
    }
    
    @Test
    @DisplayName("测试API响应数据结构")
    fun `test startup response data structure`(): Unit = runBlocking {
        try {
            val response = apiService.getStartup()
            
            if (response.isSuccess()) {
                val data = response.data
                assertNotNull(data, "成功响应应包含数据")
                
                // 验证数据结构完整性
                data?.let {
                    println("=== 数据结构验证 ===")
                    
                    // 验证splash_ad结构
                    it.splashAd?.let { splashAd ->
                        println("广告配置存在")
                        assertNotNull(splashAd.enabled, "广告启用状态不应为null")
                    }
                    
                    // 验证settings结构
                    it.settings?.let { settings ->
                        println("设置配置存在")
                        println("版本信息: ${settings.version}")
                        println("安装URL: ${settings.installationUrl}")
                    }
                    
                    // 验证关键词列表
                    it.recentKeywords?.let { keywords ->
                        println("最近关键词: $keywords")
                        assertTrue(keywords.isNotEmpty(), "关键词列表不应为空")
                    }
                    
                    println("数据结构验证完成")
                }
            }
            
        } catch (e: Exception) {
            fail("数据结构验证失败: ${e.message}")
        }
    }
}