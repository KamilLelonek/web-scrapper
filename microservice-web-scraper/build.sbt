name := "web-scraper"

version := "1.0"

organization := "co.growbots"

scalaVersion := "2.11.4"

resolvers += "The New Motion Public Repo" at "http://nexus.thenewmotion.com/content/groups/public/"

libraryDependencies ++= Seq(
  "com.thenewmotion.akka" %% "akka-rabbitmq" % "1.2.3",
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.7"
)
