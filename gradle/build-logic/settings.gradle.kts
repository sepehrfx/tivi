// Copyright 2023, Christopher Banes and the Tivi project contributors
// SPDX-License-Identifier: Apache-2.0


dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("../libs.versions.toml"))
        }
    }
}

include(":convention")
