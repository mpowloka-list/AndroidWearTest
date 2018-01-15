package com.example.mpowloka.androidweartest.view

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */

interface AddItemMvpView: MvpView {

    var addClickedListener: AddItemMvpViewListener?
    var printClickedListener: PrintDbContentMvpViewListener?

    interface AddItemMvpViewListener {
        fun onAddClick()
    }

    interface PrintDbContentMvpViewListener {
        fun onPrintClick()
    }

    fun displayInfo(info: String)

    companion object {
        const val ITEM_TO_ADD_KEY = "item_to_add_key"
    }

}