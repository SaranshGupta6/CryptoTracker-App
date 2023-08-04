package com.example.cryptoapp.api

import retrofir2.Response
import retrofit2.http.GET
interface ApiInterface {

    @Get("data-api/v3/cryptocurrency/listing?start=1&limit=500")
    suspend fun getMarketData( ):Response<MarketModel>
}