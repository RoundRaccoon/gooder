package com.danielnastase.gooder.model.service.module

import com.danielnastase.gooder.model.service.AuthService
import com.danielnastase.gooder.model.service.DatabaseService
import com.danielnastase.gooder.model.service.StorageService
import com.danielnastase.gooder.model.service.impl.AuthServiceImpl
import com.danielnastase.gooder.model.service.impl.DatabaseServiceImpl
import com.danielnastase.gooder.model.service.impl.StorageServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    abstract fun provideAuthService(impl: AuthServiceImpl): AuthService

    @Binds
    abstract fun provideDatabaseService(impl: DatabaseServiceImpl): DatabaseService

    @Binds
    abstract fun provideStorageService(impl: StorageServiceImpl): StorageService
}