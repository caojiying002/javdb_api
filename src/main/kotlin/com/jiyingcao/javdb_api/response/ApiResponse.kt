package com.jiyingcao.javdb_api.response

/**
 * {
 *   "success": 1,
 *   "action": null,
 *   "message": null,
 *   "data": {}
 * }
 *
 * {
 *     "success": 0,
 *     "action": "ExpiredSignature",
 *     "message": "簽名已過期，沒有權限訪問內容",
 *     "data": null
 * }
 */
data class ApiResponse<T>(
    val success: Int,
    val action: String? = null,
    val message: String? = null,
    val data: T? = null
) {
    companion object {
        inline fun <reified T> success(data: T): ApiResponse<T> {
            return ApiResponse(success = 1, data = data)
        }

        fun error(message: String): ApiResponse<Nothing> {
            return ApiResponse(success = 0, message = message)
        }
    }
    fun isSuccess(): Boolean {
        return success == 1
    }
    fun isError(): Boolean {
        return success == 0
    }
    fun getErrorMessage(): String? {
        return if (isError()) message else null
    }
    fun getDataOrThrow(): T {
        return data ?: throw IllegalStateException("Data is null")
    }
}