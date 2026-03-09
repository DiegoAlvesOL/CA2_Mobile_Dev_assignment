package com.example.hostelreviewapp.model

class Review (
    val email: String,
    val daysStayed: Int,
    val locationRating: Float,
    val valueForMoneyRating: Float,
    val staffRating: Float
){
    fun calculateReviewScore(): Float{
        val locationWeight = locationRating *0.40f

        val valueWeight = valueForMoneyRating * 0.30f

        val staffWeight = staffRating * 0.30f

        val finalScore = locationWeight + valueWeight + staffWeight

        return finalScore
    }
}