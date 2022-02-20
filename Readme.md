### Spark Installation in IntelliJ

* Download Intellij Idea Community IDE
* Go to `Settings > Plugins` Search for Scala and Install
* Install `sbt` plugin as well. Restart the IDE to take effect
* Install Java 8/11 for compatibility with Spark 3.2.1
* Scala version 2.13.1 is compatible with Spark 3.2.1
* To download the correct dependencies utlize the `build.sbt` config file

* Include the following script to mention spark dependencies 

```
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.1"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.2.1"
// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.1" % "provided"
// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.2.1" % "provided"
// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "3.2.1" % "provided"


lazy val root = (project in file("."))
  .settings(
    name := "SparkTumuluri"
  )


```

### Execution

* Create Scala objects under `scr/main/scala` folder
* Execution from Intellij would the following setting in Edit debugging configuration

`Add dependecied with "provided" scope to classpath`

* Right click on object and click `Run <object>`

Happy Coding!!!