// Comment to get more information during initialization
logLevel := Level.Warn

// Resolvers
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

//resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

//addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.7.0-SNAPSHOT")

// Sbt plugins
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.3")

addSbtPlugin("com.vmunier" % "sbt-play-scalajs" % "0.2.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.0")

