package net.isanchez.internal

plugins {
    kotlin("jvm")
    id("net.isanchez.conventions")
}

tasks.register("dependencyList") {
    doLast {
        configurations.runtimeClasspath.get().resolvedConfiguration.lenientConfiguration.allModuleDependencies.forEach { resolved ->
            println("${project.name} -> ${resolved.module.id}")
        }
    }
}
