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
package com.github.odaridavid.designpatterns.patterns.composite


internal interface Container {
    fun extractContent()
}

internal class IceCreamContainer : Container {
    override fun extractContent() {
        println("Ice Cream inside")
    }
}

internal class MagarineContainer : Container {
    override fun extractContent() {
        println("Magarine Empty")
    }
}

internal class LargeContainer : Container {
    private var containers = mutableListOf<Container>()

    fun addContainer(container: Container) {
        containers.add(container)
    }

    override fun extractContent() {
        println("Opened Large Container")
        for (container in containers) {
            container.extractContent()
        }
    }

}

