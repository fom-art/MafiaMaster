import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.build_logic."

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("applicationCompose") {
            id = "build.logic.application.compose"
            implementationClass = "ApplicationComposePlugin"
        }
        register("application") {
            id = "build.logic.application"
            implementationClass = "ApplicationPlugin"
        }
        register("libraryCompose") {
            id = "build.logic.library.compose"
            implementationClass = "LibraryComposePlugin"
        }
        register("library") {
            id = "build.logic.library"
            implementationClass = "LibraryPlugin"
        }
        register("feature") {
            id = "build.logic.feature"
            implementationClass = "FeaturePlugin"
        }
    }
}