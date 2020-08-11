name := "api"

version := "0.1"

scalaVersion := "2.13.3"


libraryDependencies ++= Seq("com.lihaoyi" %% "cask" % "0.7.3",
  "com.lihaoyi" %% "utest" % "0.7.4" % Test,
  "com.lihaoyi" %% "requests" % "0.5.1",
  "org.postgresql" % "postgresql" % "42.2.8",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "io.getquill" %% "quill-jdbc" % "3.5.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "com.typesafe" % "config" % "1.4.0")

val stage = taskKey[Unit]("Stage task")

val Stage = config("stage")

stage := {
  (packageWar in Compile).value
  (update in Stage).value.allFiles.foreach { f =>
    if (f.getName.matches("webapp-runner-[0-9\\.]+.jar")) {
      println("copying " + f.getName)
      IO.copyFile(f, baseDirectory.value / "target" / "webapp-runner.jar")
    }
  }
}
