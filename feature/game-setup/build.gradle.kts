plugins {
    alias(libs.plugins.build.logic.feature)
}

android {
    namespace = "com.fomart.mafiamaster.feature.game_setup"
}

dependencies{
    implementation(projects.core.data)
}