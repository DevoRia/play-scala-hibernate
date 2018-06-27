package controllers

import java.util

import entities.Student
import javax.inject._
import play.api.Logger
import play.api.mvc._
import services.DataStudentService
import play.data.DynamicForm
import play.data.FormFactory
import play.api.libs.json._
import play.api.libs.typedmap.TypedKey

import scala.collection.JavaConverters._

@Singleton
class HomeController @Inject()(formFactory: FormFactory,service: DataStudentService, cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  case class Students(id: Int, name: String, group: Int)
  implicit val f = Json.writes[Students]

  def index = Action {
    val a = Seq(Students(1, "vad", 1), Students(2,"TAr",1))
    Ok(Json.toJson(a))
  }

  def findAll = Action {
    val json: util.ArrayList[String] = new util.ArrayList[String]()
    service.findAll().asScala.toList.map(v => json.add(v.toString))

    Ok(json.toString)
  }

  def add  = Action {implicit request =>
    var name: String = ""
    var group: String = ""
    request.body.asMultipartFormData.foreach(e => {
      e.dataParts("name").foreach(name = _)
      e.dataParts("group").foreach(group = _)
    })
     service.save(newStudent(name, group))
    Ok("Success")
  }

  def edit = Action {
    Ok("Success")
  }

  def remove(id: String) = Action {
    service.remove(service.findById(Integer.parseInt(id)))
    Ok("Success")
  }

  def newStudent(name: String, group: String): entities.Student = new entities.Student(name, Integer.parseInt(group))
}

