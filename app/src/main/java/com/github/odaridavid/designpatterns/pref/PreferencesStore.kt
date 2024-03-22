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

import android.content.Context
import android.content.SharedPreferences


internal interface IPreferenceStore : IntStore, BooleanStore

internal interface IntStore {

    fun setInt(key: String, value: Int)

    fun getInt(key: String): Int
}

internal interface BooleanStore {

    fun setBoolean(key: String, value: Boolean)

    fun getBoolean(key: String): Boolean
}

internal class PreferencesStore(private val context: Context) : IPreferenceStore {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun setInt(key: String, value: Int) {
        setPreference { putInt(key, value) }
    }

    override fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, DEFAULT_INT_VALUE)
    }

    override fun setBoolean(key: String, value: Boolean) {
        setPreference { putBoolean(key, value) }
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, DEFAULT_BOOLEAN_VALUE)
    }

    private inline fun setPreference(crossinline block: SharedPreferences.Editor.() -> (Unit)) {
        sharedPreferences.edit().apply { block() }.apply()
    }

    companion object {
        private const val PREF_NAME = "design_patterns_pref"
        const val DEFAULT_INT_VALUE = -1
        const val DEFAULT_BOOLEAN_VALUE = false
    }

}