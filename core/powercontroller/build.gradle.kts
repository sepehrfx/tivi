// Copyright 2023, Google LLC, Christopher Banes and the Tivi project contributors
// SPDX-License-Identifier: Apache-2.0


plugins {
    id("app.tivi.android.library")
    id("app.tivi.kotlin.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.core.base)
            }
        }

        val androidMain by getting {
            dependencies {
                api(projects.core.preferences)
                implementation(libs.androidx.core)

                implementation(libs.kotlininject.runtime)
            }
        }
    }
}

android {
    namespace = "app.tivi.core.powercontroller"
}
