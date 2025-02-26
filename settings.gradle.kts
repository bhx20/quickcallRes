pluginManagement {
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
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://artifactory-external.vkpartner.ru/artifactory/maven") }
    }
}
rootProject.name = "QuickCall-Res"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":commons", ":samples", ":strings")
