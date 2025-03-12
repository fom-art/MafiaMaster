package com.fomart.mafiamaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme
import com.fomart.mafiamaster.ui.MafiaMasterState
import com.fomart.mafiamaster.ui.rememberApplicationState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val appState = rememberApplicationState()

            CompositionLocalProvider {
                MafiaMasterTheme {

                }
            }
        }
    }
}