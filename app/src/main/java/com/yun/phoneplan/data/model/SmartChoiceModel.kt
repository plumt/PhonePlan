package com.yun.phoneplan.data.model

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

object SmartChoiceModel {
    @Xml(name = "root")
    data class RS(
        @PropertyElement
        val resultCode: String?,
        @PropertyElement
        val resultData: String?,
        @PropertyElement
        val resultCount: String?,
        @Element
        val items: Items?,
    ) {

        @Xml
        data class Items(
            @Element(name = "item")
            val item: List<Item>?
        ){
            @Xml
            data class Item(
                @PropertyElement(name = "v_tel")
                val vTel: String?,
                @PropertyElement(name = "v_plan_price")
                val vPlanPrice: String?,
                @PropertyElement(name = "v_dis_price")
                val vdisPrice: String?,
                @PropertyElement(name = "v_plan_over")
                val vplanOver: String?,
                @PropertyElement(name = "v_add_name")
                val vaddName: String?,
                @PropertyElement(name = "v_plan_name")
                val vplanName: String?,
                @PropertyElement(name = "v_plan_display_voice")
                val vplanDisplayVoice: String?,
                @PropertyElement(name = "v_plan_display_data")
                val vplanDisplayData: String?,
                @PropertyElement(name = "v_plan_display_sms")
                val vplanDisplaySms: String?,
                @PropertyElement(name = "rn")
                val rn: String?
            )
        }



    }
}