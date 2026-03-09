package com.example.hostelreviewapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import com.example.hostelreviewapp.ui.ReviewScreen
import com.example.hostelreviewapp.ui.theme.HostelReviewAppTheme



class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            HostelReviewAppTheme{
                ReviewScreen()
            }
        }
    }
}