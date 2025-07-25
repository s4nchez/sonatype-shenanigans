package net.isanchez

import net.isanchez.internal.ModuleLicense.Apache2
import net.isanchez.internal.addLicenseToJars

plugins {
    id("net.isanchez.internal.module")
    id("net.isanchez.internal.publishing")
}

group = "net.isanchez"

addLicenseToJars(Apache2)
