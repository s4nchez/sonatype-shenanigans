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
}
