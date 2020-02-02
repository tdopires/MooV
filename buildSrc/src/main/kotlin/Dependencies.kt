import org.gradle.api.JavaVersion

private const val kotlinVersion = "1.3.50"

object GradlePlugins {
  object Versions {
    const val gradleandroid = "4.0.0-alpha09"
    const val gradleversions = "0.27.0"
  }

  const val android = "com.android.tools.build:gradle:${Versions.gradleandroid}"
  const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val gradleVersions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleversions}"
}

object BuildPlugins {
  const val androidApplication = "com.android.application"
  const val androidLibrary = "com.android.library"
  const val kotlinAndroid = "kotlin-android"
  const val kotlinKapt = "kotlin-kapt"
  const val kotlin = "kotlin"
}

object AndroidSdk {
  const val minSdk = 21
  const val compileSdk = 29
  const val targetSdk = 29
  val javaVersion = JavaVersion.VERSION_1_8
  const val buildTools = "29.0.0"
}

object Deps {
  object Versions {
    const val androidx_core = "1.2.0-beta02"
    const val androidx_appcompat = "1.0.2"
    const val androidx_viewmodel = "2.1.0-beta01"
    const val androidx_lifecycle = "2.2.0-alpha01"
    const val androidx_recyclerview = "1.1.0-rc01"
    const val androidx_constraintLayout = "2.0.0-beta3"
    const val material = "1.2.0-alpha01"
    const val play_core_ktx = "1.6.4"
    const val coroutines = "1.3.2"
    const val koin = "2.0.1"
    const val dagger = "2.25.2"
    const val retrofit = "2.6.0"
    const val room = "2.0.0"
    const val glide = "4.11.0"
    const val okHttpLoggingInterceptor = "3.14.2"
    const val timber = "4.7.1"

    const val junit = "4.12"
    const val mockk = "1.9.3"
    const val kotest = "3.4.2"
    const val androidx_espresso = "3.2.0"
    const val androidx_testing = "1.1.1"
    const val assertj = "3.12.2"
    const val test_runner = "1.2.0"
    const val mockito_kotlin = "2.1.0"
  }

  const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"

  const val androidxCore = "androidx.core:core-ktx:${Versions.androidx_core}"
  const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidx_appcompat}"
  const val androidxLifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.androidx_lifecycle}"
  const val androidxViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidx_viewmodel}"
  const val androidxConstraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
  const val androidxMaterial = "com.google.android.material:material:${Versions.material}"
  const val androidxRecyclerview = "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerview}"
  const val playCoreKtx = "com.google.android.play:core-ktx:${Versions.play_core_ktx}"
  const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
  const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
  const val koin = "org.koin:koin-core:${Versions.koin}"
  const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
  const val koinAndroidxViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
  const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
  const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
  const val room = "androidx.room:room-runtime:${Versions.room}"
  const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
  const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
  const val gsonRetrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
  const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
  const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
  const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
  const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

  const val junit = "junit:junit:${Versions.junit}"
  const val mockk = "io.mockk:mockk:${Versions.mockk}"
  const val kotest = "io.kotlintest:kotlintest-runner-junit5:${Versions.kotest}"
  const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
  const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin}"
  const val assertj = "org.assertj:assertj-core:${Versions.assertj}"
  const val androidxRules = "androidx.test:rules:${Versions.androidx_testing}"
  const val androidxRunner = "androidx.test:runner:${Versions.androidx_testing}"
  const val androidxEspressocore = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"
}

object Modules {
  const val domain = ":domain"
  const val data = ":data"
  const val presentation = ":presentation"
}