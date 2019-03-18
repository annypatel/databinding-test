package databinding.test.utils

import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.test.core.app.ApplicationProvider.getApplicationContext

/**
 * Inflates a binding layout and returns the newly-created binding for that layout.
 */
fun <T : ViewDataBinding> inflate(@LayoutRes layout: Int, @StyleRes style: Int = R.style.Theme_AppCompat): T {
    val context = ContextThemeWrapper(getApplicationContext(), style)

    val inflater = LayoutInflater.from(context)
    val parent = FrameLayout(context)

    val binding = DataBindingUtil.inflate<T>(inflater, layout, parent, true)
    binding.executePendingBindings()
    return binding
}

/**
 * Executes pending binding right away.
 */
inline fun <T : ViewDataBinding> T.bindNow(call: () -> Unit) {
    call()
    executePendingBindings()
}

/**
 * Returns parent view of binding's root view.
 */
inline val <T : ViewDataBinding> T.parent: View
    get() = root.parent as View