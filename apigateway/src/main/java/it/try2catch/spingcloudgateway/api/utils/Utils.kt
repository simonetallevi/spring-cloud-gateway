package it.try2catch.spingcloudgateway.api.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment

class Utils {

    companion object {
        @JvmStatic
        fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)
    }
}
