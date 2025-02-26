plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlinAndroid)
    `maven-publish`
}

android {
    namespace = "com.quickcall.strings"
    compileSdk = libs.versions.app.build.compileSDKVersion.get().toInt()
}

publishing.publications {
    create<MavenPublication>("release") {
        afterEvaluate {
            from(components["release"])
        }
    }
}
