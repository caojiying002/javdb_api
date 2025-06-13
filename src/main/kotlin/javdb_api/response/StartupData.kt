package com.jiyingcao.javdb_api.response

/**
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
    val splashAd: SplashAd? = null,
    val user: User? = null,
    val backupDomainsData: String? = null,
    val recentKeywords: List<String>? = null,
    val recentMagnetKeywords: List<String>? = null,
    val settings: Settings? = null,
    val feedback: Feedback? = null,
    val loggingEnabled: Boolean? = null,
    val recognizeActorEnabled: Boolean? = null,
    val recognizeMovieEnabled: Boolean? = null,
    val webImagePrefix: String? = null,
    val ypayPaymentEnabled: Boolean? = null
)
data class SplashAd(
    val enabled: Boolean? = null,
    val overtime: Int? = null,
    val ad: Ad? = null
)
data class Ad(
    val id: Int? = null,
    val mediaType: String? = null,
    val mediaUrl: String? = null,
    val linkType: String? = null,
    val linkUrl: String? = null,
    val skipWay: String? = null,
    val sleepTime: Int? = null,
    val updatedAt: String? = null,
    val md5: String? = null
)
data class User(
    val promotionCode: String? = null
)
data class Settings(
    val updateDescription: String? = null,
    val notice: String? = null,
    val agentGroup: String? = null,
    val installationUrl: String? = null,
    val version: String? = null,
    val testflightUrl: String? = null
)
data class Feedback(
    val placeholder: String? = null
)