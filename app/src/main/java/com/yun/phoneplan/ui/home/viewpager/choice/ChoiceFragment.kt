package com.yun.phoneplan.ui.home.viewpager.choice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.yun.phoneplan.R
import com.yun.phoneplan.BR
import com.yun.phoneplan.base.BaseBindingFragment
import com.yun.phoneplan.data.Constant
import com.yun.phoneplan.databinding.FragmentChoiceBinding
import com.yun.phoneplan.ui.home.HomeViewModel
import com.yun.phoneplan.ui.popup.TestPopup
import org.koin.android.viewmodel.ext.android.viewModel

class ChoiceFragment
    : BaseBindingFragment<FragmentChoiceBinding, ChoiceViewModel>(ChoiceViewModel::class.java){
    override val viewModel: ChoiceViewModel by viewModel()
    override fun getResourceId(): Int = R.layout.fragment_choice
    override fun initData(): Boolean = true
    override fun onBackEvent() { }
    override fun setVariable(): Int = BR.choice

    val viewPagerFragment: HomeViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        authkey	String (필수)	인증키
//        voice	    String (필수)	월 평균 통화량 (입력단위:분, 무제한:999999)
//        data	    String (필수)	월 평균 데이터 사용량 (입력단위:MB, 무제한:999999)
//        sms	    String (필수)	월 평균 문자 발송량 (입력단위:건, 무제한:999999)

//        age	    String (필수)	연령(성인:20, 청소년:18, 실버:65)
//        type	    String (필수)	서비스 타입(3G:2, LTE:3, 5G:6)
//        dis	    String (필수)	약정기간 (무약정:0, 12개월:12, 24개월:24)


        binding.apply {

            btnSearch.setOnClickListener {

                viewModel.apply {
                    if(ageTitle.value != "" && disTitle.value != "" && disTitle.value != ""){

//                viewPagerFragment.callApi()
                        viewModel.settings()
                        viewPagerFragment.test(viewModel.ageTitle.value!! + ' ' + viewModel.disTitle.value!! + ' ' + viewModel.typeTitle.value!!)

//                viewPagerFragment.screen.value = Constant.LIST_SCREEN
                    } else{
                        Toast.makeText(requireContext(),"값 전부 입력하세요",Toast.LENGTH_SHORT).show()
                    }
                }

            }

            btn1.setOnClickListener {
                openDialog(Constant.AGE_CLICK)
            }

            btn2.setOnClickListener {
                openDialog(Constant.DIS_CLICK)
            }

            btn3.setOnClickListener {
                openDialog(Constant.TYPE_CLICK)
            }
        }

    }

    private fun openDialog(click: Int) {
        TestPopup().apply {
            showPopup(
                requireContext(),
                when (click) {
                    Constant.AGE_CLICK -> viewModel.ageItems.value!!
                    Constant.DIS_CLICK -> viewModel.disItems.value!!
                    Constant.TYPE_CLICK -> viewModel.typeItems.value!!
                    else -> arrayListOf()
                }
            )
            setDialogListener(object : TestPopup.CustomDialogListener {
                override fun onResultClicked(position: Int) {
                    when (click) {
                        Constant.AGE_CLICK -> {
                            viewModel.ageTitle.value = Constant.AGE_ARRAY[position]
                            viewModel.ageItems.value!!.forEach {
                                it.check = it.id == position
                            }
                        }
                        Constant.DIS_CLICK -> {
                            viewModel.disTitle.value = Constant.DIS_ARRAY[position]
                            viewModel.disItems.value!!.forEach {
                                it.check = it.id == position
                            }
                        }
                        Constant.TYPE_CLICK -> {
                            viewModel.typeTitle.value = Constant.TYPE_ARRAY[position]
                            viewModel.typeItems.value!!.forEach {
                                it.check = it.id == position
                            }
                        }
                    }

                }
            })
        }
    }
}