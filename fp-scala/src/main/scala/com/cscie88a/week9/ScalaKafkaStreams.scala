package com.cscie88a.week9
import java.util.Properties
import java.util.concurrent.TimeUnit

import org.apache.kafka.streams.kstream.Materialized
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.scala._
import org.apache.kafka.streams.scala.kstream._
import org.apache.kafka.streams.{ KafkaStreams, StreamsConfig }
import com.typesafe.scalalogging.{ LazyLogging }
import com.goyeau.kafka.streams.circe.CirceSerdes._
import io.circe.generic.auto._
import com.cscie88a.config.{ ConfigUtils }
import pureconfig.generic.auto._

case class SensorConfig(
    appId: String,
    serverUrl: String,
    eventTopic: String,
    countTopic: String
  )

object ScalaKafkaStreams extends LazyLogging {
  import Serdes._

  /** reads the config file  and calls function to start the streams */
  def main(args: Array[String]) = {
    val configPath = "com.cscie88a.sensor-streaming-app"
    val countConf = ConfigUtils.loadAppConfig[SensorConfig](configPath)

    logger.info("starting streaming application ...")
    logger.info(s"using configuration: $countConf")

    runStream(countConf)

    logger.info("stopping streaming application ...")
  }

  /**
   * Creates a stream processing topology and starts the Kafka Streams application.
   *
   * @param config the application configuration
   */
  def runStream(conf: SensorConfig): Unit = {
    val props: Properties = {
      val p = new Properties()
      p.put(StreamsConfig.APPLICATION_ID_CONFIG, conf.appId)
      p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, conf.serverUrl)
      p
    }
    val builder: StreamsBuilder = new StreamsBuilder
    val sensorStream: KStream[String, SensorEvent] =
      builder.stream[String, SensorEvent](conf.eventTopic)
    val sensorCounts: KTable[String, Long] =
      sensorStream.groupBy((_, event) => event.sensorType).count()
    sensorCounts
      .toStream
      .mapValues((key, count) => s"$key: $count")
      .to(conf.countTopic)

    val streams: KafkaStreams = new KafkaStreams(builder.build(), props)
    streams.start()
    sys.ShutdownHookThread {
      streams.close(10, TimeUnit.SECONDS)
    }
  }

}
