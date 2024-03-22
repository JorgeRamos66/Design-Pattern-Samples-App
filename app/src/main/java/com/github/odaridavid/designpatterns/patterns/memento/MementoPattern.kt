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
package com.github.odaridavid.designpatterns.patterns.memento


internal data class Memento(val state: String)

internal class Originator(var state: String) {

    fun saveToMemento(): Memento {
        return Memento(state)
    }

    fun restoreFromMemento(memento: Memento) {
        state = memento.state
    }
}

internal class CareTaker {
    private val savedStates = ArrayList<Memento>()

    fun saveState(state: Memento) {
        savedStates.add(state)
    }

    fun restore(index: Int): Memento {
        return savedStates[index]
    }
}