package com.example.skinbeauty.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.skinbeauty.R;

public class ConditionsFragment extends Fragment {

    private CheckBox checkboxConditions;
    private Button continueButton;

    public ConditionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conditions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkboxConditions = view.findViewById(R.id.checkbox_conditions);
        continueButton = view.findViewById(R.id.button_result);

        checkboxConditions.setOnCheckedChangeListener((buttonView, isChecked) -> {
            continueButton.setEnabled(isChecked);
        });

        continueButton.setOnClickListener(v -> {
            // Navigate to the next fragment
            NavHostFragment.findNavController(ConditionsFragment.this)
                    .navigate(R.id.action_conditionsFragment_to_noticeFragment);
        });
    }
}
