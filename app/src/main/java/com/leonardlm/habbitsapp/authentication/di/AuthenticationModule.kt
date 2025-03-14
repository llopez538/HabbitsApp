package com.leonardlm.habbitsapp.authentication.di

import com.leonardlm.habbitsapp.authentication.data.repository.AuthenticationRepositoryImpl
import com.leonardlm.habbitsapp.authentication.domain.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {
    @Provides
    @Singleton
    fun provideAuthenticationRepository() : AuthenticationRepository {
        return AuthenticationRepositoryImpl()

    }
}