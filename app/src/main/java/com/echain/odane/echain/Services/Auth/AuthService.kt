package com.echain.odane.echain.Services.Auth

import android.util.Log
import com.echain.odane.echain.Models.User
import com.echain.odane.echain.Utils.BASE_URL
import com.echain.odane.echain.Utils.URL_LOGIN
import com.echain.odane.echain.Utils.URL_REGISTER
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

/**
 * Created by ksteere on 3/1/2018.
 */

interface AuthService {

    @POST(URL_REGISTER)
    fun registerUser(@Body user: User): io.reactivex.Observable<Result>

    @POST(URL_LOGIN)
    fun loginUser(@Body user: User): io.reactivex.Observable<Result>

    companion object Factory {
        fun create(): AuthService {
            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
            val loggingInterceptor = HttpLoggingInterceptor({ l -> Log.d("HTTP", l)})
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            httpClientBuilder.addInterceptor(loggingInterceptor)
            val httpClient = httpClientBuilder.build()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(AuthService::class.java)
        }
    }

}