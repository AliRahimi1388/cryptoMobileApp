pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven ("https://plugins.gradle.org/m2/" )
        maven (  "https://jitpack.io" )
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven ("https://plugins.gradle.org/m2/" )
        maven (  "https://jitpack.io" )
    }
}

rootProject.name = "Crypto App"
include(":app")
 