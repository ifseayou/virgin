package com.isea.learn.virgin

//import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

/**
 * Skeleton for a Flink Streaming Job.
 *
 * For a tutorial how to write a Flink streaming application, check the
 * tutorials and examples on the <a href="http://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
object StreamingJob {
  def main(args: Array[String]) {
    // set up the streaming execution environment
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text: DataStream[WordCount] = env.socketTextStream("hadoop110", 9999, '\n')
      .flatMap(w => w.split("\\s")) // 正则，按照空格，tab，多个空格都可以分隔开来
      .map(w => WordCount(w, 1))
      .keyBy("word")
      .sum(1) // 这里也可以使用.sum("count")，也就是样例类的值
    text.print()
    env.execute("Flink Streaming Scala API Skeleton")
  }

  case class WordCount(word: String, count: Long)
}
