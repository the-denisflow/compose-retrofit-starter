plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.kotlin_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.kotlin_app"
        minSdk = 35
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.mpandroidchart)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v262)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.javapoet)

    implementation(libs.kotlinx.coroutines.core.v173)
    implementation (libs.androidx.fragment.ktx.v162)

    implementation(platform(libs.androidx.compose.bom.v20250100))

    implementation(libs.activity.compose)
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    implementation(libs.androidx.lifecycle.runtime.compose.v280)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    implementation(libs.coil.compose)

    implementation(libs.okhttp)
    implementation(libs.gson)

    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.androidx.room.runtime.v261)
    kapt(libs.androidx.room.compiler.v261)
    implementation(libs.androidx.room.ktx.v261)
}