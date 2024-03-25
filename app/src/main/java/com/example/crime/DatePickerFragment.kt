package com.example.crime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.crime.databinding.FragmentDatePickerBinding

open class DatePickerFragment : DialogFragment() {

    private lateinit var binding: FragmentDatePickerBinding
    private val sharedViewModel: CrimeDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDatePickerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (binding) {

            // Setting default checks for RadioGroup
            rgTitle.check(R.id.rbTitle1)
            rgDate.check(R.id.rbDate1)
            rgTime.check(R.id.rbTime1)

            btnSetDate.setOnClickListener {
                rgDate.visibility = View.VISIBLE
                rgTime.visibility = View.GONE
                rgTitle.visibility = View.GONE
            }

            btnSetTime.setOnClickListener {
                rgTime.visibility = View.VISIBLE
                rgDate.visibility = View.GONE
                rgTitle.visibility = View.GONE
            }

            btnSetTitle.setOnClickListener {
                rgTitle.visibility = View.VISIBLE
                rgDate.visibility = View.GONE
                rgTime.visibility = View.GONE
            }

            btnApply.setOnClickListener {

                val selectedDateId = rgDate.checkedRadioButtonId
                val selectedTimeId = rgTime.checkedRadioButtonId
                val selectedTitleId = rgTitle.checkedRadioButtonId
                val date = binding.root.findViewById<RadioButton>(selectedDateId).text.toString()
                val time = binding.root.findViewById<RadioButton>(selectedTimeId).text.toString()
                val title = binding.root.findViewById<RadioButton>(selectedTitleId).text.toString()
                val isSolved = binding.checkBox.isChecked

                sharedViewModel.currentCrimeState.value = Crime(
                    title = title,
                    id = 1,
                    date = date,
                    time = time,
                    isSolved = isSolved
                )
                dismiss()
            }
        }
    }
}