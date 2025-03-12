pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "MafiaMaster"

include(":app")
include(":core:designsystem")
include(":core:model")
include(":core:resources")
include(":data:players")
include(":feature:game")
include(":feature:game-setup")
include(":feature:games-archive")
include(":feature:players-data")
include(":feature:player-details")
include(":feature:roles-distribution")
include(":feature:rules")
include(":feature:settings")