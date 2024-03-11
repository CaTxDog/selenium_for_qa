plugins {
    id("java")
}

group = "ru.stqa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")

    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")

}

tasks.test {
   useJUnitPlatform()
}