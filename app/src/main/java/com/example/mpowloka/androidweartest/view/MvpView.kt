package com.example.mpowloka.androidweartest.view

import android.os.Bundle
import android.view.View

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */

interface MvpView {

    val rootView: View

    val viewState: Bundle?

}