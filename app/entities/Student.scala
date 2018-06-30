package entities

import javax.persistence._

@Entity
@Table(name = "student", schema = "library")
class Student extends Model {

  @Id
  @Column(name = "idstudent")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = _

  @Column(name = "name")
  var name: String = _

/*@ManyToOne
  @JoinColumn(name = "idgroups")*/
  @Column(name = "\"group\"")
  var studentGroup: Int = _

  def this(name: String, group: Int) = {
    this()
    this.name = name
    this.studentGroup = group
  }

  override def toString = "{"+
  "\"id\":"+this.id +","+
  "\"name\":\""+ this.name +"\","+
  "\"group\":"+ this.studentGroup +
  "}"
}
