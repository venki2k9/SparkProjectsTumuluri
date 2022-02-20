
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession


object SparkObject {

  def main(args:Array[String])={
    val sc = new SparkContext("local[*]" , "SparkDemo")
    val lines = sc.textFile("C:\\Users\\Jaguar\\Downloads\\sparkwordcount.txt")
    val words = lines.flatMap(line => line.split(' '))
    val wordcounts = words.map(word => (word,1))
    val count = wordcounts.reduceByKey((x,y) => x + y).map(x => (x._2,x._1)).sortByKey(false).map(x => (x._2, x._1)).take(10)
    count.foreach(println)
  }

}
