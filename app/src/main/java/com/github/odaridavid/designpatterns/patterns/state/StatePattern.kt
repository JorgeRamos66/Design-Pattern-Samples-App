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
package com.github.odaridavid.designpatterns.patterns.state


internal sealed class DoorState

internal object Open : DoorState()
internal object Closed : DoorState()

internal class Door {
    private var doorState: DoorState = Closed

    fun open() {
        doorState = Open
    }

    fun close() {
        doorState = Closed
    }

    fun enter(): String {
        return when (doorState) {
            is Open -> "Welcome"
            is Closed -> "Can't get in"
        }
    }
}