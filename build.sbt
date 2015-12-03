name := "sangria"
organization := "org.sangria-graphql"
version := "0.5.1-SNAPSHOT"

description := "Scala GraphQL implementation"
homepage := Some(url("http://sangria-graphql.org"))
licenses := Seq("Apache License, ASL Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.11.7"
scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  // macros
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,

  // parsing
  "org.parboiled" %% "parboiled" % "2.1.0",

  // JSON marshalling/unmarshalling. IT IS ONLY TEMPORARY IN THIS PROJECT TODO: extract in different library (see #38)
  "io.spray" %%  "spray-json" % "1.3.2" % "optional",
  "org.json4s" %% "json4s-native" % "3.3.0" % "optional",
  "org.json4s" %% "json4s-jackson" % "3.3.0" % "optional",
  "com.typesafe.play" % "play-json_2.11" % "2.4.2" % "optional",
  "io.circe" %% "circe-core" % "0.1.1" % "optional",
  "io.circe" %% "circe-generic" % "0.1.1" % "optional",
  "io.circe" %% "circe-jawn" % "0.1.1" % "optional",

  // testing
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

git.remoteRepo := "git@github.com:sangria-graphql/sangria.git"

// Publishing

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := (_ => false)
publishTo := Some(
  if (version.value.trim.endsWith("SNAPSHOT"))
    "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")

// Site and docs

site.settings
site.includeScaladoc()
ghpages.settings

// nice *magenta* prompt!

shellPrompt in ThisBuild := { state =>
  scala.Console.MAGENTA + Project.extract(state).currentRef.project + "> " + scala.Console.RESET
}

// Additional meta-info

startYear := Some(2015)
organizationHomepage := Some(url("https://github.com/sangria-graphql"))
developers := Developer("OlegIlyenko", "Oleg Ilyenko", "", url("https://github.com/OlegIlyenko")) :: Nil
scmInfo := Some(ScmInfo(
  browseUrl = url("https://github.com/sangria-graphql/sangria.git"),
  connection = "scm:git:git@github.com:sangria-graphql/sangria.git"
))