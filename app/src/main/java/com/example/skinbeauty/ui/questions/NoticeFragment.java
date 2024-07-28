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

public class NoticeFragment extends Fragment {

    private CheckBox checkboxWarning;
    private Button continueButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        checkboxWarning = view.findViewById(R.id.checkbox_warning);
        continueButton = view.findViewById(R.id.button_result);

        checkboxWarning.setOnCheckedChangeListener((buttonView, isChecked) -> continueButton.setEnabled(isChecked));

        continueButton.setOnClickListener(v -> NavHostFragment.findNavController(NoticeFragment.this)
                .navigate(R.id.action_noticeFragment_to_question1Fragment));

        return view;
    }
}
