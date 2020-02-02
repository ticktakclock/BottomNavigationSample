package com.github.ticktakclock.bottomnavigationsample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.ticktakclock.bottomnavigationsample.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        val button: Button = root.findViewById(R.id.button)
        button.setOnClickListener {
            val editText: EditText = root.findViewById(R.id.editText)
            val textValue = editText.text.toString()
            // 以前はリソースIDを直接指定していたが今回は引数を含めたDestinationを指定
            val destination =
                HomeFragmentDirections.actionNavigationHomeToNavigationDashboard(textValue)
            findNavController().navigate(destination)
//            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        return root
    }
}