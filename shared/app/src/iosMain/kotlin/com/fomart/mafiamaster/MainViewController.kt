package com.fomart.mafiamaster

import androidx.compose.ui.window.ComposeUIViewController
import com.fomart.mafiamaster.core.resources.theme.MafiaMasterTheme
import com.fomart.mafiamaster.ui.MafiaMasterApp

fun MainViewController() = ComposeUIViewController {
    MafiaMasterTheme {
        MafiaMasterApp()
    }
}