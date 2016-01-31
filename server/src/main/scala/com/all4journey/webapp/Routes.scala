package com.all4journey.webapp

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.Materializer
import com.all4journey.webapp.pages._
import com.all4journey.webapp.util.LogAppender
import org.webjars.WebJarAssetLocator
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport._

import scala.util.{Success, Try}

/**
  * Created by rjkj on 12/5/15.
  */
object Routes extends Page {
  val webJarLocator = new WebJarAssetLocator()

  def apply()(implicit system: ActorSystem, mat: Materializer): Route = {
    get {
      pathSingleSlash {
        IndexPage()
        //        getFromResource("web/index-dev.html")
      } ~
        path("client-fastopt.js")(getFromResource("client-fastopt.js")) ~
        path("client-launcher.js")(getFromResource("client-launcher.js")) ~
        path("client-jsdeps.js")(getFromResource("client-jsdeps.js")) ~
        path("assets" / "fonts" / Rest) { fontFile => //bootstrap fonts route
          Try(webJarLocator.getFullPath("bootstrap", s"dist/fonts/$fontFile")) match {
            case Success(path) => getFromResource(path)
            case _ => complete(StatusCodes.NotFound)
          }
        } ~
        path("assets" / Segment / Rest) { (webjar, partialPath) =>
          Try(webJarLocator.getFullPath(webjar, partialPath)) match {
            case Success(path) => getFromResource(path)
            case _ => complete(StatusCodes.NotFound)
          }

        } ~
        path("profile") {
          ProfilePage()
        } ~
        path("login"){
          LoginPage()
        }~
        path("multiformProfile" / "password") {
          PasswordChangFormPage()
        } ~
        path("multiformProfile" / "vehicle") {
          VehicleInfoFormPage()
        } ~
        path("multiformProfile" / "personal") {
          PersonalInfoFormPage()
        }
    } ~
      getFromResource("web") ~
      post {
        path("profile") {
          ProfilePage()
        } ~
          path("log") {
            LogAppender()
          } ~
          path("login") {
            LoginPage()
          }
      }
  }
}
