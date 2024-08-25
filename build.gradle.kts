buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.navigation.safeargs)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.detekt)
}

subprojects {
    apply(plugin = rootProject.libs.plugins.detekt.get().pluginId)
    dependencies {
        detektPlugins(rootProject.libs.detekt.formatting)
    }
    detekt {
        config.setFrom(files("${rootProject.rootDir}/config/detekt.yml"))
        source.setFrom(files("src/main/java", "src/main/kotlin"))
    }
}

val isNonStable: (String) -> Boolean = { version ->
    val stableKeyword = setOf("RELEASE", "FINAL").any { version.uppercase().contains(it) }
    val regex = Regex("^[0-9,.v-]+(-r)?$")
    !stableKeyword && !(version matches regex)
}