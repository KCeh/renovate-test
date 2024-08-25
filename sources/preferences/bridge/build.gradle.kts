plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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

    namespace = "${ApplicationSpec.appId}.preferences.bridge"
}

dependencies {
    implementation(project(":domain:models"))
    implementation(project(":sources:preferences:data"))

    implementation(libs.kotlin)

    implementation(libs.coroutines)

    implementation(libs.bundles.dagger)
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.android.processor)
}
