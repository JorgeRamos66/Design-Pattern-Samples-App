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
package com.github.odaridavid.designpatterns.patterns.decorator


internal interface Bar {
    fun setup()
}

internal class CollegeBar : Bar {
    override fun setup() {
        println("College Bar Setup")
    }
}

internal class SportsBar : Bar {
    override fun setup() {
        println("Sports Bar Setup")
    }
}

internal abstract class BarDecorator(bar: Bar) : Bar by bar

internal class HalloweenBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Halloween Ornaments")
    }
}

internal class ChristmasBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Christmas Ornaments")
    }
}