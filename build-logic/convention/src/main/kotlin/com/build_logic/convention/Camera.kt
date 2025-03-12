package com.build_logic.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCamera(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        dependencies {
            implementation(libs.findLibrary("androidx-camera-camera2").get())
            implementation(libs.findLibrary("androidx-camera-lifecycle").get())
            implementation(libs.findLibrary("androidx-camera-view").get())
        }
    }
}