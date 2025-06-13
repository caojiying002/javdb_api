package com.jiyingcao.javdb_api.response

import com.google.gson.annotations.SerializedName

/**
 * 启动接口响应数据
 * 
 * {
 *     "splash_ad": {
 *       "enabled": true,
 *       "overtime": 4,
 *       "ad": {
 *         "id": 78,
 *         "media_type": "image",
 *         "media_url": "https://tp-iu.cmastd.com/rhe951l4q/ads/1749391711.jpg",
 *         "link_type": "browser",
 *         "link_url": "https://m.cpu6666.com/upload/android/game_package87-14.apk",
 *         "skip_way": "auto",
 *         "sleep_time": 30,
 *         "updated_at": "2025-06-13T05:54:48.915Z",
 *         "md5": "a6bd32b4f09be4789e299dde54eedfd6"
 *       }
 *     },
 *     "user": {
 *       "promotion_code": null
 *     },
 *     "backup_domains_data": "JCxJQTR1DerICeuy4lmmWNNc708LxM852ED/olQgaTIMywjg+zn53SKS32S81tAhaoqrxIaou0vKGXfPp5hfLjVovpxo750R7x9/80+hINK6yPaJ8EDLfvresGN5doC4UP9YAD/Vd4UOLcX79idnv3/gGJu8/igyh90tODu6g8kcJqZOPQCWmSc6dnCi/xVPbNS56oJVxRjT8YPBt74Fe58IOp+eqatQC6DpwxWeQdk1KT0ggD2YJH6/WXl9c2R+p/hxS4bWU0jMT6FfRKlhw+KrvZIuFLf2w7w6OJQ0j+pH7Zz9CTCMJOOkuqCg5UlVz5+AfSwOIPORNOWWJIi9P7PqrWCAduPJEUF4/Xw9/ATnRKZYA/wS7GWdkWovSGHEro06JjlY9/lFuXQeS0M/GoqLqR8FmOaliNO6jC4s17KLaB4yBhUsitewvaQyOx1d",
 *     "recent_keywords": [
 *       "VR",
 *       "jur",
 *       "start",
 *       "dass",
 *       "cawd"
 *     ],
 *     "recent_magnet_keywords": [
 *       "nana",
 *       "2025",
 *       "cos",
 *       "song",
 *       "2025年",
 *       "kitty"
 *     ],
 *     "settings": {
 *       "UPDATE_DESCRIPTION": "🆕 v1.9.29 版已發布\r\n\r\n- 更新相關域名。\r\n- 其它問題修正。",
 *       "NOTICE": "公告頻道，關注最新消息永不迷路: ",
 *       "AGENT_GROUP": "https://t.me/javdb_agent",
 *       "INSTALLATION_URL": "https://apk.jjqzd.top/jdb_official_v1.9.29.apk",
 *       "VERSION": "1.9.29|1",
 *       "TESTFLIGHT_URL": "https://jav.app"
 *     },
 *     "feedback": {
 *       "placeholder": "Please describe the content of the feedback as much as possible, such as:"
 *     },
 *     "logging_enabled": false,
 *     "recognize_actor_enabled": true,
 *     "recognize_movie_enabled": true,
 *     "web_image_prefix": "https://c0.jdbstatic.com/",
 *     "ypay_payment_enabled": true
 *   }
 */
data class StartupData(
    @SerializedName("splash_ad")
    val splashAd: SplashAd? = null,
    
    @SerializedName("user")
    val user: User? = null,
    
    @SerializedName("backup_domains_data")
    val backupDomainsData: String? = null,
    
    @SerializedName("recent_keywords")
    val recentKeywords: List<String>? = null,
    
    @SerializedName("recent_magnet_keywords")
    val recentMagnetKeywords: List<String>? = null,
    
    @SerializedName("settings")
    val settings: Settings? = null,
    
    @SerializedName("feedback")
    val feedback: Feedback? = null,
    
    @SerializedName("logging_enabled")
    val loggingEnabled: Boolean? = null,
    
    @SerializedName("recognize_actor_enabled")
    val recognizeActorEnabled: Boolean? = null,
    
    @SerializedName("recognize_movie_enabled")
    val recognizeMovieEnabled: Boolean? = null,
    
    @SerializedName("web_image_prefix")
    val webImagePrefix: String? = null,
    
    @SerializedName("ypay_payment_enabled")
    val ypayPaymentEnabled: Boolean? = null
)

data class SplashAd(
    @SerializedName("enabled")
    val enabled: Boolean? = null,
    
    @SerializedName("overtime")
    val overtime: Int? = null,
    
    @SerializedName("ad")
    val ad: Ad? = null
)

data class Ad(
    @SerializedName("id")
    val id: Int? = null,
    
    @SerializedName("media_type")
    val mediaType: String? = null,
    
    @SerializedName("media_url")
    val mediaUrl: String? = null,
    
    @SerializedName("link_type")
    val linkType: String? = null,
    
    @SerializedName("link_url")
    val linkUrl: String? = null,
    
    @SerializedName("skip_way")
    val skipWay: String? = null,
    
    @SerializedName("sleep_time")
    val sleepTime: Int? = null,
    
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    
    @SerializedName("md5")
    val md5: String? = null
)

data class User(
    @SerializedName("promotion_code")
    val promotionCode: String? = null
)

data class Settings(
    @SerializedName("UPDATE_DESCRIPTION")
    val updateDescription: String? = null,
    
    @SerializedName("NOTICE")
    val notice: String? = null,
    
    @SerializedName("AGENT_GROUP")
    val agentGroup: String? = null,
    
    @SerializedName("INSTALLATION_URL")
    val installationUrl: String? = null,
    
    @SerializedName("VERSION")
    val version: String? = null,
    
    @SerializedName("TESTFLIGHT_URL")
    val testflightUrl: String? = null
)

data class Feedback(
    @SerializedName("placeholder")
    val placeholder: String? = null
)