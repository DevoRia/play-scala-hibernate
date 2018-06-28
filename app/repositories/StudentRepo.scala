package repositories

import entities.{Model, Student}
import play.db.jpa.JPAApi
import javax.inject.Inject
import java.util

class StudentRepo @Inject()(jpa: JPAApi) extends Repository {

  override def findAll(): util.List[_] = jpa.withTransaction(_.createQuery("SELECT s FROM Student s").getResultList)

  override def save(model: Model): Unit = jpa.withTransaction(_.persist(model))

  override def edit(model: Model): Unit = jpa.withTransaction(em => em.merge(model))

  override def remove(id: Int): Unit = jpa.withTransaction(em => em.remove(em.merge(getById(id))))

  def remove (model: Model): Unit = jpa.withTransaction(em => em.remove(em.merge(model)))

  override def getById(id: Int): Any = jpa.withTransaction(_.createQuery("SELECT s FROM Student s WHERE idstudent = :id").setParameter("id", id).getResultList.get(0))

}
