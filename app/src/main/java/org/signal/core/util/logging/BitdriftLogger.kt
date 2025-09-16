/*
 * Bitdrift logging integration for Signal
 * www.bitdrift.io
 */

package org.signal.core.util.logging

import io.bitdrift.capture.Capture.Logger as BdLogger
import io.bitdrift.capture.LogLevel

/**
 * A Logger implementation that forwards all Signal logs to bitdrift Capture.
 */
class BitdriftLogger : Log.Logger() {

  override fun v(tag: String, message: String?, t: Throwable?, keepLonger: Boolean) {
    BdLogger.log(LogLevel.TRACE, fields = mapOf("tag" to tag), throwable = t) {
      message.orEmpty()
    }
  }

  override fun d(tag: String, message: String?, t: Throwable?, keepLonger: Boolean) {
    BdLogger.log(LogLevel.DEBUG, fields = mapOf("tag" to tag), throwable = t) {
      message.orEmpty()
    }
  }

  override fun i(tag: String, message: String?, t: Throwable?, keepLonger: Boolean) {
    BdLogger.log(LogLevel.INFO, fields = mapOf("tag" to tag), throwable = t) {
      message.orEmpty()
    }
  }

  override fun w(tag: String, message: String?, t: Throwable?, keepLonger: Boolean) {
    BdLogger.log(LogLevel.WARNING, fields = mapOf("tag" to tag), throwable = t) {
      message.orEmpty()
    }
  }

  override fun e(tag: String, message: String?, t: Throwable?, keepLonger: Boolean) {
    BdLogger.log(LogLevel.ERROR, fields = mapOf("tag" to tag), throwable = t) {
      message.orEmpty()
    }
  }

  override fun flush() {
    // Bitdrift SDK handles flushing internally
  }
}
