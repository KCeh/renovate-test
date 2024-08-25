plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    api(project(":domain:models"))

    implementation(libs.kotlin)

    implementation(libs.coroutines)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}
