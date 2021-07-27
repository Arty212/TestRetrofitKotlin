package com.example.testretrofit.model

import com.google.gson.annotations.SerializedName

class TotalData {

    @SerializedName("TotalConfirmed")
    var totalConfirmed = 0

    @SerializedName("TotalDeaths")
    var totalDeaths = 0

    @SerializedName("TotalRecovered")
    var totalRecovered = 0
    override fun toString(): String {
        return """
               TotalConfirmed $totalConfirmed
               TotalDeaths $totalDeaths
               TotalRecovered $totalRecovered
               """.trimIndent()
    }
}