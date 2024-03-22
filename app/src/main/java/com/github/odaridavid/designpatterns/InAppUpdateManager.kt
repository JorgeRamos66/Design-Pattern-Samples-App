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
package com.github.odaridavid.designpatterns

import android.app.Activity
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability

internal interface UpdateManager {
    fun checkForUpdate(activity: Activity)
}

internal object InAppUpdateManager : UpdateManager {

    const val RQ_REQUEST_UPDATE = 4000

    override fun checkForUpdate(activity: Activity) {
        val appUpdateManager: AppUpdateManager =
            AppUpdateManagerFactory.create(activity.applicationContext)
        val appUpdateInfo = appUpdateManager.appUpdateInfo
        appUpdateInfo?.addOnSuccessListener { info ->
            handleUpdateImmediately(appUpdateManager, info, activity)
        }
    }

    private fun handleUpdateImmediately(
        appUpdateManager: AppUpdateManager,
        appUpdateInfo: AppUpdateInfo,
        activity: Activity
    ) {
        val updateAvailability = appUpdateInfo.updateAvailability()
        if ((updateAvailability == UpdateAvailability.UPDATE_AVAILABLE || updateAvailability == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) &&
            appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
        ) {
            appUpdateManager.startUpdateFlowForResult(
                appUpdateInfo,
                AppUpdateType.IMMEDIATE,
                activity,
                RQ_REQUEST_UPDATE
            )
        }
    }

}