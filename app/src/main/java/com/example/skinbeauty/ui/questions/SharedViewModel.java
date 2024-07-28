package com.example.skinbeauty.ui.questions;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<String> question1Data = new MutableLiveData<>();
    private final MutableLiveData<String> question2Data = new MutableLiveData<>();
    private final MutableLiveData<String> question3Data = new MutableLiveData<>();
    private final MutableLiveData<String> question4Data = new MutableLiveData<>();
    private final MutableLiveData<String> question5Data = new MutableLiveData<>();
    private final MutableLiveData<String> question6Data = new MutableLiveData<>();
    private final MutableLiveData<String> question7Data = new MutableLiveData<>();
    private final MutableLiveData<Bitmap> imageData = new MutableLiveData<>();

    public void setQuestion1Data(String data) {
        question1Data.setValue(data);
    }

    public LiveData<String> getQuestion1Data() {
        return question1Data;
    }

    public void setQuestion2Data(String data) {
        question2Data.setValue(data);
    }

    public LiveData<String> getQuestion2Data() {
        return question2Data;
    }

    public void setQuestion3Data(String data) {
        question3Data.setValue(data);
    }

    public LiveData<String> getQuestion3Data() {
        return question3Data;
    }

    public void setQuestion4Data(String data) {
        question4Data.setValue(data);
    }

    public LiveData<String> getQuestion4Data() {
        return question4Data;
    }

    public void setQuestion5Data(String data) {
        question5Data.setValue(data);
    }

    public LiveData<String> getQuestion5Data() {
        return question5Data;
    }

    public void setQuestion6Data(String data) {
        question6Data.setValue(data);
    }

    public LiveData<String> getQuestion6Data() {
        return question6Data;
    }

    public void setQuestion7Data(String data) {
        question7Data.setValue(data);
    }

    public LiveData<String> getQuestion7Data() {
        return question7Data;
    }

    public void setBitmap(Bitmap bitmap) {
        imageData.setValue(bitmap);
    }

    public LiveData<Bitmap> getBitmap() {
        return imageData;
    }

    // 新的方法：将所有数据整合成一个字符串
    public String getAllDataAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Question 1: ").append(question1Data.getValue()).append("\n");
        stringBuilder.append("Question 2: ").append(question2Data.getValue()).append("\n");
        stringBuilder.append("Question 3: ").append(question3Data.getValue()).append("\n");
        stringBuilder.append("Question 4: ").append(question4Data.getValue()).append("\n");
        stringBuilder.append("Question 5: ").append(question5Data.getValue()).append("\n");
        stringBuilder.append("Question 6: ").append(question6Data.getValue()).append("\n");
        stringBuilder.append("Question 7: ").append(question7Data.getValue()).append("\n");

        return stringBuilder.toString();
    }
}
