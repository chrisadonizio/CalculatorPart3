package com.adonizio.honorsmobileapps.calculatorpart3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adonizio.honorsmobileapps.calculatorpart3.databinding.FragmentFinalTotalBinding
import com.adonizio.honorsmobileapps.calculatorpart3.databinding.FragmentTipBinding
import java.lang.Math.*
import kotlin.math.ceil
import kotlin.math.roundToInt

private var _binding : FragmentFinalTotalBinding? = null
private val binding get() = _binding!!

class FinalTotalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFinalTotalBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val args = FinalTotalFragmentArgs.fromBundle(requireArguments())
        var total = args.total
        val numofGuests = args.numOfGuests
        binding.textView12.text = "$%.2f".format(total)
        val decimalPerPerson = Math.round((total / numofGuests) *100)/100.0
        binding.textView10.text = "$%.2f".format(decimalPerPerson)
        binding.button13.setOnClickListener{
            binding.textView10.text = "$%.2f".format(kotlin.math.ceil(decimalPerPerson))
        }
        binding.button14.setOnClickListener{
            binding.textView10.text = "$%.2f".format(kotlin.math.floor(decimalPerPerson.toDouble()))
        }
        return rootView

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
