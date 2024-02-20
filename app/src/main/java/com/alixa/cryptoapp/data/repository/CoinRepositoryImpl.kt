package com.alixa.cryptoapp.data.repository

import com.alixa.cryptoapp.data.remote.CoinPaprikaApi
import com.alixa.cryptoapp.data.remote.dto.CoinDetailDto
import com.alixa.cryptoapp.data.remote.dto.CoinDto
import com.alixa.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}