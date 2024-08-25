package com.infinum.template.ui

import com.infinum.template.ui.shared.base.BaseActivity
import com.infinum.template.ui.shared.delegates.activity.xmlActivityContent

class MainActivity : BaseActivity<Nothing, Nothing>() {

    override val contentDelegate = xmlActivityContent(R.layout.activity_main)

    override fun provideBaseViewModel(): Nothing? = null

    override fun handleEvent(event: Nothing) = Unit
}
