package com.example.skinbeauty.ui.tips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.example.skinbeauty.R;
import com.example.skinbeauty.databinding.FragmentTipsBinding;

public class TipsFragment extends Fragment {

    private FragmentTipsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TipsViewModel tipsViewModel = new ViewModelProvider(this).get(TipsViewModel.class);

        binding = FragmentTipsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setUpButtonClickListeners();

        return root;
    }

    private void setUpButtonClickListeners() {
        binding.buttonDrySkin.setOnClickListener(v -> navigateToFragment(R.id.action_nav_slideshow_to_drySkinFragment));
        binding.buttonFineLines.setOnClickListener(v -> navigateToFragment(R.id.action_nav_slideshow_to_fineLinesFragment));
        binding.buttonFirmness.setOnClickListener(v -> navigateToFragment(R.id.action_nav_slideshow_to_firmnessFragment));
        binding.buttonPigmentation.setOnClickListener(v -> navigateToFragment(R.id.action_nav_slideshow_to_pigmentationFragment));
        binding.buttonRadiance.setOnClickListener(v -> navigateToFragment(R.id.action_nav_slideshow_to_radianceFragment));
        binding.buttonUnderEyeBags.setOnClickListener(v -> navigateToFragment(R.id.action_nav_slideshow_to_underEyeBagsFragment));
        binding.buttonWrinkles.setOnClickListener(v -> navigateToFragment(R.id.action_nav_slideshow_to_wrinklesFragment));
    }

    private void navigateToFragment(int actionId) {
        NavHostFragment.findNavController(TipsFragment.this).navigate(actionId);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
