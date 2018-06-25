package repositories

import entities.Model
import java.util

trait Repository {

  def findAll(): util.List[_]
  def save(model: Model)
  def edit(model: Model)
  def remove(id: Int)
  def getById (id: Int): Any

}
