package com.example.kmmnoteapp.android.di

import com.example.kmmnoteapp.android.presentaion.NoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { NoteViewModel(get(), get(), get()) }
}