package com.fandroid.core_ui.di

import com.fandroid.core_ui.navigation.AppNavigator
import com.fandroid.core_ui.navigation.AppNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Singleton
    @Provides
    fun provideAppNavigator(): AppNavigator {
        return AppNavigatorImpl()
    }

}
