package com.geektech.homework3_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.homework3_5.databinding.ActivityMainBinding
import com.geektech.homework3_5.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var isCountTen = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startIncrementingOrDecrementing()
    }

    private fun startIncrementingOrDecrementing() = with(binding) {
        var count = tvCount.text.toString().toInt().plus(1)
        btnIncDec.setOnClickListener {
            when (isCountTen) {
                false -> {
                    when (count == 10) {
                        false -> {
                            tvCount.text = count++.toString()
                        }
                        true -> {
                            isCountTen = true
                            tvCount.text = count--.toString()
                            btnIncDec.text = "-"
                        }
                    }
                }
                true -> {
                    when (count == 0) {
                        false ->
                            tvCount.text = count--.toString()
                        true -> requireActivity().supportFragmentManager.beginTransaction().replace(
                            R.id.container,
                            SecondFragment()
                        ).addToBackStack(null).commit()
                    }
                }
            }
        }
    }
}