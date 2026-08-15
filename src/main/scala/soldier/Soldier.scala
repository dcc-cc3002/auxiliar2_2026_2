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
  // En el constructor, la variable isAlive es private
  // dado que solo se utiliza dentro de la misma clase.
  // Es decir, solo Soldier la modifica.

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
    if (newHp <= 0) {
      soldier.hp = 0
      soldier.die()
    } else {
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
    // Este método también es privado, dado que se utiliza
    //  únicamente dentro de la clase Soldier.
    isAlive = false
    this.leaveArmy()
  }
}
