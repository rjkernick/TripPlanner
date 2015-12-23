import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Settings {
  val organization = "com.tripPlanner"

  val version = "0.1.0"

  object versions {
    val scala = "2.11.7"
    val scalaTest = "2.2.1"
    val akka = "2.4.1"
    val akkaExperimental = "2.0-M2"
    val scalaJs = "0.6.5"
    val slick = "3.1.0"
    val log4js = "1.4.9"
  }


  val jsDependencies = Def.setting(Seq(
    "org.webjars.bower" % "bootstrap" % "3.3.4" / "bootstrap.js" commonJSName "bootstrap" minified "bootstrap.min.js",
    "org.webjars.bower" % "log4javascript" % versions.log4js / "js/log4javascript_uncompressed.js" minified "js/log4javascript.js"
  ))

  val clientDependencies = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "be.doeraene" %%% "scalajs-jquery" % "0.8.1",
    "com.lihaoyi" %%% "scalatags" % "0.5.3",
    "com.github.japgolly.scalacss" %%% "core" % "0.3.1",
    "io.surfkit" %%% "scalajs-google-maps" % "0.1-SNAPSHOT",
    "com.lihaoyi" %%% "utest" % "0.3.1" % "test",
    "org.monifu" %%% "minitest" % "0.14" % "test"
  ))

  val serverDependencies = Def.setting(Seq(
    "com.typesafe.akka" %% "akka-http-core-experimental" % versions.akkaExperimental,
    "com.typesafe.akka" %% "akka-http-xml-experimental" % versions.akkaExperimental,
    "com.typesafe.akka" %% "akka-http-experimental" % versions.akkaExperimental,
    "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
    "com.lihaoyi" %% "scalatags" % "0.5.3",
    "com.github.japgolly.scalacss" %% "core" % "0.3.1",
    "org.webjars" % "webjars-locator" % "0.23",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
    "ch.qos.logback" % "logback-classic" % "1.1.2",
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % versions.akkaExperimental,

    "org.scalatest" %% "scalatest" % versions.scalaTest % "test",
    "com.typesafe.akka" %% "akka-http-testkit-experimental" % versions.akkaExperimental % "test"
  ))

  val domainDependencies = Def.setting(Seq(
    "mysql" % "mysql-connector-java" % "5.1.37",
    "com.typesafe.slick" %% "slick" % versions.slick,
    "com.typesafe.slick" %% "slick-codegen" % versions.slick,
    "com.typesafe.slick" %% "slick-hikaricp" % versions.slick,
    "org.slf4j" % "slf4j-nop" % "1.7.12"
  ))

  val sharedDependencies = Def.setting(Seq(
    "com.github.benhutchison" %%% "prickle" % "1.1.10",
    "org.scala-js" %% "scalajs-stubs" % versions.scalaJs,
    "org.scalatest" %% "scalatest" % versions.scalaTest % "test"
  ))
}