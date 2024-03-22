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
package com.github.odaridavid.designpatterns.patterns.factory


internal sealed class Chair(val capacity: Int)

internal class Sofa(capacity: Int) : Chair(capacity)

internal class ParkBench(capacity: Int) : Chair(capacity)

internal object ChairFactory {
    @JvmStatic
    inline fun <reified T> getChair(): Chair {
        return when (T::class) {
            Sofa::class -> Sofa(5)
            ParkBench::class -> ParkBench(3)
            else -> throw IllegalArgumentException("Unknown type of chair")
        }
    }
}

