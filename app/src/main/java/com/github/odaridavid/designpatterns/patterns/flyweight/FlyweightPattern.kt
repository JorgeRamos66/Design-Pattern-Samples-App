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
package com.github.odaridavid.designpatterns.patterns.flyweight

import java.util.*

internal interface GameScene {
    val timeOfDay: TimeOfDay
    fun render()
}

internal enum class TimeOfDay {
    MORNING, AFTERNOON, NIGHT
}

internal class CityScene(override val timeOfDay: TimeOfDay) : GameScene {
    override fun render() {
        println("Entering City")
    }
}

internal class ForestScene(override val timeOfDay: TimeOfDay) : GameScene {
    override fun render() {
        println("Entering Forest")
    }
}

internal object GameSceneFactory {
    private val scenesMap = WeakHashMap<String, GameScene>()

    fun getCityScene(timeOfDay: TimeOfDay): GameScene {
        val key = "CityScene-$timeOfDay"
        return synchronized(this) {
            val scene = scenesMap[key]
            if (scene != null)
                scene
            else {
                val newScene = CityScene(timeOfDay)
                scenesMap[key] = newScene
                newScene
            }
        }
    }

    fun getForestScene(timeOfDay: TimeOfDay): GameScene {
        val key = "ForestScene-$timeOfDay"
        return synchronized(this) {
            val scene = scenesMap[key]
            if (scene != null)
                scene
            else {
                val newScene = ForestScene(timeOfDay)
                scenesMap[key] = newScene
                newScene
            }
        }
    }

    fun getNoOfStoredScenes() = scenesMap.size
}