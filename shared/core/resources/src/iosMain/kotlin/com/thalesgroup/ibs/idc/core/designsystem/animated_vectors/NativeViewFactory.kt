package com.thalesgroup.ibs.idc.core.designsystem.animated_vectors

import platform.UIKit.UIViewController

interface NativeViewFactory {
    fun createCheckMarkAnimationView(): UIViewController
}