import dependencies.Gson
import org.gradle.api.artifacts.dsl.DependencyHandler

object Google {
    private const val materialVersion = "1.4.0"
    const val material = "com.google.android.material:material:$materialVersion"

    const val location = "com.google.android.gms:play-services-location:21.1.0"

    fun DependencyHandler.google(){
        implementation(Google.location)
    }
}