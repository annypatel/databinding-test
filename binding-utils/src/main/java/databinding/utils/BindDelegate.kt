package databinding.utils

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Creates [BindDelegate] with BR field ID and null as initial value.
 */
fun <T> bind(fieldId: Int) = BindDelegate(fieldId, null as T?)

/**
 * Creates [BindDelegate] with BR field ID and initial value.
 */
fun <T> bind(fieldId: Int, value: T) = BindDelegate(fieldId, value)

/**
 * Delegate for [Bindable] properties, which automatically notifies listeners that property has changed.
 */
class BindDelegate<T>(
    private val fieldId: Int,
    private var value: T
) : ReadWriteProperty<BaseObservable, T> {

    override fun getValue(thisRef: BaseObservable, property: KProperty<*>): T {
        return value
    }

    override fun setValue(thisRef: BaseObservable, property: KProperty<*>, value: T) {
        this.value = value
        thisRef.notifyPropertyChanged(fieldId)
    }
}