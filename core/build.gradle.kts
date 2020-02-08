plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(group = "com.kennycason",name = "kumo-core", version = "1.22")
//    implementation("com.github.kittinunf.fuel:fuel:2.2.1")
//    implementation("com.github.kittinunf.fuel:coroutines:2.2.1")
//    implementation("com.github.kittinunf.fuel:kotlinx-serialization:2.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    implementation("com.vk.api:sdk:1.0.6")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
