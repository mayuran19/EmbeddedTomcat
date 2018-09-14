import org.gradle.jvm.tasks.Jar

val mainClassName = "org.apache.catalina.startup.Tomcat.Main"

buildscript{

}

plugins {
    java
    application
}

group = "com.amlabs.tomcat.embedded"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

tasks.register<Jar>("exeJar"){
    manifest{
        attributes(Pair("Main-Class", "org.apache.catalina.startup.Tomcat.Main"))
    }
    baseName = project.name + "-all"
    from(configurations.compile.map { if(it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)
}

dependencies {
    compile("org.apache.tomcat.embed", "tomcat-embed-jasper", "8.0.47")
    compile("org.springframework", "spring-webmvc", "5.0.9.RELEASE")
}
