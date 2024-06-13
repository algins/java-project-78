import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    jacoco
    id("checkstyle")
    id("io.freefair.lombok") version "8.6"
    id("com.github.ben-manes.versions") version "0.50.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "hexlet.code"

version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

tasks.register("install") {
    dependsOn("installDist")
}