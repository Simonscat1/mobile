package com.example.currentweatherdatabinding

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.currentweatherdatabinding.weatherLogic.WeatherData
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class WeatherInfoFullFragmentArgs(
  public val weatherData: WeatherData
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(WeatherData::class.java)) {
      result.putParcelable("weatherData", this.weatherData as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(WeatherData::class.java)) {
      result.putSerializable("weatherData", this.weatherData as Serializable)
    } else {
      throw UnsupportedOperationException(WeatherData::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(WeatherData::class.java)) {
      result.set("weatherData", this.weatherData as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(WeatherData::class.java)) {
      result.set("weatherData", this.weatherData as Serializable)
    } else {
      throw UnsupportedOperationException(WeatherData::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): WeatherInfoFullFragmentArgs {
      bundle.setClassLoader(WeatherInfoFullFragmentArgs::class.java.classLoader)
      val __weatherData : WeatherData?
      if (bundle.containsKey("weatherData")) {
        if (Parcelable::class.java.isAssignableFrom(WeatherData::class.java) ||
            Serializable::class.java.isAssignableFrom(WeatherData::class.java)) {
          __weatherData = bundle.get("weatherData") as WeatherData?
        } else {
          throw UnsupportedOperationException(WeatherData::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__weatherData == null) {
          throw IllegalArgumentException("Argument \"weatherData\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"weatherData\" is missing and does not have an android:defaultValue")
      }
      return WeatherInfoFullFragmentArgs(__weatherData)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        WeatherInfoFullFragmentArgs {
      val __weatherData : WeatherData?
      if (savedStateHandle.contains("weatherData")) {
        if (Parcelable::class.java.isAssignableFrom(WeatherData::class.java) ||
            Serializable::class.java.isAssignableFrom(WeatherData::class.java)) {
          __weatherData = savedStateHandle.get<WeatherData?>("weatherData")
        } else {
          throw UnsupportedOperationException(WeatherData::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__weatherData == null) {
          throw IllegalArgumentException("Argument \"weatherData\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"weatherData\" is missing and does not have an android:defaultValue")
      }
      return WeatherInfoFullFragmentArgs(__weatherData)
    }
  }
}
