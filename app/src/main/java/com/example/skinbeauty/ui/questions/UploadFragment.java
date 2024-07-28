package com.example.skinbeauty.ui.questions;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.skinbeauty.R;
import com.example.skinbeauty.ui.Answer;

import java.io.InputStream;

public class UploadFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageViewPhoto;
    private SharedViewModel sharedViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_upload_photo, container, false);

        // Initialize UI elements
        imageViewPhoto = rootView.findViewById(R.id.image_view_photo);
        Button buttonUploadPhoto = rootView.findViewById(R.id.button_upload_photo);
        Button buttonContinue = rootView.findViewById(R.id.button_result);

        // Set click listeners for buttons
        buttonUploadPhoto.setOnClickListener(v -> openImageChooser());
        buttonContinue.setOnClickListener(v -> continueToNextStep());

        // Initialize SharedViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        return rootView;
    }

    // Method to open the image chooser
    private void openImageChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // Handle the result of the image picker or camera
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
                Uri imageUri = data.getData();
                try (InputStream inputStream = getActivity().getContentResolver().openInputStream(imageUri)) {
                    Bitmap selectedImage = BitmapFactory.decodeStream(inputStream);
                    imageViewPhoto.setImageBitmap(selectedImage);
                    sharedViewModel.setBitmap(selectedImage); // Save the selected image in SharedViewModel
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method to handle the continue action
    private void continueToNextStep() {
        String allDataSummary = sharedViewModel.getAllDataAsString();
        Intent intent = new Intent(getActivity(), Answer.class);
        intent.putExtra("summary_data", allDataSummary);
        startActivity(intent);
    }
}
