plugins {
    kotlin("jvm") version "1.3.72"
}

group = "tk.pshub"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://jitpack.io/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("com.destroystokyo.paper:paper-api:1.15.2-R0.1-SNAPSHOT")
    compile("com.github.noonmaru:tap:2.3.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}