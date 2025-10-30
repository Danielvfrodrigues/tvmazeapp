package br.com.workfinity.tvmazeapp.data.remote.di

import br.com.workfinity.tvmazeapp.data.local.dao.TvMazeDao
import br.com.workfinity.tvmazeapp.data.remote.TvMazeApiService
import br.com.workfinity.tvmazeapp.data.remote.repository.TvMazeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRemoteModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.tvmaze.com/shows/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit,
    ): TvMazeApiService = retrofit.create(TvMazeApiService::class.java)

    @Provides
    @Singleton
    fun provideTvMazeRepository(
        apiService: TvMazeApiService,
        tvMazeDao: TvMazeDao,
    ) = TvMazeRepositoryImpl(
        api = apiService,
        dao = tvMazeDao
    )
}
