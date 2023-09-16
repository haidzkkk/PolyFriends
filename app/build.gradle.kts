plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
}

android {
    namespace = "com.fpoly.polyfriends"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fpoly.polyfriends"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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

    buildFeatures.viewBinding = true
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // extention
    implementation("androidx.fragment:fragment-ktx:1.6.1")

    // navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")

    // mvrx
    implementation("com.airbnb.android:mvrx:1.5.1")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    //okhttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.9.1")


    // rxjava rxandroid
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.1")

    // dagger
    implementation("com.google.dagger:dagger:2.48")
    implementation("com.google.dagger:dagger-android-support:2.48")

    kapt("com.google.dagger:dagger-compiler:2.48")?.let { implementation(it) }
//    kapt("com.google.dagger:dagger-android-processor:2.35.1")?.let { implementation(it) }
//    kapt("androidx.room:room-compiler:2.5.1")?.let { implementation(it) }

    // Effects imageview
    implementation("com.airbnb.android:lottie:6.0.1")

    // map
    implementation("com.google.android.gms:play-services-maps:18.1.0")
}
