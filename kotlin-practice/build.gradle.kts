import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.4.20"
}

group = "ru.sgu.practice"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    testImplementation(kotlin("test"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

// Служебное: -PsolutionsDir=<путь> подменяет src/main на эталонные решения (для проверки самих тестов)
val solutionsDir = providers.gradleProperty("solutionsDir").orNull
if (solutionsDir != null) {
    sourceSets.main {
        kotlin.setSrcDirs(listOf("$solutionsDir/kotlin"))
        java.setSrcDirs(listOf("$solutionsDir/java"))
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed", "skipped")
        showStandardStreams = false
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
    }
    // Не падать на первом красном дне — показать всё
    ignoreFailures = true
}
