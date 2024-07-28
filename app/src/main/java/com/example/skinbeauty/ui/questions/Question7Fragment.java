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

public class Question7Fragment extends Fragment {

    private SharedViewModel sharedViewModel;

    public Question7Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question7, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        CheckBox chipDrySkin = view.findViewById(R.id.chip_dry_skin);
        CheckBox chipFineLines = view.findViewById(R.id.chip_fine_lines);
        CheckBox chipFirmness = view.findViewById(R.id.chip_firmness);
        CheckBox chipPigmentation = view.findViewById(R.id.chip_pigmentation);
        CheckBox chipRadiance = view.findViewById(R.id.chip_radiance);
        CheckBox chipUnderEyeBags = view.findViewById(R.id.chip_under_eye_bags);
        CheckBox chipWrinkles = view.findViewById(R.id.chip_wrinkles);
        CheckBox chipOthers = view.findViewById(R.id.chip_others);
        Button buttonNext = view.findViewById(R.id.button_next);

        buttonNext.setOnClickListener(v -> {
            StringBuilder selectedConcerns = new StringBuilder();

            if (chipDrySkin.isChecked()) {
                selectedConcerns.append("Dry skin, ");
            }
            if (chipFineLines.isChecked()) {
                selectedConcerns.append("Fine lines, ");
            }
            if (chipFirmness.isChecked()) {
                selectedConcerns.append("Firmness, ");
            }
            if (chipPigmentation.isChecked()) {
                selectedConcerns.append("Pigmentation, ");
            }
            if (chipRadiance.isChecked()) {
                selectedConcerns.append("Radiance, ");
            }
            if (chipUnderEyeBags.isChecked()) {
                selectedConcerns.append("Under Eye Bags, ");
            }
            if (chipWrinkles.isChecked()) {
                selectedConcerns.append("Wrinkles, ");
            }
            if (chipOthers.isChecked()) {
                selectedConcerns.append("Others, ");
            }

            // Remove the last comma and space
            if (selectedConcerns.length() > 0) {
                selectedConcerns.setLength(selectedConcerns.length() - 2);
            }

            // 将数据保存到 ViewModel
            sharedViewModel.setQuestion7Data(selectedConcerns.toString());

            // 将数据传递到 AnswerFragment
            Bundle bundle = new Bundle();
            bundle.putString("answer1", sharedViewModel.getQuestion1Data().getValue());
            bundle.putString("answer2", sharedViewModel.getQuestion2Data().getValue());
            bundle.putString("answer3", sharedViewModel.getQuestion3Data().getValue());
            bundle.putString("answer4", sharedViewModel.getQuestion4Data().getValue());
            bundle.putString("answer5", sharedViewModel.getQuestion5Data().getValue());
            bundle.putString("answer6", sharedViewModel.getQuestion6Data().getValue());
            bundle.putString("answer7", sharedViewModel.getQuestion7Data().getValue());

            NavHostFragment.findNavController(Question7Fragment.this)
                    .navigate(R.id.action_question7Fragment_to_uploadFragment, bundle);
        });
    }
}
