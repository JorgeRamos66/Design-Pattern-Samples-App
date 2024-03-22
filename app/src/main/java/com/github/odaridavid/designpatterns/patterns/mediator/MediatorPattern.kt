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
package com.github.odaridavid.designpatterns.patterns.mediator

internal class User(val parcelId: Int, val name: String) {
    fun parcelStatus(status: String) {
        println("Update for $name :: Parcel Status : $status")
    }
}

internal class Parcel(private val id: Int, var status: String, private val mediator: ParcelMediator) {
    fun sendParcel() {
        mediator.updateParcelStatus(id, status)
    }
}

internal class ParcelMediator {
    private val observers = ArrayList<User>()

    fun receivers(user: User) {
        observers.add(user)
    }

    fun updateParcelStatus(id: Int, status: String) {
        observers.forEach { user ->
            if (user.parcelId == id) {
                user.parcelStatus(status)
            }
        }
    }
}