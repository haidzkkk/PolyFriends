package com.fpoly.polyfriends.di.modules

import android.content.Context
import com.fpoly.polyfriends.data.network.AuthApi
import com.fpoly.polyfriends.data.network.RemoteDataSource
import com.fpoly.polyfriends.data.network.SessionManager
import com.fpoly.polyfriends.data.network.UserApi
import com.fpoly.polyfriends.data.repository.AuthRepository
import com.fpoly.polyfriends.data.repository.HomeRepository
import dagger.Module
import dagger.Provides

@Module
object NetworkModule {

    @Provides
    fun providerSessionManager(
        context: Context
    ) : SessionManager = SessionManager(context.applicationContext)

    @Provides
    fun providerRemoteDateSource(): RemoteDataSource = RemoteDataSource()

    @Provides
    fun providerApiUser(
        remoteDataSource: RemoteDataSource,
        context: Context
    ): UserApi = remoteDataSource.buildApi(UserApi::class.java, context)

    @Provides
    fun providerHomeRepository(
        api: UserApi
    ): HomeRepository = HomeRepository(api)

    @Provides
    fun providerApiAuth(
        remoteDataSource: RemoteDataSource,
        context: Context
    ): AuthApi = remoteDataSource.buildApi(AuthApi::class.java, context)

    @Provides
    fun providerAuthRepository(
        api: AuthApi
    ): AuthRepository = AuthRepository(api)
}

