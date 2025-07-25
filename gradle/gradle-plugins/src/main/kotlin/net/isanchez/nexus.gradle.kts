package net.isanchez

import java.time.Duration

plugins {
    id("io.github.gradle-nexus.publish-plugin")
}

version = project.properties["releaseVersion"] ?: "LOCAL"

val nexusUsername: String? by project
val nexusPassword: String? by project

nexusPublishing {
    repositories {
        // see https://central.sonatype.org/publish/publish-portal-ossrh-staging-api/#configuration
        sonatype {
            username.set(nexusUsername)
            password.set(nexusPassword)
            nexusUrl.set(uri("https://ossrh-staging-api.central.sonatype.com/service/local/"))
            snapshotRepositoryUrl.set(uri("https://central.sonatype.com/repository/maven-snapshots/"))
        }
    }
    transitionCheckOptions {
        maxRetries.set(150)
        delayBetween.set(Duration.ofSeconds(5))
    }
}
