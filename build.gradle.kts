plugins {
	java
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.vfedotov"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation(project(mapOf("path" to ":dao")))
	implementation(project(mapOf("path" to ":controllers")))
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	implementation("org.hibernate:hibernate-core:6.4.4.Final")
	implementation("jakarta.persistence:jakarta.persistence-api:3.2.0-M2")
	implementation("org.springframework.data:spring-data-jpa:3.2.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
