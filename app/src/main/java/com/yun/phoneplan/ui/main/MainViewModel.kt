package com.yun.phoneplan.ui.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.yun.phoneplan.base.BaseViewModel

class MainViewModel(
    application: Application
) : BaseViewModel(application) {
    val isLoading = MutableLiveData<Boolean>(false)

}