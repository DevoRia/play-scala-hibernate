package services

import java.util

import entities.{Model, Student}
import javax.inject.Inject
import repositories.StudentRepo

class DataStudentService @Inject()(studentRepo: StudentRepo) extends DataService{

  override def save(model: Model): Unit = studentRepo.save(model)

  override def edit(model: Model): Unit = studentRepo.edit(model)

  override def remove(model: Model): Unit = studentRepo.remove(model)

  override def findAll(): util.List[_] = studentRepo.findAll()

  def findById(id: Int): Student = studentRepo.getById(id).asInstanceOf[Student]
}
