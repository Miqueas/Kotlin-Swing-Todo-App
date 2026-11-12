plugins {
    kotlin("jvm") version "2.4.21"
}

group = "io.github.miqueas"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.formdev:flatlaf:3.7.2")
    implementation("com.formdev:flatlaf-extras:3.7.2")
    implementation("com.formdev:flatlaf-fonts-inter:4.1")
}

kotlin {
    jvmToolchain(25)
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "io.github.miqueas.kotlin_swing_todo_app.MainKt"
    }

    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })

    exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
}