package com.yun.phoneplan.ui.home.viewpager.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.yun.phoneplan.R
import com.yun.phoneplan.BR
import com.yun.phoneplan.base.BaseBindingFragment
import com.yun.phoneplan.data.Constant
import com.yun.phoneplan.databinding.FragmentListBinding
import com.yun.phoneplan.ui.home.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment
    : BaseBindingFragment<FragmentListBinding, ListViewModel>(ListViewModel::class.java){
    override val viewModel: ListViewModel by viewModel()
    override fun getResourceId(): Int = R.layout.fragment_list
    override fun initData(): Boolean = true
    override fun onBackEvent() { }
    override fun setVariable(): Int = BR.list

    val viewPagerFragment: HomeViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnRetry.setOnClickListener {
            viewPagerFragment.screen.value = Constant.CHOICE_SCREEN
        }
    }
}