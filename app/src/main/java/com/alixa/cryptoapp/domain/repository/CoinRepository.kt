package com.alixa.cryptoapp.domain.repository

import com.alixa.cryptoapp.data.remote.dto.CoinDetailDto
import com.alixa.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}