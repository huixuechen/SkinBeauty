package com.example.skinbeauty.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.skinbeauty.R;

public class Question4Fragment extends Fragment {

    private SharedViewModel sharedViewModel;

    public Question4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question4, container, false);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        Button buttonRegularly = view.findViewById(R.id.button_regularly);
        Button buttonFewTimes = view.findViewById(R.id.button_few_times);
        Button buttonNone = view.findViewById(R.id.button_none);

        View.OnClickListener listener = v -> {
            String exerciseFrequency = "";
            int id = v.getId();
            if (id == R.id.button_regularly) {
                exerciseFrequency = "Regularly";
            } else if (id == R.id.button_few_times) {
                exerciseFrequency = "A Few Times";
            } else if (id == R.id.button_none) {
                exerciseFrequency = "None";
            }
            sharedViewModel.setQuestion4Data(exerciseFrequency);

            // Navigate to the next fragment (Question5Fragment)
            NavHostFragment.findNavController(Question4Fragment.this)
                    .navigate(R.id.action_question4Fragment_to_question5Fragment);
        };

        buttonRegularly.setOnClickListener(listener);
        buttonFewTimes.setOnClickListener(listener);
        buttonNone.setOnClickListener(listener);

        return view;
    }
}
