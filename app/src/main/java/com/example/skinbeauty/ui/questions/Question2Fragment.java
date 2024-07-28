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

public class Question2Fragment extends Fragment {

    private SharedViewModel sharedViewModel;

    public Question2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question2, container, false);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        Button button18_24 = view.findViewById(R.id.button_18_24);
        Button button25_34 = view.findViewById(R.id.button_25_34);
        Button button35_44 = view.findViewById(R.id.button_35_44);
        Button button45_54 = view.findViewById(R.id.button_45_54);
        Button button50Plus = view.findViewById(R.id.button_50_plus);

        button18_24.setOnClickListener(v -> saveDataAndNavigate("18-24"));
        button25_34.setOnClickListener(v -> saveDataAndNavigate("25-34"));
        button35_44.setOnClickListener(v -> saveDataAndNavigate("35-44"));
        button45_54.setOnClickListener(v -> saveDataAndNavigate("45-54"));
        button50Plus.setOnClickListener(v -> saveDataAndNavigate("50+"));

        return view;
    }

    private void saveDataAndNavigate(String data) {
        sharedViewModel.setQuestion2Data(data);
        NavHostFragment.findNavController(Question2Fragment.this)
                .navigate(R.id.action_question2Fragment_to_question3Fragment);
    }
}
