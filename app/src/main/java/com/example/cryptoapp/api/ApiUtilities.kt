package com.example.cryptoapp.api

object ApiUtilities {

    fun getInstance();Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.coinmarketcap.com/")
            .addConverterFactory(GsonConvertorFactory.create())
            .build()
    }
}