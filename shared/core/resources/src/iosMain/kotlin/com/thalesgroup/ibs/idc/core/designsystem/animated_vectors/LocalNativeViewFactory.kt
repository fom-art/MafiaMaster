package com.thalesgroup.ibs.idc.core.designsystem.animated_vectors

import androidx.compose.runtime.staticCompositionLocalOf

val LocalNativeViewFactory = staticCompositionLocalOf<NativeViewFactory> {
    error("No video recorder factory provided.")
}