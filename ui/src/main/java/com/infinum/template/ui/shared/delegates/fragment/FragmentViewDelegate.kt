package com.infinum.template.ui.shared.delegates.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

interface FragmentViewDelegate {

    fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
}
