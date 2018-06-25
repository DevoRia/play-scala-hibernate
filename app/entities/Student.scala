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

  /*@OneToOne
  @JoinTable(name = "groups")
  @JoinColumn(name = "name")*/
  @Column(name = "\"group\"")
  var group: Int = _

  def this(name: String, group: Int) = {
    this()
    this.name = name
    this.group = group
  }
}
