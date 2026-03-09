package com.example.hostelreviewapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hostelreviewapp.model.Review


@Composable
fun ReviewForm(){
    var email by remember { mutableStateOf("") }
    var daysStayed by remember { mutableStateOf("") }

    var locationRating by remember { mutableStateOf(5f) }
    var valueRating by remember { mutableStateOf(5f) }
    var staffRating by remember { mutableStateOf(5f) }

    var resultMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ){

        Text(text = "Email")
        TextField(
            value = email,
            onValueChange = {newValue -> email = newValue},
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Days Stayed")
        TextField(
            value = daysStayed,
            onValueChange = { newValue -> daysStayed = newValue},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Location Score: ${locationRating.toInt()}")
        Slider(
            value = locationRating,
            onValueChange = {newValue -> locationRating = newValue},
            valueRange = 0f..10f
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Value Score: ${valueRating.toInt()}")
        Slider(
            value = valueRating,
            onValueChange = {newValue -> valueRating = newValue},
            valueRange = 0f..10f
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Staff score: ${staffRating.toInt()}")
        Slider(
            value = staffRating,
            onValueChange = {newValue -> staffRating = newValue},
            valueRange = 0f..10f
        )

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                if (email.isNotEmpty() && daysStayed.isNotEmpty()){

                    val myReview = Review(
                        email = email,
                        daysStayed = daysStayed.toIntOrNull() ?: 0,
                        locationRating = locationRating,
                        valueForMoneyRating = valueRating,
                        staffRating = staffRating
                    )

                    val score = myReview.calculateReviewScore()

                    resultMessage = "Review submitted! Score: $score"

                    email = ""
                    daysStayed = ""
                    locationRating = 5f
                    valueRating = 5f
                    staffRating = 5f
                }else{
                    resultMessage = "Error: Please complete all fields!"
                }
                println("Review submitted")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Review")
        }
        if (resultMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = resultMessage, style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewFormPreview(){
    ReviewForm()
}