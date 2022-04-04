package com.yun.phoneplan.data.model

import com.yun.phoneplan.base.Item

data class SpinnerModel(
    override val id: Int,
    override val viewType: Int = 0,
    var title: String,
    var check: Boolean = false
) : Item()
