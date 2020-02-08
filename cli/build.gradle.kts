plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "cli.Main"
}

dependencies {
    implementation(project(":core"))
    implementation(kotlin("stdlib"))
    implementation("com.xenomachina:kotlin-argparser:2.0.7")
}
