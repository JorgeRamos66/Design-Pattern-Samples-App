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
package com.github.odaridavid.designpatterns.patterns.abstractfactory

internal interface Truck {
    val color: String
    fun noOfWheels(): Int
}

internal class Isuzu(override val color: String) :
    Truck {
    override fun noOfWheels(): Int = 18
}

internal class Benz(override val color: String) :
    Truck {
    override fun noOfWheels(): Int = 22
}


internal abstract class CarFactory {
    abstract fun getTruck(): Truck

    companion object {
        @JvmStatic
        inline fun <reified T> createTruckFactory(): CarFactory {
            return when (T::class) {
                JapanTruckFactory::class -> JapanTruckFactory()
                GermanTruckFactory::class -> GermanTruckFactory()
                else -> throw IllegalStateException("Unidentified truck factory")
            }
        }
    }
}

internal class JapanTruckFactory : CarFactory() {
    override fun getTruck(): Truck = Isuzu(color = "White")
}

internal class GermanTruckFactory : CarFactory() {
    override fun getTruck(): Truck = Benz(color = "Black")
}

