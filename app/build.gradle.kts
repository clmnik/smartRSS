plugins {
    alias(libs.plugins.android.application)       // <-- nutzt "com.android.application" aus libs.versions.toml
    alias(libs.plugins.kotlin.android)            // <-- nutzt "org.jetbrains.kotlin.android"
    // alias(libs.plugins.kotlin.compose)         // NUR falls du wirklich ein extra Compose-Plugin brauchst,
    // ansonsten reicht "kotlin.android".
    // Falls du ROOM-Annotation-Processor brauchst:
    // id("kotlin-kapt")
}

android {
    namespace = "com.example.smartrss"        // Passe an, wenn du willst
    compileSdk = 34                           // Stelle sicher, dass du das SDK 34 in Android Studio installiert hast

    defaultConfig {
        applicationId = "com.example.smartrss"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // Falls du Room nutzt und KAPT brauchst:
        // javaCompileOptions {
        //     annotationProcessorOptions {
        //         arguments["room.schemaLocation"] = "$projectDir/schemas"
        //     }
        // }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        // Hier muss die Kotlin-Compiler-Extension-Version zur Compose-Version passen (siehe libs.versions.toml).
        kotlinCompilerExtensionVersion = "1.5.0"   // oder die Compose-Compiler-Version, die zu deinem Compose passt
    }

    buildTypes {
        release {
            // Obfuscation, minifyEnabled etc., erstmal egal:
            isMinifyEnabled = false
            // proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            // debug stuff
        }
    }
}

dependencies {
    // ============= JETPACK COMPOSE =============
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)

    // ============= NAVIGATION (optional, falls du Compose Navigation brauchst) =============
    // Wenn du Compose Navigation verwendest, kannst du das auch so definieren:
    // implementation("androidx.navigation:navigation-compose:2.6.0")

    // ============= RETROFIT (Networking) =============
    implementation(libs.retrofit)
    implementation(libs.converter.gson)  // damit Retrofit JSON via Gson parsen kann

    // ============= OKHTTP (Low-level HTTP client) =============
    implementation(libs.okhttp)

    // ============= COIL (Bilder laden in Compose) =============
    implementation(libs.coil.compose)

    // ============= ROME (RSS-Parsing) =============
    implementation(libs.rome)

    // ============= ROOM (Optional, falls später benötigt) =============
    // implementation(libs.room.runtime)
    // kapt(libs.room.compiler)
    // implementation(libs.room.ktx)

    // ============= KOTLIN COROUTINES =============
    implementation(libs.coroutines.android)
}

