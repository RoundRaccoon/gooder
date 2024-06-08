package com.danielnastase.gooder.model.service.module

import com.danielnastase.gooder.model.service.AuthService
import com.danielnastase.gooder.model.service.impl.AuthServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    abstract fun provideAuthService(impl: AuthServiceImpl): AuthService
}