plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(project(":common:kotlin"))
    implementation(project(":domain:models"))
    implementation(project(":sources:backend:data"))

    implementation(libs.kotlin)

    implementation(libs.coroutines)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}
