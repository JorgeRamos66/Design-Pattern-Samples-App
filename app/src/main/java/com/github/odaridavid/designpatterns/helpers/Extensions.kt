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

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.PowerManager
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.ISystemThemeChangeListener
import com.github.odaridavid.designpatterns.helpers.SdkUtils.versionUntil
import us.feras.mdv.MarkdownView


internal inline fun <reified T> Activity.navigateTo(noinline intentExtras: ((Intent) -> Unit)? = null) {
    val intent = Intent(this, T::class.java)
    intentExtras?.run {
        intentExtras(intent)
    }
    startActivity(intent)
}

internal fun MarkdownView.loadWithKotlinCss(
    context: Context,
    filePath: String,
    systemThemeChangeListener: ISystemThemeChangeListener<String>
) {
    loadMarkdownFile(
        filePath,
        getThemedCss(context, systemThemeChangeListener)
    )
}

internal fun getThemedCss(
    context: Context,
    systemThemeChangeListener: ISystemThemeChangeListener<String>
): String {
    val sp = PreferenceManager.getDefaultSharedPreferences(context)
    return when (getCurrentTheme(context, sp)) {
        ThemeUtils.THEME_DARK -> DARK_KOTLIN_CSS_PATH
        ThemeUtils.THEME_LIGHT -> LIGHT_KOTLIN_CSS_PATH
        ThemeUtils.THEME_SYSTEM -> {
            if (versionUntil(Build.VERSION_CODES.P)) {
                val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
                systemThemeChangeListener.onPowerSaverModeChange(powerManager)
            } else {
                systemThemeChangeListener.onUiModeConfigChange()
            }
        }
        else -> LIGHT_KOTLIN_CSS_PATH
    }
}

internal fun getCurrentTheme(context: Context, sp: SharedPreferences?): String {
    return sp?.getString(context.getString(R.string.key_theme_preference), ThemeUtils.THEME_LIGHT)
        ?: "default"
}

internal fun String.checkUrlScheme(): String {
    return if (!startsWith("http://") && !startsWith("https://"))
        "http://$this"
    else this
}

internal fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}