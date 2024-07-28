package com.example.skinbeauty.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.skinbeauty.ui.questions.SharedViewModel
import com.example.test.ui.theme.TestTheme

class Answer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    val analysisViewModel: AnalysisViewModel = viewModel()
                    val sharedViewModel: SharedViewModel = viewModel()

                    // 获取传递过来的总结数据
                    val summaryData = intent.getStringExtra("summary_data") ?: "No data available"

                    // 将总结数据传递给 AnalysisScreen 进行显示
                    AnalysisScreen(analysisViewModel, sharedViewModel, summaryData)
                }
            }
        }
    }
}
