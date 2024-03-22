/*
*
* Copyright 2020 David Odari
*
* Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia"); No puedes utilizar este archivo excepto
* de conformidad con la Licencia. Puede obtener una copia de la Licencia en
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* A menos que lo exija la ley aplicable o se acuerde por escrito, el software distribuido bajo la Licencia
* se distribuye "TAL CUAL", SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas
* o implícito. Consulte la Licencia para conocer el idioma específico que rige los permisos y limitaciones en
* la licencia.
*
*/
package com.github.odaridavid.designpatterns.pref

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


internal class BooleanPreference(
    private val preferenceStore: IPreferenceStore,
    private val key: String
) : ReadWriteProperty<Any, Boolean> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean {
        return preferenceStore.getBoolean(key)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        preferenceStore.setBoolean(key, value)
    }

}