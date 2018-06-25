package controllers

import entities.Student
import javax.inject._
import play.api.mvc._
import services.DataStudentService
import play.data.DynamicForm
import play.data.FormFactory
import play.libs.Json
import java.util

import scala.collection.JavaConverters._

@Singleton
class HomeController @Inject()(formFactory: FormFactory,service: DataStudentService, cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {


  def index = Action {
    Ok("some")
  }

  def findAll = Action {
    val students = service.findAll().asScala.toList
    Ok(Json.toJson(students))
  }

  def add  = Action {
    service.save(newStudent(formFactory.form().bindFromRequest()))
    Ok("Success")
  }

  def edit = Action {
    service.edit(newStudent(formFactory.form().bindFromRequest()))
    Ok("Success")
  }

  def remove(id: String): Result = {
    service.remove(service.findById(Integer.parseInt(id)))
    Ok("Success")
  }

  def newStudent(form: DynamicForm): Student = new Student(form.get("name"), Integer.parseInt(form.get("group")))
}

