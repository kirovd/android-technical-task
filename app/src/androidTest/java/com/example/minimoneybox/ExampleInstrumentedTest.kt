package com.example.minimoneybox

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.telecom.Call
import android.view.textclassifier.TextLinks

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.runner.Request
import java.io.IOException
import javax.security.auth.callback.Callback

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.minimoneybox", appContext.packageName)
    }
}
