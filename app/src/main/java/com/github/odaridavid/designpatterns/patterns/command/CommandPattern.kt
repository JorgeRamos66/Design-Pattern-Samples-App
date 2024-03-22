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
package com.github.odaridavid.designpatterns.patterns.command

internal interface Command {
    fun execute()
}

internal class RaceOrganizer {
    private val queue = ArrayList<Command>()

    fun register(command: Command) {
        queue.add(command)
    }

    fun execute() {
        for (command in queue) {
            command.execute()
        }
    }

}

internal class RaceCommand(private val event: Event) : Command {
    override fun execute() {
        event.beginRace()
    }
}

internal class DetourCommand(private val event: Event) : Command {
    override fun execute() {
        event.takeDetour()
    }
}

internal class Event {
    fun beginRace() {
        println("Racing Begins")
    }

    fun takeDetour() {
        println("Changing track")
    }
}