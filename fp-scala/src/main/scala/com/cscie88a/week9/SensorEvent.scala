package com.cscie88a.week9

final case class SensorEvent(
  eventId: String,
  sensorId: String,
  sensorType: String,
  windDirection: String,
  eventTimestamp: Long,
  zipCode: String,
  humidityPercentage: Float,
  windSpeedInMPH: Long,
  pressureInAtm: Float,
  temperatureInCelcius: Float,
)
