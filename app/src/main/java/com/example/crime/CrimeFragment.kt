package com.example.crime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.crime.databinding.FragmentCrimeBinding


class CrimeFragment : Fragment() {

    private lateinit var binding: FragmentCrimeBinding
    private val sharedViewModel: CrimeDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrimeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.setDefaultCrime()

        with (binding) {

            sharedViewModel.currentCrimeState.observe(viewLifecycleOwner, Observer {
                tvCrime.text = getString(
                    R.string.crimeText,
                    it.title,
                    it.id.toString(),
                    it.date,
                    it.time,
                    it.isSolved.toString()
                )
            })

            btnChange.setOnClickListener {
                val dialog = DatePickerFragment()
                dialog.show(requireActivity().supportFragmentManager, "datePicker")
            }
        }
    }
}