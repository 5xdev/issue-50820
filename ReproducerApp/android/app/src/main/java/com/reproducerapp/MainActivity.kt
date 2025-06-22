package com.reproducerapp

import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate

import android.app.PictureInPictureParams
import android.os.Build
import android.util.Rational
import androidx.annotation.RequiresApi

class MainActivity : ReactActivity() {

  override fun onUserLeaveHint() {
      super.onUserLeaveHint()
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
          enterPipMode()
      }
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun enterPipMode() {
      val aspectRatio = Rational(16, 9)
      val pipBuilder = PictureInPictureParams.Builder()
          .setAspectRatio(aspectRatio)
          .build()
      enterPictureInPictureMode(pipBuilder)
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  override fun getMainComponentName(): String = "ReproducerApp"

  /**
   * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
   * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
   */
  override fun createReactActivityDelegate(): ReactActivityDelegate =
      DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)
}
