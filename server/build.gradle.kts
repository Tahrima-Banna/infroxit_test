plugins {
    kotlin("jvm") version "2.0.21"
    application
}

repositories {
    mavenCentral()
}

tasks.named<JavaExec>("run") {
    mainClass.set("org.example.MainKt")
}
