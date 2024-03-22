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
package com.github.odaridavid.designpatterns.helpers

import android.content.Context
import com.github.odaridavid.designpatterns.pref.PreferenceManager
import com.github.odaridavid.designpatterns.pref.PreferencesStore


internal object InjectorUtils {

    fun providePreferenceManager(context: Context): PreferenceManager {
        val preferencesStore = PreferencesStore(context)
        return PreferenceManager(preferencesStore)
    }

}