package com.example.currentweatherdatabinding

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.currentweatherdatabinding.weatherLogic.WeatherData
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToWeatherFullInfoFragment(
    public val weatherData: WeatherData
  ) : NavDirections {
    public override val actionId: Int = R.id.action_HomeFragment_to_WeatherFullInfoFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionHomeFragmentToWeatherFullInfoFragment(weatherData: WeatherData): NavDirections
        = ActionHomeFragmentToWeatherFullInfoFragment(weatherData)
  }
}
