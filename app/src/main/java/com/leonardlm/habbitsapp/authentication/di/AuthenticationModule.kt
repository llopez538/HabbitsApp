package com.leonardlm.habbitsapp.authentication.di

import com.leonardlm.habbitsapp.authentication.data.matcher.EmailMatcherImpl
import com.leonardlm.habbitsapp.authentication.data.repository.AuthenticationRepositoryImpl
import com.leonardlm.habbitsapp.authentication.domain.matcher.EmailMatcher
import com.leonardlm.habbitsapp.authentication.domain.model.LoginUseCases
import com.leonardlm.habbitsapp.authentication.domain.model.SignupUseCases
import com.leonardlm.habbitsapp.authentication.domain.repository.AuthenticationRepository
import com.leonardlm.habbitsapp.authentication.domain.usecase.GetUserIdUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.LogOutUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.LoginWithEmailUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.SignupWithEmailUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.ValidateEmailUseCase
import com.leonardlm.habbitsapp.authentication.domain.usecase.ValidatePasswordUseCase
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

    @Provides
    @Singleton
    fun providesEmailMatcher() : EmailMatcher {
        return EmailMatcherImpl()
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(
        loginRepository: AuthenticationRepository,
        emailMatcher: EmailMatcher
        ) : LoginUseCases  {
        return LoginUseCases(
            loginWithEmailUseCase = LoginWithEmailUseCase(loginRepository),
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
            validatePasswordUseCase = ValidatePasswordUseCase()
        )
    }

    @Provides
    @Singleton
    fun provideSignupUseCase(
        signupRepository: AuthenticationRepository,
        emailMatcher: EmailMatcher
    ) : SignupUseCases {
        return SignupUseCases(
            signupWithEmailUseCase = SignupWithEmailUseCase(signupRepository),
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
            validatePasswordUseCase = ValidatePasswordUseCase()
        )
    }

    @Provides
    @Singleton
    fun provideGetUserIdUseCase(
        authenticationRepository: AuthenticationRepository
    ) : GetUserIdUseCase {
        return GetUserIdUseCase(
            repository = authenticationRepository
        )
    }

    @Provides
    @Singleton
    fun provideLogOutUseCase(
        repository: AuthenticationRepository
    ) : LogOutUseCase {
        return LogOutUseCase(repository)
    }
}