/**
 *
 * Copyright 2020 David Odari
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia"); No puedes utilizar este archivo excepto
 * de conformidad con la Licencia. Puede obtener una copia de la Licencia en
 *            http://www.apache.org/licenses/LICENSE-2.0
 * A menos que lo exija la ley aplicable o se acuerde por escrito, el software distribuido bajo la Licencia
 * se distribuye "TAL CUAL", SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas
 * o implícito. Consulte la Licencia para conocer el idioma específico que rige los permisos y limitaciones en
 * la licencia.
 *
 **/
package com.github.odaridavid.designpatterns.base

import android.os.PowerManager

/**
 * Escuchador de cambios iniciados por el sistema que afectan la forma en que se representará la interfaz de usuario.
 * @param T resultado esperado del cambio iniciado por el sistema
 */
interface ISystemThemeChangeListener<out T> {
    /**
     * Se llama cuando hay un cambio en la configuración de ahorro de energía.
     *
     * @param powerManager una instancia de PowerManager para operaciones relacionadas con el ahorro de energía
     */
    fun onPowerSaverModeChange(powerManager: PowerManager): T

    /**
     * Se llama cuando hay un cambio en el tema iniciado por el sistema.
     * por ejemplo, cambiar el tema de la bandeja de notificaciones en Android Q y superior
     */
    fun onUiModeConfigChange(): T
}