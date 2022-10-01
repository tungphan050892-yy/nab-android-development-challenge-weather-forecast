package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Interface representing internet checking functionality.
 */
interface ConnectionChecker {
    /**
     * Checks whether there is internet connection present.
     */
    suspend fun hasInternetConnection(): Boolean

    /**
     * Returns [Flow] object containing continuous connection state.
     */
    val hasInternetConnectionFlow: Flow<Boolean>
}

/**
 * Default implementation of [ConnectionChecker].
 * TODO - figure out how will this be tested
 */
class ConnectionCheckerImpl(connectivityManager: ConnectivityManager) : ConnectionChecker {

    private val stateFlow = MutableStateFlow(false)

    init {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                connectivityManager.registerDefaultNetworkCallback(createNetworkCallback())
            }
            else -> {
                connectivityManager.registerNetworkCallback(
                    createNetworkRequest(),
                    createNetworkCallback()
                )
            }
        }
    }

    private fun createNetworkCallback(): ConnectivityManager.NetworkCallback =
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                stateFlow.value = true
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                stateFlow.value = false
            }
        }

    private fun createNetworkRequest(): NetworkRequest = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()

    override val hasInternetConnectionFlow: Flow<Boolean> = stateFlow
        .debounce(300)
        .distinctUntilChanged()

    override suspend fun hasInternetConnection(): Boolean = stateFlow.value
}
