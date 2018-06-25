package services

import entities.Model
import java.util

trait DataService {

  def save(model: Model)
  def edit(model: Model)
  def remove(model: Model)
  def findAll(): util.List[_]

}
