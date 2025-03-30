plugins {
    alias(libs.plugins.build.logic.library)
}

android {
    namespace = "com.fomart.mafiamaster.core.data"
}

dependencies{
    implementation(projects.core.model)
    implementation(libs.kotlinx.coroutines.android)

    //Koin
    api(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.androidx.startup)
    implementation(libs.koin.androidx.workmanager)
    implementation(libs.koin.compose.viewmodel)
}