package com.example.skinbeauty.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.skinbeauty.R;
import com.example.skinbeauty.ui.questions.SharedViewModel;

import java.io.InputStream;

public class ChatFragment extends Fragment {
    private EditText inputMessage;
    private Button sendButton;
    private LinearLayout chatLayout;
    private ScrollView chatScrollView;
    private SharedViewModel sharedViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        inputMessage = rootView.findViewById(R.id.input_message);
        sendButton = rootView.findViewById(R.id.send_button);
        chatLayout = rootView.findViewById(R.id.chat_layout);
        chatScrollView = rootView.findViewById(R.id.chat_scroll_view);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        sendButton.setOnClickListener(v -> {
            String message = inputMessage.getText().toString().trim();
            if (!message.isEmpty()) {
                addMessageToChat("User: " + message);
                inputMessage.setText("");
                analyzeTextWithVisionApi(message);
            }
        });

        return rootView;
    }

    private void analyzeTextWithVisionApi(String text) {
        InputStream credentialsStream = getResources().openRawResource(R.raw.credentials);
    }

    private void addMessageToChat(String message) {
        TextView textView = new TextView(getContext());
        textView.setText(message);
        textView.setTextSize(16);
        textView.setPadding(8, 8, 8, 8);
        textView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.chat_bubble_background));
        chatLayout.addView(textView);
        scrollToBottom();
    }

    private void scrollToBottom() {
        chatScrollView.post(() -> chatScrollView.fullScroll(View.FOCUS_DOWN));
    }
}
