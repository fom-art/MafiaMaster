package com.thalesgroup.ibs.idc.core.designsystem.animated_vectors

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import facedatacollection.core.designsystem.generated.resources.Res
import facedatacollection.core.designsystem.generated.resources.checkmark
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun AnimatedCheckMark(
    modifier: Modifier,
    isAnimationStarted: Boolean,
    durationMillis: Int
) {
//    val nativeViewFactory = LocalNativeViewFactory.current
//    UIKitViewController(
//        modifier = modifier,
//        factory = {
//            nativeViewFactory.createCheckMarkAnimationView()
//        }
//    )
    AnimatedVisibility(isAnimationStarted, enter = slideInVertically()) {
        Image(
            modifier = modifier
                .aspectRatio(1f),
            painter = painterResource(Res.drawable.checkmark),
            contentDescription = null
        )
    }
}
