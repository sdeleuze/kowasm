/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http

/**
 * An HTTP header, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231).
 */
sealed class HeaderName(val name: String) {

    override fun equals(other: Any?): Boolean {
        val otherName = if (other is HeaderName) other.name else if (other is String) other else return false
        return this.name.equals(otherName, ignoreCase = true)
    }
}



