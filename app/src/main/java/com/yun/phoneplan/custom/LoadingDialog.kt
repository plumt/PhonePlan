package com.yun.phoneplan.custom

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.yun.phoneplan.R

class LoadingDialog
constructor(context: Context) : Dialog(context) {
    init {
        setCanceledOnTouchOutside(false)
//        window?.apply {
//            addFlags(WindowManager.LayoutParams.TYPE_PHONE)
//        }
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_loading)
        setCancelable(false)
    }
}
