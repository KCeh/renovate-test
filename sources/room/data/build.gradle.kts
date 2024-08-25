plugins {
    id("com.android.library")
    id("com.google.devtools.ksp")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = ApplicationSpec.Sdk.target

    defaultConfig {
        minSdk = ApplicationSpec.Sdk.min

        testInstrumentationRunner = ApplicationSpec.testInstrumentationRunner
    }

    sourceSets {
        getByName("androidTest") {
            assets.srcDirs(file("schemas"))
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "${ApplicationSpec.appId}.room.data"

    ksp {
        arg(RoomSchemaArgProvider(file("schemas")))
    }
}

dependencies {
    implementation(libs.kotlin)

    implementation(libs.coroutines)

    implementation(libs.bundles.dagger)
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.android.processor)

    implementation(libs.bundles.room)
    ksp(libs.room.compiler)

    implementation(libs.timber)

    testImplementation(libs.test.room)
}

class RoomSchemaArgProvider(
    @get:InputDirectory @get:PathSensitive(PathSensitivity.RELATIVE) var schemaDir: File
) : CommandLineArgumentProvider {

    override fun asArguments(): Iterable<String> = listOf(
        "room.schemaLocation=" + schemaDir.path
    ).asIterable()
}
