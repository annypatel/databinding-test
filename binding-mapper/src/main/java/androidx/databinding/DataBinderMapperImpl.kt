package androidx.databinding

import android.content.Context
import androidx.test.core.app.ApplicationProvider.getApplicationContext

/**
 * Running instrumented tests with Robolectric on Data Binding enabled library modules throws [NoClassDefFoundError] for
 * [DataBinderMapperImpl]. For some reason Data Binding compiler is not generating the [DataBinderMapperImpl] class
 * while running local JVM tests. There is already a [bug][https://issuetracker.google.com/issues/126775542] reported
 * for this behaviour.
 *
 * This class provides temporary solution by registering library module's generated `com.mylibrary.DataBinderMapperImpl`
 * to `androidx.databinding.DataBinderMapperImpl` via reflection.
 */
class DataBinderMapperImpl : MergedDataBinderMapper() {

    init { addMapper(myDataBinderMapper()) }

    private fun myDataBinderMapper(): String {
        val packageName = getApplicationContext<Context>().applicationInfo.packageName
        return if (packageName.endsWith(".test")) {
            packageName.substring(0, packageName.length - 5)
        } else {
            packageName
        }
    }
}