rootProject.name = "MafiaMaster"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}


dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":androidApp")
include(":shared:app")
include(":shared:core:data")
include(":shared:core:designsystem")
include(":shared:core:model")
include(":shared:core:resources")
include(":shared:core:utils")
include(":shared:feature:game")
include(":shared:feature:game-setup")
include(":shared:feature:games-archive")
include(":shared:feature:homepage")
include(":shared:feature:players-data")
include(":shared:feature:player-details")
include(":shared:feature:roles-distribution")
include(":shared:feature:rules")
include(":shared:feature:settings")