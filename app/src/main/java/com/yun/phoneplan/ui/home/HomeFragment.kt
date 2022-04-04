package com.yun.phoneplan.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yun.phoneplan.base.BaseBindingFragment
import com.yun.phoneplan.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel
import com.yun.phoneplan.R
import com.yun.phoneplan.BR
import com.yun.phoneplan.custom.ZoomOutPageTransformer
import com.yun.phoneplan.data.Constant
import com.yun.phoneplan.ui.home.viewpager.choice.ChoiceFragment
import com.yun.phoneplan.ui.home.viewpager.list.ListFragment
import com.yun.phoneplan.ui.popup.TestPopup

class HomeFragment
    : BaseBindingFragment<FragmentHomeBinding, HomeViewModel>(HomeViewModel::class.java) {
    override val viewModel: HomeViewModel by viewModel()
    override fun initData(): Boolean = true
    override fun setVariable(): Int = BR.home
    override fun getResourceId(): Int = R.layout.fragment_home
    override fun onBackEvent() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.screen.observe(viewLifecycleOwner,{
            if(it == Constant.CHOICE_SCREEN || it == Constant.LIST_SCREEN){
                binding.vpPhone.setCurrentItem(it, true)
            }
        })

        binding.apply {
            vpPhone.run {
                setPageTransformer(ZoomOutPageTransformer())
                isUserInputEnabled = false
                adapter = object : FragmentStateAdapter(this@HomeFragment) {
                    override fun getItemCount(): Int = 2
                    override fun createFragment(position: Int): Fragment {
                        return when (position) {
                            0 -> ChoiceFragment()
                            1 -> ListFragment()
                            else -> Fragment()
                        }
                    }
                }
            }
        }

    }


}