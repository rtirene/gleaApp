plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.glea"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(Dependencies.KOTLIN_STDLIB_JDK7)
    implementation(Dependencies.ANDROIDX_APPCOMPAT)
    implementation(Dependencies.ANDROIDX_CORE_KTX)
    implementation(Dependencies.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(Dependencies.VIEW_MODEL)
    implementation(Dependencies.ANDROIDX_LIFECYCLE)
    implementation(Dependencies.RECYCLERVIEW)
    implementation(Dependencies.CARDVIEW)
    implementation(Dependencies.DRAWER_LAYOUT)

    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)

    //retrofit
    implementation(Dependencies.RETROFIT)

    //moshi
    implementation(Dependencies.MOSHI)
    kapt(Dependencies.MOSHI_CODEGEN)
    implementation(Dependencies.RETROFIT_CONVERTER_MOSHI)


    //Coroutine
    implementation(Dependencies.KOTLINX_COROUTINES)
    implementation(Dependencies.ANDROIDX_LIFECYCLE_EXTENSIONS)

    //paging
    implementation(Dependencies.PAGING)

    //room
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KOTLIN_EXTENSION)
    kapt(Dependencies.ROOM_COMPILER)

    //material
    implementation(Dependencies.ANDROID_MATERIAL)

    // Koin for Android
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.KOIN_ANDROIDX_SCOPE)
    implementation(Dependencies.KOIN_ANDROIDX_VIEWMODEL)


}
