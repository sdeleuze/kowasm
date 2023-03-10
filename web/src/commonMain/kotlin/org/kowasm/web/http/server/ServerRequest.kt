/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http.server

import org.kowasm.web.http.Method
import org.kowasm.web.http.RequestHeaders
import kotlin.reflect.KClass

/**
 * A server-side request, as used as parameter by [ServerHandler] and [RouterHandler].
 */
interface ServerRequest {

    /**
     * The request method.
     */
    val method: Method

    /**
     * The request path.
     */
    val path: String

    /**
     * The request headers.
     */
    val headers: RequestHeaders

    /**
     * The request body.
     * @param type the type of the body
     */
    fun <T: Any> body(type : KClass<T>): T

}