plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ApplicationSpec.Sdk.target
    defaultConfig {
        minSdk = ApplicationSpec.Sdk.min
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "${ApplicationSpec.appId}.ui"

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(project(":common:kotlin"))
    implementation(project(":common:android"))

    implementation(project(":domain:logic"))

    implementation(libs.appcompat)
    implementation(libs.bundles.lifecycle)
    implementation(libs.material)

    implementation(libs.coroutines)

    implementation(libs.bundles.dagger)
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.android.processor)

    implementation(libs.bundles.navigation)

    implementation(libs.timber)

    detektPlugins(libs.detekt.compose)

    testImplementation(libs.test.core)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.compose.material3)
}

detekt {
    config.setFrom(files("${rootProject.rootDir}/config/detekt.yml", "${project.projectDir}/config/detekt-compose.yml"))
}
