plugins {
    alias(libs.plugins.build.logic.library)
}

android {
    namespace = "com.fomart.mafiamaster.core.model"
}

dependencies {
    implementation(projects.core.resources)
    implementation(libs.androidx.core.ktx)
}
