package soldier

import army.Army


/**
 * Represents a soldier that can belong to an army and engage in combat.
 *
 * A soldier has health points that decrease when attacked. When hp drops
 * to 0 or below, the soldier dies and automatically leaves their army.
 * A soldier can belong to at most one army at a time.
 *
 * @param hp        the health points of the soldier
 * @param name      the name of the soldier
 * @param attack    the damage inflicted on another soldier per attack
 * @param isAlive     the value that indicates whether a soldier is alive or dead
 */
class Soldier (var hp: Int, val name: String, val attack: Int, private var isAlive: Boolean = true){
  // En el constructor, la variable isAlive es private (privada) dado que representa el estado interno de Soldier.
  // No es necesario (ni queremos) que otras clases puedan consultar o modificar su valor directamente.
  //
  // En este caso, se modifica únicamente dentro del método die(), correspondiente a un método interno de la clase Soldier.

  var army: Army = null

  /**
   * Attacks another soldier, reducing their hp by this soldier's attack value.
   *
   * If the target's hp drops to 0 or below, the target dies and leaves their army.
   *
   * @param soldier the target soldier to attack.
   */
  def attackSoldier(soldier: Soldier): Unit = {
    val newHp: Int = soldier.hp - attack
    // Revisamos si el daño causado deja la vida del soldado en 0 o menor valor.
    if (newHp <= 0) {
      // Si es así, entonces la dejamos efectivamente en 0 (para que no sea un valor negativo)
      // Y luego invocamos el método asociado a la muerte del soldado.
      soldier.hp = 0
      soldier.die()
    } else {
      // Si el valor no mata al soldado, simplemente le causa el daño.
      soldier.hp = newHp
    }
  }

  /**
   * Joins the given army.
   *
   * If the soldier already belongs to an army, they leave it first
   * before joining the new one.
   *
   * @param newArmy the army to join.
   */
  def joinArmy(newArmy: Army): Unit = {
    if (army != null) {
      this.leaveArmy()
      // this se utiliza para que el método sea invocado sobre la instancia actual de la clase.
      // Entonces, si un soldado (la instancia generada de: new Soldier(...)) decide entrar a un nuevo army,
      // primero tiene que él mismo (this) abandonar el army en el que se encuentra.
    }
    newArmy.join(this)
    army = newArmy
  }

  /**
   * Leaves the current army.
   *
   * If the soldier does not belong to any army, this method does nothing.
   */
  def leaveArmy(): Unit = {
    if (this.army != null) {
      army.leave(this)
      army = null
    }
  }

  /**
   * Marks this soldier as dead.
   *
   * Then leaves the army
   */
  private def die(): Unit = {
    // die() es private porque es una operación interna de Soldier.
    // En este caso, no queremos que código externo pueda hacer que un Soldier muera
    // directamente; este método solo debe ser utilizado por la lógica
    // interna de la clase, por ejemplo desde attackSoldier().
    isAlive = false
    this.leaveArmy()
  }
}
