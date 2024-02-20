package com.alixa.cryptoapp.domain.use_case.get_coin

import com.alixa.cryptoapp.common.Resource
import com.alixa.cryptoapp.data.remote.dto.toCoinDetails
import com.alixa.cryptoapp.domain.model.CoinDetail
import com.alixa.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetail>(data = coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "An Unexpected error occured!"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(message = "Check your internet Connection!"))
        }
    }
}