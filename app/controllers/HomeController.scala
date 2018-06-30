package controllers

import java.util

import entities.Group
import javax.inject._
import play.api.mvc._
import services.DataStudentService
import play.data.FormFactory

import scala.collection.JavaConverters._

@Singleton
class HomeController @Inject()(formFactory: FormFactory,service: DataStudentService, cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  def index = Action {
    Ok("try")
  }

  def findAll = Action {
    val json: util.ArrayList[String] = new util.ArrayList[String]()
    service.findAll().asScala.toList.map(v => json.add(v.toString))
    Ok(json.toString)
  }

  def add  = Action {implicit request =>
    val name: String = getDataFromRequest(request, "name")
    val group: String = getDataFromRequest(request, "group")
    service.save(newStudent(name, group))
    Ok("Success")
  }

  def edit = Action {implicit request =>
    val name: String = getDataFromRequest(request, "name")
    val group: String = getDataFromRequest(request, "group")
    val id: String = getDataFromRequest(request, "id")
    val student = newStudent(name, group)
    student.id = Integer.parseInt(id)
    service.edit(student)
    Ok("Success")
  }

  def remove(id: String) = Action {
    service.remove(service.findById(Integer.parseInt(id)))
    Ok("Success")
  }

  def newStudent(name: String, group: String): entities.Student = {
    new entities.Student(name, 1)
  }
  def getDataFromRequest(request: Request[AnyContent], title: String): String = {
    request.body.asMultipartFormData.get.dataParts(title).foreach(return _)
    title
  }
}

