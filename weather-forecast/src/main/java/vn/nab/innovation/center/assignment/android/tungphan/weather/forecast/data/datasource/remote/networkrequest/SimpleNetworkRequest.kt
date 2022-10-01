package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest

import vn.nab.innovation.center.assignment.android.tungphan.core.logging.createLogger
import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.ConnectionChecker
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException

/**
 * Concrete implementation of [NetworkRequest].
 * Upholds wrapping logic of catching exceptions and checking for internet connection.
 * and other simple exception cause by network request call
 */
class SimpleNetworkRequest<T, P>(
    private val lambdaCall: suspend (P) -> CallResult<T>,
    private val connectionChecker: ConnectionChecker
) : NetworkRequest<T, P> {
    private val logger = createLogger()

    override suspend fun execute(params: P): CallResult<T> {
        return if (connectionChecker.hasInternetConnection()) {
            try {
                lambdaCall(params)
            } catch (ex: NullPointerException) {
                CallResult.failure(ex)
            } catch (ex: SocketTimeoutException) {
                logger.error(lambdaCall.javaClass.name, ex)
                CallResult.failure(ex)
            } catch (ex: Exception) {
                logger.error(lambdaCall.javaClass.name, ex)
                CallResult.failure(ex)
            }
        } else CallResult.failure(NoInternet)
    }
}

/**
 * Utility method for delegating default network behaviour to [SimpleNetworkRequest] component.
 */
fun <T, P> simpleNetworkRequest(
    lambdaCall: suspend (P) -> CallResult<T>,
    connectionChecker: ConnectionChecker
) = SimpleNetworkRequest(lambdaCall, connectionChecker)

/**
 * Domain exception class representing there is no internet connection.
 */
object NoInternet : Exception()
