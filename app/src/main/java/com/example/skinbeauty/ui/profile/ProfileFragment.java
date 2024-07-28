package com.example.skinbeauty.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.skinbeauty.R;

public class ProfileFragment extends Fragment {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private Button buttonUpdate;
    private Button buttonBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextUsername = view.findViewById(R.id.editText_username);
        editTextPassword = view.findViewById(R.id.editText_password);
        editTextEmail = view.findViewById(R.id.editText_email);
        editTextPhone = view.findViewById(R.id.editText_phone);
        buttonUpdate = view.findViewById(R.id.button_update);
        buttonBack = view.findViewById(R.id.button_back);

        buttonUpdate.setOnClickListener(v -> saveProfileInfo());

        buttonBack.setOnClickListener(v -> {
            // Navigate back to the HomeFragment
            NavHostFragment.findNavController(ProfileFragment.this)
                    .navigate(R.id.action_nav_profile_to_nav_home);
        });

        loadProfileInfo();
    }

    private void saveProfileInfo() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.apply();

        Toast.makeText(getActivity(), "Profile updated", Toast.LENGTH_SHORT).show();
    }

    private void loadProfileInfo() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        String email = sharedPreferences.getString("email", "");
        String phone = sharedPreferences.getString("phone", "");

        editTextUsername.setText(username);
        editTextPassword.setText(password);
        editTextEmail.setText(email);
        editTextPhone.setText(phone);
    }
}
