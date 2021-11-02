package example

  
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

object WordCountJob {
  def main(args: Array[String]) {
    
    // get execution environment and read data
    val filePath = "file:////Users/ESumitra/tools/flink-1.14.0/README.txt"
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text = env.readTextFile(filePath)

    // transform data
    val counts = text.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
      .map { (_, 1) }
      .keyBy(_._1)
      .sum(1) // aggregation with sum

    // print or stream to sink
    counts.print()

    env.execute("Stream WordCount")
  }

}


