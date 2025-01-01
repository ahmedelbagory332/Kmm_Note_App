package com.example.kmmnoteapp.android.presentaion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.kmmnoteapp.android.MyApplicationTheme
import com.example.kmmnoteapp.android.presentaion.widget.BottomSheet
import com.example.kmmnoteapp.android.presentaion.widget.NotesContent
import com.example.kmmnoteapp.android.presentaion.widget.Toolbar
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotesScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NotesScreen(
        noteViewModel: NoteViewModel = koinViewModel(),
    ) {
        val scope = rememberCoroutineScope()
        val state = noteViewModel.state.value
        var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState()

        Scaffold(
            topBar = {
                Toolbar(title = "KMM Notes") {
                    scope.launch {
                        isBottomSheetVisible = true
                        sheetState.expand()
                    }
                }
            },
            content = { paddingValues ->
                NotesContent(paddingValues, state){
                    noteViewModel.sendIntent(NoteIntent.DeleteNotes(it))
                }
                BottomSheet(
                    isBottomSheetVisible = isBottomSheetVisible,
                    sheetState = sheetState,
                    noteTitle = state.noteTitle,
                    onNoteTitleChange = {
                        noteViewModel.changeNoteTitle(it)
                    },
                    noteContent = state.noteContent,
                    onNoteContentChange = {
                        noteViewModel.changeNoteContent(it)
                    },
                    onSaveClick = {
                        if (state.noteTitle.isEmpty() || state.noteContent.isEmpty()) {
                            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT)
                                .show()
                            return@BottomSheet
                        }
                        noteViewModel.sendIntent(NoteIntent.InsertNotes)
                    },
                    onDismiss = {
                        scope.launch { sheetState.hide() }
                            .invokeOnCompletion { isBottomSheetVisible = false }
                    }
                )
            }
        )
    }
}