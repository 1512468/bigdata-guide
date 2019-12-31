name := "spark-streaming"

// these settings will be share across subsequent projects
lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.11.12",
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % "2.3.1",
    "org.apache.spark" %% "spark-sql" % "2.3.1",
    "org.apache.spark" %% "spark-streaming" % "2.3.1",
    "org.apache.spark"  %% "spark-streaming-kafka-0-10" % "2.3.1",
    "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.3.1",
    "redis.clients" % "jedis" % "2.3.0" % "compile"
  ),
  resolvers ++= Seq(
    // resolver here
    Resolver.mavenLocal,
    "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"
  )
)

lazy val root = project.in(file(".")).settings(
  assemblyJarName in assembly := s"spark-${version.value}.jar",
  commonSettings
)
libraryDependencies += "org.apache.spark" % "spark-sql-kafka-0-10_2.11" % "2.3.1"
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

assemblyExcludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter {
    _.data.getName == "compile-0.1.0.jar"
  }
}
