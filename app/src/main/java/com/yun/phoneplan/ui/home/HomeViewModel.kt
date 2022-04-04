package com.yun.phoneplan.ui.home

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.yun.phoneplan.R
import com.yun.phoneplan.base.BaseViewModel
import com.yun.phoneplan.base.ListLiveData
import com.yun.phoneplan.data.Constant
import com.yun.phoneplan.data.Constant.TAG
import com.yun.phoneplan.data.model.SpinnerModel
import com.yun.phoneplan.data.repository.OpenApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(
    application: Application,
    private val api: OpenApi
) : BaseViewModel(application) {


    val screen = MutableLiveData<Int>()

   init {
//       callApi()
   }


    fun callApi() {
        api.choice(mContext.getString(R.string.authkey), "300", "6000", "50", "20", "6", "24")
            .observeOn(
                Schedulers.io()
            )
            .subscribeOn(Schedulers.io())
            .flatMap {
                Observable.just(it)
            }.observeOn(AndroidSchedulers.mainThread()).map {
                Log.d(TAG,"callApi : ${it.items}")
            }.subscribe({
                Log.d(TAG,"success")
                screen.value = Constant.LIST_SCREEN
            },{
                it.printStackTrace()
            })


    }

    fun test(str: String){
        Log.d(TAG,"str : $str")
        screen.value = Constant.LIST_SCREEN
    }


}