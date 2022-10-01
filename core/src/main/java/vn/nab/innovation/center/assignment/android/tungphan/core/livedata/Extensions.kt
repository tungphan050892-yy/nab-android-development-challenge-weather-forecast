package vn.nab.innovation.center.assignment.android.tungphan.core.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

inline fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, crossinline observer: (T) -> Unit) {
    this.observe(owner) { data -> data?.let { observer(it) } }
}
