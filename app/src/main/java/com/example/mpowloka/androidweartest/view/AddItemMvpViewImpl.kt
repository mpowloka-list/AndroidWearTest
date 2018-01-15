package com.example.mpowloka.androidweartest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mpowloka.androidweartest.R
import kotlinx.android.synthetic.main.layout_add_item.view.*

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */

class AddItemMvpViewImpl(inflater: LayoutInflater, container: ViewGroup) : AddItemMvpView {

    override val viewState: Bundle?
        get() {
            if (rootView.addItemEt.text.toString() == "")
                return null

            val state = Bundle()
            Bundle().putString(AddItemMvpView.ITEM_TO_ADD_KEY, rootView.addItemEt.text.toString())
            return state
        }

    override val rootView: View =
            inflater.inflate(R.layout.layout_add_item, container, true)

    override var addClickedListener: AddItemMvpView.AddItemMvpViewListener? = null
    override var printClickedListener: AddItemMvpView.PrintDbContentMvpViewListener? = null

    init {
        rootView.addItemBtn.setOnClickListener { addClickedListener?.onAddClick() }
        rootView.printBtn.setOnClickListener { printClickedListener?.onPrintClick() }
    }


    override fun displayInfo(info: String) {
        rootView.addItemTv.text = info
    }
}