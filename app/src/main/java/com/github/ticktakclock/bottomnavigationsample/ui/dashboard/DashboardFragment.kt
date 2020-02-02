package com.github.ticktakclock.bottomnavigationsample.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.ticktakclock.bottomnavigationsample.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private val args: DashboardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        val button: Button = root.findViewById(R.id.button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_sub)
        }

        // こちらでも良いがNullだったときの考慮が必要なためnavArgs()の利用を推奨
//        arguments?.let {
//            val args = DashboardFragmentArgs.fromBundle(it)
//            val argsText: TextView = root.findViewById(R.id.text_args)
//            argsText.text = args.editName
//        }

        val argsText: TextView = root.findViewById(R.id.text_args)
        argsText.text = args.editName
        return root
    }
}