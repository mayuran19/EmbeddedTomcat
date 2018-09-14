import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.jvm.tasks.Jar

buildscript{
    val shadowPluginVer = "2.0.4"
    dependencies{
        classpath("com.github.jengelman.gradle.plugins:shadow:$shadowPluginVer")
    }
}

plugins {
    java
    application
    id("org.jetbrains.kotlin.jvm") version "1.2.21"
    id("com.github.johnrengelman.shadow") version "2.0.4"
}

group = "com.amlabs.tomcat.embedded"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Jar>{
    manifest {
        attributes(mapOf(
                "Main-Class" to "com.amlabs.tomcat.embedded.Main"
        ))
    }
}

repositories {
    mavenCentral()
}

tasks.withType<ShadowJar> {
    manifest {
        attributes(mapOf(
                "Main-Class" to "com.amlabs.tomcat.embedded.Main"
        ))
    }
    mergeServiceFiles()
}

dependencies {
    compile("org.apache.tomcat.embed", "tomcat-embed-jasper", "8.0.47")
    compile("org.springframework", "spring-webmvc", "5.0.9.RELEASE")
}
