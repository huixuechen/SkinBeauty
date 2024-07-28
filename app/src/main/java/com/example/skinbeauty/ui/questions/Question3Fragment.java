package com.example.skinbeauty.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.skinbeauty.R;

public class Question3Fragment extends Fragment {
    private SharedViewModel sharedViewModel;

    private CheckBox checkboxNormal;
    private CheckBox checkboxDry;
    private CheckBox checkboxOily;
    private CheckBox checkboxCombination;

    public Question3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question3, container, false);

        checkboxNormal = view.findViewById(R.id.checkbox_normal);
        checkboxDry = view.findViewById(R.id.checkbox_dry);
        checkboxOily = view.findViewById(R.id.checkbox_oily);
        checkboxCombination = view.findViewById(R.id.checkbox_combination);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        LinearLayout normalSkin = view.findViewById(R.id.normal_skin);
        LinearLayout drySkin = view.findViewById(R.id.dry_skin);
        LinearLayout oilySkin = view.findViewById(R.id.oily_skin);
        LinearLayout combinationSkin = view.findViewById(R.id.combination_skin);

        View.OnClickListener listener = v -> {
            String skinType = "";
            int id = v.getId();
            if (id == R.id.normal_skin) {
                updateCheckboxes(true, false, false, false);
                skinType = "Normal";
            } else if (id == R.id.dry_skin) {
                updateCheckboxes(false, true, false, false);
                skinType = "Dry";
            } else if (id == R.id.oily_skin) {
                updateCheckboxes(false, false, true, false);
                skinType = "Oily";
            } else if (id == R.id.combination_skin) {
                updateCheckboxes(false, false, false, true);
                skinType = "Combination";
            }

            // Save the selected skin type to the shared view model
            sharedViewModel.setQuestion3Data(skinType);

            // Navigate to the next fragment
            NavHostFragment.findNavController(Question3Fragment.this)
                    .navigate(R.id.action_question3Fragment_to_question4Fragment);
        };

        normalSkin.setOnClickListener(listener);
        drySkin.setOnClickListener(listener);
        oilySkin.setOnClickListener(listener);
        combinationSkin.setOnClickListener(listener);

        return view;
    }

    private void updateCheckboxes(boolean normal, boolean dry, boolean oily, boolean combination) {
        checkboxNormal.setChecked(normal);
        checkboxDry.setChecked(dry);
        checkboxOily.setChecked(oily);
        checkboxCombination.setChecked(combination);
    }
}
