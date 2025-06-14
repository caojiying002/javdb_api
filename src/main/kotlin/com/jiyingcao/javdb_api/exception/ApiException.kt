package com.jiyingcao.javdb_api.exception

/**
 * API异常类
 */
data class ApiException(
    val code: Int,
    override val message: String
) : Exception(message)