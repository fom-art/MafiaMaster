plugins {
    alias(libs.plugins.build.logic.library)
    alias(libs.plugins.build.logic.library.compose)
}

android {
    namespace = "com.fomart.mafiamaster.core.designsystem"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.resources)

    implementation(libs.androidx.ui.text.google.fonts)
}
