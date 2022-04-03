package com.yun.phoneplan.ui.home

import android.os.Bundle
import android.view.View
import com.yun.phoneplan.base.BaseBindingFragment
import com.yun.phoneplan.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel
import com.yun.phoneplan.R
import com.yun.phoneplan.BR

class HomeFragment
    : BaseBindingFragment<FragmentHomeBinding, HomeViewModel>(HomeViewModel::class.java) {
    override val viewModel: HomeViewModel by viewModel()
    override fun initData(): Boolean = true
    override fun setVariable(): Int = BR.home
    override fun getResourceId(): Int = R.layout.fragment_home
    override fun onBackEvent() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        authkey	String (필수)	인증키
//        voice	    String (필수)	월 평균 통화량 (입력단위:분, 무제한:999999)
//        data	    String (필수)	월 평균 데이터 사용량 (입력단위:MB, 무제한:999999)
//        sms	    String (필수)	월 평균 문자 발송량 (입력단위:건, 무제한:999999)
//        age	    String (필수)	연령(성인:20, 청소년:18, 실버:65)
//        type	    String (필수)	서비스 타입(3G:2, LTE:3, 5G:6)
//        dis	    String (필수)	약정기간 (무약정:0, 12개월:12, 24개월:24)



    }
}