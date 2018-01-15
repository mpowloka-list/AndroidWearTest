package com.example.mpowloka.androidweartest.presenter

import android.arch.lifecycle.*
import android.os.AsyncTask
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import android.view.LayoutInflater
import com.example.mpowloka.androidweartest.R
import com.example.mpowloka.androidweartest.model.ModelManagerImpl
import com.example.mpowloka.androidweartest.model.interfaces.ItemsProvider
import com.example.mpowloka.androidweartest.model.persistence.Item
import com.example.mpowloka.androidweartest.model.persistence.dao.ItemDao
import com.example.mpowloka.androidweartest.view.AddItemMvpView
import com.example.mpowloka.androidweartest.view.AddItemMvpViewImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_add_item.view.*


class MainActivity : WearableActivity(), AddItemMvpView.AddItemMvpViewListener, AddItemMvpView.PrintDbContentMvpViewListener {



    private lateinit var mvpView: AddItemMvpView
    private var liveDataSet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()

        mvpView = AddItemMvpViewImpl(LayoutInflater.from(this), container)
        mvpView.addClickedListener = this
        mvpView.printClickedListener = this



    }

    override fun onAddClick() {
        mvpView.rootView.addItemTv.text = "Test xD"
    }

    override fun onPrintClick() {
        AsyncInsertItem().execute(ModelManagerImpl.getInstance(this).itemsProvider)
        if(!liveDataSet) {
            AsyncGetAllItems().execute(ModelManagerImpl.getInstance(this).itemsProvider).get().observe(this, Observer<List<Item>>{
                mvpView.rootView.addItemTv.text = it?.size.toString()
            })
        }
        liveDataSet = true
    }

    companion object {
        const val TAG = "MainActivity"

        class AsyncInsertItem :AsyncTask<ItemsProvider, Unit, Unit>() {
            override fun doInBackground(vararg params: ItemsProvider) {
                    params[0].insert(
                            Item(name = "Hammer")
                    )
            }
        }

        class AsyncGetAllItems :AsyncTask<ItemsProvider, Unit, LiveData<List<Item>>>() {
            override fun doInBackground(vararg params: ItemsProvider): LiveData<List<Item>> = params[0].getAll()
        }
    }
}
