package com.yun.phoneplan.ui.home.viewpager.choice

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.yun.phoneplan.base.BaseViewModel
import com.yun.phoneplan.base.ListLiveData
import com.yun.phoneplan.data.Constant
import com.yun.phoneplan.data.model.SpinnerModel

class ChoiceViewModel(
    application: Application
) : BaseViewModel(application){

    val ageItems = ListLiveData<SpinnerModel>()
    val typeItems = ListLiveData<SpinnerModel>()
    val disItems = ListLiveData<SpinnerModel>()

    val ageTitle = MutableLiveData("")
    val typeTitle = MutableLiveData("")
    val disTitle = MutableLiveData("")

    init {
        settings()
    }

    // 초기설정
    fun settings() {
        ageItems.value = addItems(Constant.AGE_ARRAY)
        typeItems.value = addItems(Constant.TYPE_ARRAY)
        disItems.value = addItems(Constant.DIS_ARRAY)
        ageTitle.value = ""
        typeTitle.value = ""
        disTitle.value = ""
    }

    private fun addItems(item: ArrayList<String>): ArrayList<SpinnerModel> {
        val result = arrayListOf<SpinnerModel>()
        item.forEachIndexed { index, s ->
            result.add(SpinnerModel(id = index, title = s))
        }
        return result
    }

    fun onClick(v: View) {
        when (v.tag) {
            Constant.RESET_BTN -> {
                settings()
                Toast.makeText(mContext, "리셋", Toast.LENGTH_SHORT).show()
            }
        }
    }

}