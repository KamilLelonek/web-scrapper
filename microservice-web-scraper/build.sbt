name := "web-scraper"

version := "1.0"

organization := "co.growbots"

scalaVersion := "2.10.4"

resolvers ++= Seq(
  "The New Motion Public Repo" at "http://nexus.thenewmotion.com/content/groups/public/",
  "Sonatype Snapshots"         at "http://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  "com.thenewmotion.akka" %% "akka-rabbitmq" % "1.2.3",
  "com.typesafe.akka" % "akka-actor_2.10" % "2.3.7",
  "nl.razko" % "scraper_2.10" % "0.4.1",
  "org.json4s" %% "json4s-jackson" % "3.2.10"
)
