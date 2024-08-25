plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = ApplicationSpec.Sdk.target

    defaultConfig {
        minSdk = ApplicationSpec.Sdk.min

        testInstrumentationRunner = ApplicationSpec.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "${ApplicationSpec.appId}.common.android"
}

dependencies {
    implementation(project(":common:kotlin"))
}
