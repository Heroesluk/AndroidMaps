import org.gradle.internal.impldep.org.fusesource.jansi.AnsiRenderer.test

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.android")
    id("app.cash.sqldelight") version "2.0.0"
    id("com.google.devtools.ksp")


}



sqldelight {
    databases {
        create("Database") {
            packageName.set("com.example")
        }
    }
}
android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    val lifecycle_version = "2.6.2"

    implementation("com.google.dagger:hilt-android:2.48.1")
    ksp("com.google.dagger:hilt-compiler:2.49")
    annotationProcessor("com.google.dagger:hilt-compiler:2.49")



    implementation("app.cash.sqldelight:android-driver:2.0.0")
    implementation("com.squareup.sqldelight:coroutines-extensions-jvm:1.5.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    implementation("com.google.guava:guava:27.0.1-android")
    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")




}


