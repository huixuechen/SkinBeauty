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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.skinbeauty.R;

public class Question6Fragment extends Fragment {

    private CheckBox morningSkincare;
    private CheckBox eveningSkincare;
    private Button continueButton;
    private SharedViewModel sharedViewModel;

    public Question6Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question6, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        morningSkincare = view.findViewById(R.id.morning_skincare);
        eveningSkincare = view.findViewById(R.id.evening_skincare);
        continueButton = view.findViewById(R.id.button_result);

        View.OnClickListener checkBoxListener = v -> updateContinueButtonState();

        morningSkincare.setOnClickListener(checkBoxListener);
        eveningSkincare.setOnClickListener(checkBoxListener);

        continueButton.setOnClickListener(v -> {
            saveData();
            // Navigate to the next fragment
            NavHostFragment.findNavController(Question6Fragment.this)
                    .navigate(R.id.action_question6Fragment_to_question7Fragment);
        });

        updateContinueButtonState();
    }

    private void updateContinueButtonState() {
        continueButton.setEnabled(morningSkincare.isChecked() || eveningSkincare.isChecked() );
    }

    private void saveData() {
        StringBuilder skincareRoutine = new StringBuilder();
        if (morningSkincare.isChecked()) {
            skincareRoutine.append("Morning Skincare, ");
        }
        if (eveningSkincare.isChecked()) {
            skincareRoutine.append("Evening Skincare, ");
        }

        if (skincareRoutine.length() > 0) {
            skincareRoutine.setLength(skincareRoutine.length() - 2); // Remove trailing comma and space
        }

        sharedViewModel.setQuestion6Data(skincareRoutine.toString());
    }
}
