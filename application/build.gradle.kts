plugins {
    application
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
}

application {
    mainClass.set("com.fiap.burger.application.boot.BurgerApplication")
    applicationDefaultJvmArgs = listOf(
        "-Duser.timezone=America/Sao_Paulo"
    )
}

dependencies {
    implementation(project(":entity"))
    implementation(project(":usecase"))
    implementation(project(":controller"))
    implementation(project(":api"))
    implementation(project(":gateway"))
}