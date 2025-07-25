rootProject.name = "sonatype-shenanigans"

dependencyResolutionManagement {
    // Use Maven Central as the default repository (where Gradle will download dependencies) in all subprojects.
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

pluginManagement {
    includeBuild("gradle/gradle-plugins")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("de.fayard.refreshVersions") version "0.60.5"
}

include(":sonatype-shenanigans-1")
include(":sonatype-shenanigans-2")

