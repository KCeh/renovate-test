package com.infinum.template.app.configurables

import com.infinum.template.BuildConfig
import com.infinum.template.app.logging.JdkTimberAdapter
import com.infinum.template.common.logging.JdkTimber
import javax.inject.Inject
import timber.log.Timber

class TimberConfigurable @Inject constructor() : Configurable {

    override fun configure() {
        // use JdkTimber instead of Timber in non-android modules
        // this adapter passes all the logs logged to JdkTimber into Timber
        JdkTimber.attach(JdkTimberAdapter())

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
