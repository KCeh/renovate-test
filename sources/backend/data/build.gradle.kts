plugins {
    kotlin("jvm")
    kotlin("kapt")
    alias(libs.plugins.jetbrains.serialization)
}

dependencies {
    implementation(project(":common:kotlin"))

    implementation(libs.retromock)

    implementation(libs.kotlin)

    implementation(libs.coroutines)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    api(libs.retrofit)
    implementation(libs.bundles.okhttp)
}
