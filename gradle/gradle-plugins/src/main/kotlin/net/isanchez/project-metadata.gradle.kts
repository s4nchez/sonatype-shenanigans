package net.isanchez

import net.isanchez.internal.ProjectMetadata

// This is a workaround for the dokka plugin adding dependencies to the project instead of the plugin
repositories {
    gradlePluginPortal()
    mavenCentral()
}

group = "net.isanchez"

apply<ProjectMetadata>()

if(rootProject.tasks.findByName("listProjects") == null) {
    rootProject.tasks.register("listProjects") {
        doLast {
            allprojects
                .filter { it.tasks.findByName("publishToSonatype") != null }
                .map { it.name }
                .forEach(System.err::println)
        }
    }
}

