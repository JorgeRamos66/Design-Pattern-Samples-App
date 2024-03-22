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
package com.github.odaridavid.designpatterns.patterns.visitor


internal interface Visitor {
    fun visit(hotel: Hotel)
    fun visit(lodging: Lodging)
    fun visit(airBnb: AirBnb)
}

internal interface Accommodation {
    val rating: Int
    fun accept(visitor: Visitor)
}

internal class AccommodationVisitor : Visitor {

    override fun visit(hotel: Hotel) {
        println("Hotel score on visit ${hotel.rating / 10 * 100}")
    }

    override fun visit(lodging: Lodging) {
        println("Lodging score on visit ${lodging.rating / 10 * 100}")
    }

    override fun visit(airBnb: AirBnb) {
        println("AirBnb score on visit ${airBnb.rating / 10 * 100}")
    }

}

internal class Hotel(override val rating: Int) : Accommodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

internal class Lodging(override val rating: Int) : Accommodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

internal class AirBnb(override val rating: Int) : Accommodation {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}