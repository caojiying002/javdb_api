plugins {
    kotlin("jvm") version "2.1.20"
}

group = "com.jiyingcao"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.squareup.okio:okio:3.9.1")
    implementation("com.google.code.gson:gson:2.11.0")  // TODO 改用Moshi

    testImplementation(kotlin("test"))
    // 保持 JUnit4 支持
    testImplementation("junit:junit:4.13.2")
    // 添加 JUnit5 支持
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    // JUnit Vintage 引擎用于在 JUnit5 平台上运行 JUnit4 测试
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.10.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}