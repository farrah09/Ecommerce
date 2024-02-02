package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Modules {
    const val app = ":app"

    const val core = ":core"
    const val coreUi = ":core-ui"

}

fun DependencyHandler.core(){
    implementation(project(Modules.core))
}

fun DependencyHandler.coreUi(){
    implementation(project(Modules.coreUi))
}

