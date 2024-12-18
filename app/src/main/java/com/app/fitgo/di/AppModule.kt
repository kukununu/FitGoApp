package com.app.fitgo.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.memory.MemoryCache
import com.app.fitgo.data.database.FitGoDatabase
import com.app.fitgo.data.repository.PostRepositoryImpl
import com.app.fitgo.data.repository.TrainerRepositoryImpl
import com.app.fitgo.data.repository.UserRepositoryImpl
import com.app.fitgo.data_store.DataStoreManager
import com.app.fitgo.domain.repository.PostRepository
import com.app.fitgo.domain.repository.TrainerRepository
import com.app.fitgo.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFitGoDatabase(app : Application) : FitGoDatabase {
        return Room.databaseBuilder(
            app,
            FitGoDatabase::class.java,
            FitGoDatabase.DATABASE_NAME
        )
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
    }

    @Provides
    @Singleton
    fun providePostRepository(db : FitGoDatabase) : PostRepository {
        return PostRepositoryImpl(db.postDao)
    }
    @Provides
    @Singleton
    fun provideUserRepository(db : FitGoDatabase) : UserRepository {
        return UserRepositoryImpl(db.userDao)
    }
    @Provides
    @Singleton
    fun provideTrainerRepository(db : FitGoDatabase) : TrainerRepository {
        return TrainerRepositoryImpl(db.trainerDao)
    }

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }

    @Singleton
    fun provideImageLoader(context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .memoryCache {
                MemoryCache.Builder(context)
                    .maxSizePercent(0.25) // Use 25% of the app's memory
                    .build()
            }
            .crossfade(true)
            .components {
                add(SvgDecoder.Factory()) // Add support for SVG images, if needed
            }
            .build()
    }



}