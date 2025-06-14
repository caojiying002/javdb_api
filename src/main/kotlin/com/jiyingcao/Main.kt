package com.jiyingcao

import com.jiyingcao.javdb_api.ApiClient
import kotlinx.coroutines.runBlocking

fun main() {
    //testStartup()
}

fun testStartup() {
    println("=== Startup API 测试开始 ===")
    
    runBlocking {
        try {
            // 调用启动接口
            val response = ApiClient.apiService.getStartup()

            println("请求完成，响应状态: success=${response.success}")

            if (response.isSuccess()) {
                val data = response.data
                println("\n✅ API调用成功!")

                data?.let { startupData ->
                    println("\n=== 响应数据摘要 ===")
                    println("启动广告启用: ${startupData.splashAd?.enabled}")

                    startupData.splashAd?.ad?.let { ad ->
                        println("广告ID: ${ad.id}")
                        println("广告类型: ${ad.mediaType}")
                        println("跳过方式: ${ad.skipWay}")
                    }

                    println("最近关键词: ${startupData.recentKeywords?.take(3)}")
                    println("磁链关键词: ${startupData.recentMagnetKeywords?.take(3)}")

                    startupData.settings?.let { settings ->
                        println("\n=== 应用设置 ===")
                        println("当前版本: ${settings.version}")
                        println("下载链接: ${settings.installationUrl}")
                        println("更新说明: ${settings.updateDescription?.take(50)}...")
                    }

                    println("\n=== 功能开关 ===")
                    println("日志启用: ${startupData.loggingEnabled}")
                    println("演员识别: ${startupData.recognizeActorEnabled}")
                    println("影片识别: ${startupData.recognizeMovieEnabled}")
                    println("支付启用: ${startupData.ypayPaymentEnabled}")

                    println("\n图片前缀: ${startupData.webImagePrefix}")
                }

            } else {
                println("\n❌ API调用失败!")
                println("错误信息: ${response.getErrorMessage()}")
                println("响应action: ${response.action}")
            }

        } catch (e: Exception) {
            println("\n💥 发生异常!")
            println("异常类型: ${e.javaClass.simpleName}")
            println("异常信息: ${e.message}")
            e.printStackTrace()
        }
    }

    println("\n=== 测试结束 ===")
}