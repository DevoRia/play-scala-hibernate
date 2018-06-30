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

 // @OneToMany(targetEntity = classOf[Student], mappedBy = "gg")
  var students : List[Student] = List()

  def this(name: String) = {
    this()
    this.name = name
  }

  override def toString: String = "{"+
    "\"id\":"+this.id +","+
    "\"name\":\""+ this.name +"\","+
    "}"

}
