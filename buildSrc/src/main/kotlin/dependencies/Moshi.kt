import dependencies.DaggerHilt
import org.gradle.api.artifacts.dsl.DependencyHandler

object Moshi {
    private const val version = "1.15.0"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
}

fun DependencyHandler.moshi(){
    kapt(Moshi.moshiCodegen)
}
