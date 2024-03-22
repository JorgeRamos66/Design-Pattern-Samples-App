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
package com.github.odaridavid.designpatterns.patterns.iterator

internal interface Iterator {
    val next: Car?
    fun hasNext(): Boolean
}

internal interface Container {
    fun createIterator(): Iterator
}

internal class Car(val name: String)

internal class CarIterator(private val cars: Array<Car>) : Iterator {

    var index: Int = 0

    override val next: Car?
        get() {
            val car = cars[index]
            index++
            return car
        }

    override fun hasNext(): Boolean = index < cars.size

}

internal class CarCollection : Container {

    override fun createIterator(): Iterator {
        val cars = arrayOf(Car("BMW"), Car("Tesla"), Car("Maserati"))
        return CarIterator(cars)
    }

}

internal class CarShowroom(private val carCollection: CarCollection = CarCollection()) {
    fun showcaseCars() {
        val iterator = carCollection.createIterator()
        while (iterator.hasNext()) {
            println("We have ${iterator.next?.name}")
        }
    }
}