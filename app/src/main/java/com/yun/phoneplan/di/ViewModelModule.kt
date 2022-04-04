package com.yun.phoneplan.di

import com.yun.phoneplan.ui.home.HomeViewModel
import com.yun.phoneplan.ui.home.viewpager.choice.ChoiceViewModel
import com.yun.phoneplan.ui.home.viewpager.list.ListViewModel
import com.yun.phoneplan.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        HomeViewModel(get(), get())
    }

    viewModel {
        ChoiceViewModel(get())
    }

    viewModel {
        ListViewModel(get())
    }
}