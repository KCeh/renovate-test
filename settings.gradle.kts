pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")
include(":ui")

include(":sources:backend")
include(":sources:backend:data")
include(":sources:backend:bridge")

include(":sources:room")
include(":sources:room:data")
include(":sources:room:bridge")

include(":sources:preferences")
include(":sources:preferences:data")
include(":sources:preferences:bridge")

include(":domain")
include(":domain:models")
include(":domain:logic")

include(":common:kotlin")
include(":common:android")

rootProject.name = "New Project Template"
