plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

group = "net.isanchez"
version = "0.0.0.0"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

publishing {
    repositories {
        maven {
            name = "localRepo"
            url = file("${rootProject.projectDir}/../../../sonatype-shenanigans/gradle/repo").toURI()
        }
    }
}

dependencies {
    api(Kotlin.gradlePlugin)
    api(gradleApi())
    api("io.github.gradle-nexus:publish-plugin:_")
    api("com.github.jk1:gradle-license-report:_")

    // one of the dependencies below is required to allow the right accessor used by ProjectMetadata.kt to be generated
    api("org.jetbrains.dokka:dokka-base:_")
    api("org.jetbrains.dokka:dokka-gradle-plugin:_")
    api("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:_")

}
