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
package com.github.odaridavid.designpatterns.patterns.proxy


internal interface Car {
    fun drive(): String
}

internal class RealCar : Car {
    override fun drive(): String {
        return "Ignition On"
    }
}

internal class ProxyCar(var key: String = "none") : Car {

    private val realCar = RealCar()

    override fun drive(): String {
        return if (key == "none") "No keys available" else realCar.drive()
    }
}