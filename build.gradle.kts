plugins {
    kotlin("jvm") version "1.7.22"
    application
}

group = "net.mhlavac"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.ajalt.clikt:clikt:3.5.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}

tasks {
    wrapper {
        gradleVersion = "7.6"
        // DistributionUrl = "https://"
        distributionType = Wrapper.DistributionType.BIN
        distributionSha256Sum = "c5a643cf80162e665cc228f7b16f343fef868e47d3a4836f62e18b7e17ac018a"
    }
}
