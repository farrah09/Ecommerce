import dependencies.AndroidX
import org.gradle.api.artifacts.dsl.DependencyHandler

object Coil {
    private const val version = "2.5.0"
    const val coilCompose = "io.coil-kt:coil-compose:$version"
}

fun DependencyHandler.coil(){
    implementation(Coil.coilCompose)
}