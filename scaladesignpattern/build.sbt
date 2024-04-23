name := "scaladesignpattern"

version := "0.1"

scalaVersion := "2.12.17"

lazy val akkaVersion = "2.8.2"
lazy val akkaHttpVersion = "10.2.10"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies ++= Seq(
//  "org.scalatest" %% "scalatest" % "3.0.1" % Test,
//  "com.github.scopt" %% "scopt" % "4.1.0"

"org.scalatest" %% "scalatest" % "3.0.2" ,
"org.apache.spark" %% "spark-core" % "3.3.1",
"org.apache.spark" %% "spark-sql" % "3.3.1",
"org.apache.spark" %% "spark-mllib" % "3.3.1",
"org.apache.spark" %% "spark-hive" % "3.3.1",
"com.typesafe" % "config" % "1.4.2",
"com.github.pureconfig" %% "pureconfig" % "0.17.2",
"org.apache.hudi" %% "hudi-spark3.3-bundle" % "0.13.0",
"org.apache.spark" %% "spark-streaming-kafka-0-10" % "3.3.1",
"org.apache.kafka" % "kafka-clients" % "2.8.1",
"org.apache.spark" %% "spark-streaming" % "3.3.0" % "provided",
"org.apache.spark" %% "spark-sql-kafka-0-10" % "3.3.0",
"com.amazonaws" % "aws-java-sdk-bundle" % "1.11.1026",
"org.apache.hadoop" % "hadoop-aws" % "3.3.1",
"com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
"com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
"com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
"com.typesafe.akka" %% "akka-http-xml" % akkaHttpVersion,
"com.typesafe.akka" %% "akka-actor" % akkaVersion,
"com.typesafe.akka" %% "akka-stream" % akkaVersion,
"com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion,
"com.typesafe.akka" %% "akka-testkit" % akkaVersion,
"com.typesafe.akka" %% "akka-stream-kafka" % "4.0.2",
"com.lightbend.akka" %% "akka-stream-alpakka-s3" % "3.0.2",
"com.typesafe.akka" %% "akka-persistence" % akkaVersion,
"com.github.scopt" %% "scopt" % "4.1.0"

)