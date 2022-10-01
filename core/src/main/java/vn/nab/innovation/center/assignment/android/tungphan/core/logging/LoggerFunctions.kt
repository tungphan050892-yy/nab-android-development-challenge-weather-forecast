package vn.nab.innovation.center.assignment.android.tungphan.core.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun <T : Any> T.createLogger(): Logger = LoggerFactory.getLogger(this::class.java)
