package com.alixa.cryptoapp.domain.use_case.get_coins

import com.alixa.cryptoapp.common.Resource
import com.alixa.cryptoapp.data.remote.dto.toCoin
import com.alixa.cryptoapp.domain.model.Coin
import com.alixa.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(data = coins))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Coin>>(
                    message = e.localizedMessage ?: "An Unexpected error occured!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(message = "Check your internet Connection!"))
        }
    }
}