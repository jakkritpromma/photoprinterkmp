plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
        }
    }
}

android {
    namespace = "com.example.photoprinterkmp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
