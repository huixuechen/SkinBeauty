package com.example.skinbeauty.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.skinbeauty.R;

public class Question5Fragment extends Fragment {

    private SharedViewModel sharedViewModel;

    public Question5Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question5, container, false);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        CheckBox checkboxLackOfSleep = view.findViewById(R.id.checkbox_lack_of_sleep);
        CheckBox checkboxSmoking = view.findViewById(R.id.checkbox_smoking);
        CheckBox checkboxExcessiveDrinking = view.findViewById(R.id.checkbox_excessive_drinking);
        CheckBox checkboxNotUsingSunscreen = view.findViewById(R.id.checkbox_not_using_sunscreen);
        CheckBox checkboxUnhealthyDiet = view.findViewById(R.id.checkbox_unhealthy_diet);
        CheckBox checkboxNone = view.findViewById(R.id.checkbox_none);

        Button buttonContinue = view.findViewById(R.id.button_result);

        buttonContinue.setOnClickListener(v -> {
            StringBuilder promptBuilder = new StringBuilder();

            if (checkboxLackOfSleep.isChecked()) {
                promptBuilder.append("Lack of sleep, ");
            }
            if (checkboxSmoking.isChecked()) {
                promptBuilder.append("Smoking, ");
            }
            if (checkboxExcessiveDrinking.isChecked()) {
                promptBuilder.append("Excessive Drinking, ");
            }
            if (checkboxNotUsingSunscreen.isChecked()) {
                promptBuilder.append("Not Using Sunscreen, ");
            }
            if (checkboxUnhealthyDiet.isChecked()) {
                promptBuilder.append("Unhealthy Diet, ");
            }
            if (checkboxNone.isChecked()) {
                promptBuilder.append("None, ");
            }

            // Remove the last comma and space
            if (promptBuilder.length() > 0) {
                promptBuilder.setLength(promptBuilder.length() - 2);
            }

            String prompt = promptBuilder.toString();
            sharedViewModel.setQuestion5Data(prompt);

            // Navigate to the next fragment (Question6Fragment)
            NavHostFragment.findNavController(Question5Fragment.this)
                    .navigate(R.id.action_question5Fragment_to_question6Fragment);
        });

        return view;
    }
}
