package entities

import javax.persistence._


@Entity
@Table(name = "groups", schema = "library")
class Group extends Model{

  @Id
  @Column(name = "idsgroups")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = _

  @Column(name = "name")
  var name: String = _

  def this(id: Int, name: String) = {
    this()
    this.id = id
    this.name = name
  }

}
