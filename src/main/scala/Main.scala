import army.Army
import soldier.Soldier

import scala.collection.mutable.ArrayBuffer

object Main {   // para ejecutar este archivo haga click izquierdo en el icono del botón verde
  def main(args: Array[String]): Unit = {
    println("--- Simulador breve de reclutamiento y combate ---")

    val north = new Army("Ejército del Norte", ArrayBuffer[Soldier]())
    val south = new Army("Ejército del Sur", ArrayBuffer[Soldier]())

    val elena = new Soldier(hp = 20, name = "Elena", attack = 5)
    val marco = new Soldier(name = "Marco", hp = 16, attack = 7)
    val nora = new Soldier(name = "Nora", hp = 14, attack = 4)

    println(s"Escenario inicial: ${north.name} y ${south.name} todavía no tienen tropas.")
    north.showRoster()
    south.showRoster()

    println("\n[Instructor] Elena se presenta con hp=" + elena.hp + " y ataque=" + elena.attack + ".")
    println("[Instructor] Marco llega luego con hp=" + marco.hp + " y ataque=" + marco.attack + ".")
    println("[Instructor] Nora escucha desde el otro lado con hp=" + nora.hp + " y ataque=" + nora.attack + ".")

    println("\n[Elena] Me uno al Norte.")
    elena.joinArmy(north)
    println("[Marco] Yo también al Norte para aprender." )
    marco.joinArmy(north)
    println("[Nora] Prefiero el Sur, me gusta su estrategia.")
    nora.joinArmy(south)

    north.showRoster()
    south.showRoster()

    println("\n[Instructor] Nora prueba su ataque contra Elena.")
    nora.attackSoldier(elena)
    println(s"Elena queda con ${elena.hp} hp y sigue en ${elena.army.name}.")

    println("\n[Marco] Responde con su ataque a Nora.")
    marco.attackSoldier(nora)
    println(s"Nora queda con ${nora.hp} hp en ${nora.army.name}.")

    println("\n[Marco] Un golpe más para cerrar el ejercicio.")
    marco.attackSoldier(nora)
    println(s"Nora termina con ${nora.hp} hp y abandona el grupo automáticamente si llegó a 0 o menos.")

    south.showRoster()

    println("\n[Elena] Pide traslado al Sur para apoyar.")
    elena.leaveArmy()
    elena.joinArmy(south)
    println(s"Ahora ${elena.name} reporta con hp=${elena.hp} en ${elena.army.name}.")

    north.showRoster()
    south.showRoster()

    println("\n[Instructor] Fin de la práctica: se usaron uniones, salidas y ataques, y se revisaron nombres, hp y ataque.")
  }
}