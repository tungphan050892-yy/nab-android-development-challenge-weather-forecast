package vn.nab.innovation.center.assignment.android.tungphan.core.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import vn.nab.innovation.center.assignment.android.tungphan.core.logging.createLogger
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T>(private val errorOnNoObservers: Boolean = false) : MutableLiveData<T>() {

    private val logger = createLogger()
    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasActiveObservers()) {
            logger.warn("Multiple observers registered but only one will be notified of changes.")
        }
        // Observe the internal MutableLiveData
        super.observe(
            owner
        ) { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    @MainThread
    override fun setValue(t: T?) {
        if (errorOnNoObservers && !hasActiveObservers()) {
            throw IllegalStateException("setValue called but there are no active observers")
        }
        pending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call() {
        value = null
    }
}
