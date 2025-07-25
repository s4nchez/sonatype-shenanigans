package net.isanchez.internal

import gradle.kotlin.dsl.accessors._6f1d895e4ff0feb363bc3049591a0b63.jar
import gradle.kotlin.dsl.accessors._6f1d895e4ff0feb363bc3049591a0b63.main
import gradle.kotlin.dsl.accessors._6f1d895e4ff0feb363bc3049591a0b63.sourceSets
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.named

enum class ModuleLicense(val commonName: String, val url: String, val licenseDir: String) {
    Apache2(
        "Apache-2.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        "."
    ),
    Http4kCommercial(
        "http4k Commercial License",
        "http://http4k.org/commercial-license",
        "./pro"
    )
}

fun Project.addLicenseToJars(license: ModuleLicense) {
    tasks.jar {
        from(rootProject.file(license.licenseDir).absolutePath) {
            include("LICENSE")
        }
    }

    tasks.named<Jar>("sourcesJar") {
        from(sourceSets.main.get().allSource)
        from(rootProject.file(license.licenseDir).absolutePath) {
            include("LICENSE")
        }
        archiveClassifier.set("sources")
    }
}
