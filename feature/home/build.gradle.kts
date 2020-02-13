plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.coreAndroid))
    implementation(project(Modules.diBridge))
    implementation(project(Modules.FeatureApis.movies))
    implementation(Deps.androidxAppCompat)
    implementation(Deps.androidxMaterial)
    implementation(Deps.kotlinStdlib)
}
