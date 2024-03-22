/**
  *
  * Copyright 2020 David Odari
  *
  * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia"); No puedes utilizar este archivo excepto
  * de conformidad con la Licencia. Puede obtener una copia de la Licencia en
  * http://www.apache.org/licenses/LICENSE-2.0
  * A menos que lo exija la ley aplicable o se acuerde por escrito, el software distribuido bajo la Licencia
  * se distribuye "TAL CUAL", SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas
  * o implícito. Consulte la Licencia para conocer el idioma específico que rige los permisos y limitaciones en
  * la licencia.
  *
  **/
package com.github.odaridavid.designpatterns.patterns.builder

import androidx.annotation.FloatRange

internal class GameEnvironmentBuilder {

    private var quality = RenderQuality.MEDIUM
    private var frequency = 0.0f
    private var timeOfDay = TimeOfDay.MORNING
    private var scene = Scene.BARRACKS

    fun setRenderQuality(quality: RenderQuality): GameEnvironmentBuilder {
        this.quality = quality
        return this
    }

    fun setRocksFrequency(
        @FloatRange(from = 0.0, to = 1.0) frequency: Float
    ): GameEnvironmentBuilder {
        this.frequency = frequency
        return this
    }

    fun setTimeOfDay(timeOfDay: TimeOfDay): GameEnvironmentBuilder {
        this.timeOfDay = timeOfDay
        return this
    }

    fun setScene(scene: Scene): GameEnvironmentBuilder {
        this.scene = scene
        return this
    }

    fun build(): GameEnvironment {
        return GameEnvironment(quality, frequency, timeOfDay, scene)
    }

}

internal enum class TimeOfDay {
    MORNING, NOON, AFTERNOON, EVENING, NIGHT
}

internal enum class Scene {
    FOREST, CITY, CAVE, BARRACKS, CLUB
}

internal enum class RenderQuality {
    LOW, MEDIUM, MAX, ULTRA
}

internal data class GameEnvironment(
    val quality: RenderQuality,
    val frequencyOfRocks: Float,
    val timeOfDay: TimeOfDay,
    val scene: Scene
)
