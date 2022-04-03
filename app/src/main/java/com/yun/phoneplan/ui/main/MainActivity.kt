package com.yun.phoneplan.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yun.phoneplan.R
import com.yun.phoneplan.custom.LoadingDialog
import com.yun.phoneplan.databinding.ActivityMainBinding
import com.yun.phoneplan.util.PreferenceManager
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    val sharedPreferences: PreferenceManager by inject()

    lateinit var dialog: LoadingDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.main = mainViewModel

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)


        dialog = LoadingDialog(this)
        mainViewModel.isLoading.observe(this, {
            if (it) {
                dialog.show()
            } else {
                dialog.dismiss()
            }
        })
    }
}