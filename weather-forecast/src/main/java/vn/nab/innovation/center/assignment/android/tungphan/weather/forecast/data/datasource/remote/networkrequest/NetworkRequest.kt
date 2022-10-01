package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult

/**
 * Interface responsible for wrapping network request handling inside a single component.
 */
interface NetworkRequest<T, in P> {
    suspend fun execute(params: P): CallResult<T>
}
