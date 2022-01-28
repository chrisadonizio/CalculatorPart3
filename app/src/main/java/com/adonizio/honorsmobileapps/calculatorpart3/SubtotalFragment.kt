package com.adonizio.honorsmobileapps.calculatorpart3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.adonizio.honorsmobileapps.calculatorpart3.databinding.FragmentSubtotalBinding

private var _binding : FragmentSubtotalBinding? = null
private val binding get() = _binding!!
class SubtotalFragment : Fragment() {
    private var subtotal:Int = 0
    lateinit var buttonList: List<Button>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSubtotalBinding.inflate(inflater, container, false)
        val rootView = binding.root
        buttonList = listOf(binding.button, binding.button2, binding.button3, binding.button4, binding.button5, binding.button6, binding.button7, binding.button8,binding.button9,binding.button11)
        var addition = 0
        for (button in buttonList) {
            button.setOnClickListener { view ->
                when (view) {
                    binding.button -> addition = 1
                    binding.button2 -> addition = 2
                    binding.button3 -> addition = 3
                    binding.button4 -> addition = 4
                    binding.button5 -> addition = 5
                    binding.button6 -> addition = 6
                    binding.button7 -> addition = 7
                    binding.button8 -> addition = 8
                    binding.button9 -> addition = 9
                    binding.button11 -> addition = 0
                }
                subtotal = (subtotal * 10) + addition
                binding.textView4.text = "$${subtotal.toString()}.00"
            }
        }
        binding.button10.setOnClickListener{
            subtotal = subtotal/10
            binding.textView4.text = "$${subtotal.toString()}.00"
        }
        binding.button12.setOnClickListener{
            if(subtotal!=0) {
                val action = SubtotalFragmentDirections.actionSubtotalFragmentToTipFragment(subtotal)
                rootView.findNavController().navigate(action)
            }
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}