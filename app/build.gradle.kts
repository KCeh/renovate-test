plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ApplicationSpec.Sdk.target
    defaultConfig {
        applicationId = ApplicationSpec.appId
        minSdk = ApplicationSpec.Sdk.min
        targetSdk = ApplicationSpec.Sdk.target
        versionCode = ApplicationSpec.Version.code
        versionName = ApplicationSpec.Version.name
        testInstrumentationRunner = ApplicationSpec.testInstrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = ApplicationSpec.appId
}

dependencies {
    implementation(project(":ui"))

    implementation(project(":common:android"))
    implementation(project(":common:kotlin"))

    implementation(project(":domain:logic"))

    implementation(project(":sources:room:bridge"))
    implementation(project(":sources:backend:bridge"))
    implementation(project(":sources:preferences:bridge"))

    implementation(libs.bundles.dagger)
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.android.processor)

    implementation(libs.timber)

    detektPlugins(libs.detekt.compose)

    testImplementation(libs.test.core)
}
