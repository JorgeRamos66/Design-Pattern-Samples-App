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
package com.github.odaridavid.designpatterns.patterns.adapter

internal interface LaptopCable {
    fun onConnectedToPowerPort()
}

internal interface PowerBrick {
    fun onConnectedToSocket()
}

internal class HpPowerBrick : PowerBrick {
    override fun onConnectedToSocket() {
        println("PowerBrick Receiving Power Supply")
    }
}

internal open class StockCable : LaptopCable {
    override fun onConnectedToPowerPort() {
        println("Cable Connected To Laptop")
    }
}

internal class StockCableAdapter(private val hpPowerBrick: HpPowerBrick) : StockCable() {
    override fun onConnectedToPowerPort() {
        super.onConnectedToPowerPort()
        hpPowerBrick.onConnectedToSocket()
        println("AC/DC Conversion happening")
    }
}