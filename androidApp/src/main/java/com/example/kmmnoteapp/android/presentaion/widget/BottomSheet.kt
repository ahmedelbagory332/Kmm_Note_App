package com.example.kmmnoteapp.android.presentaion.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    noteTitle: String,
    onNoteTitleChange: (String) -> Unit,
    noteContent: String,
    onNoteContentChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    onDismiss: () -> Unit
) {

    if (isBottomSheetVisible) {

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RectangleShape,
            dragHandle = null,
            scrimColor = Color.Black.copy(alpha = .5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                FilledIconButton(
                    modifier = Modifier.size(48.dp),
                    onClick = onDismiss,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {

                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Dismiss the dialog."
                    )

                }

            }
            Column(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(top = 12.dp)
                    .clip(shape = RoundedCornerShape(24.dp))
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = noteTitle,
                    onValueChange = onNoteTitleChange,
                    label = { Text(text = "Note Title") },
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = noteContent,
                    onValueChange = onNoteContentChange,
                    label = { Text(text = "Note Content") },
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onSaveClick,
                    content = { Text(text = "Save") }
                )

            }

        }

    }

}