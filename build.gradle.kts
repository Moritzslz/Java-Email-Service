
plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter
    implementation("org.springframework.boot:spring-boot-starter:3.3.0")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mail
    implementation("org.springframework.boot:spring-boot-starter-mail:3.3.0")



}

tasks.test {
    useJUnitPlatform()
}