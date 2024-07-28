package com.example.skinbeauty.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.skinbeauty.R;

public class Question1Fragment extends Fragment {

    private CheckBox checkBoxFemale;
    private CheckBox checkBoxMale;
    private CheckBox checkBoxOther;
    private SharedViewModel sharedViewModel;

    public Question1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question1, container, false);

        checkBoxFemale = view.findViewById(R.id.checkbox_female);
        checkBoxMale = view.findViewById(R.id.checkbox_male);
        checkBoxOther = view.findViewById(R.id.checkbox_other);
        Button continueButton = view.findViewById(R.id.button_result);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        checkBoxFemale.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBoxMale.setChecked(false);
                checkBoxOther.setChecked(false);
            }
        });

        checkBoxMale.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBoxFemale.setChecked(false);
                checkBoxOther.setChecked(false);
            }
        });

        checkBoxOther.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBoxFemale.setChecked(false);
                checkBoxMale.setChecked(false);
            }
        });

        continueButton.setOnClickListener(v -> {
            String answer = "";
            if (checkBoxFemale.isChecked()) {
                answer = "Female";
            } else if (checkBoxMale.isChecked()) {
                answer = "Male";
            } else if (checkBoxOther.isChecked()) {
                answer = "Other";
            }
            sharedViewModel.setQuestion1Data(answer);

            NavHostFragment.findNavController(Question1Fragment.this)
                    .navigate(R.id.action_question1Fragment_to_question2Fragment);
        });

        return view;
    }
}
