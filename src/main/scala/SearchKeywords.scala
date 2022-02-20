
import org.apache.spark.{SparkContext, sql}
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
object SearchKeywords {
Logger.getRootLogger.setLevel(Level.INFO)

  def main(args:Array[String])={
    val spark:SparkSession = SparkSession.builder().master("local[*]").appName("searchtermsreader").getOrCreate()
    val keyphrases_df = spark. read.json("C:\\Users\\Jaguar\\Downloads\\movies.json")
    keyphrases_df.printSchema()
    keyphrases_df.select("title").show(10)
    keyphrases_df.createOrReplaceTempView("movies")
    spark.sql("select year,count(*) as movie_count from movies group by year order by year desc ").show()
  }
}
