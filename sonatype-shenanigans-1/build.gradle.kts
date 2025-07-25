import net.isanchez.internal.ModuleLicense.Apache2

description = "shenanigans for publishing to Sonatype OSSRH - part 1"

val license by project.extra { Apache2 }

plugins {
    id("net.isanchez.community")
}