package controllers

import entities.Student
import javax.inject._
import play.api.mvc._
import services.DataStudentService
import play.data.DynamicForm
import play.data.FormFactory

@Singleton
class HomeController @Inject()(formFactory: FormFactory,service: DataStudentService, cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index("1"))
  }

  def findAll(): Result = Ok(service.findAll())

  def add(): Result = {
    service.save(newStudent(formFactory.form().bindFromRequest()))
    Ok()
  }

  def edit(): Result = {
    service.edit(newStudent(formFactory.form().bindFromRequest()))
    Ok()
  }

  def remove(id: String): Result = {
    service.remove(service.findById(Integer.parseInt(id)))
    Ok()
  }

  def newStudent(form: DynamicForm): Student = new Student(form.get("name"), Integer.parseInt(form.get("group")))
}

