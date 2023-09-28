package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.repo.ToDoRepository
import com.example.todoapp.room.ToDosDao
import com.example.todoapp.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //for repo
    @Provides
    @Singleton
    fun provideToDoDataSource(tDao:ToDosDao) : ToDoDataSource {
        return ToDoDataSource(tDao)
    }
    //for ViewModels
    @Provides
    @Singleton
    fun provideToDoRepository(tDs:ToDoDataSource) : ToDoRepository {
        return ToDoRepository(tDs)
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext context: Context) : ToDosDao {
        val vt = Room.databaseBuilder(context,VeriTabani::class.java,"ToDo.sqlite")
            .createFromAsset("ToDo.sqlite").build()
        return vt.getToDosDao()
    }

}