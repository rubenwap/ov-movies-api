scalaVersion := "2.12"
sbtVersion := "1.0"
resolvers += Resolver.sbtPluginRepo("releases")

addSbtPlugin("com.heroku" % "sbt-heroku" % "2.1.4")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.4")
