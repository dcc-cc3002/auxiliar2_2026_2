package army

import soldier.Soldier

import scala.collection.mutable.ArrayBuffer

/**
 * Represents an army that manages a collection of soldiers.
 *
 * An army has a name and maintains a mutable roster of soldiers that can
 * join or leave at any time.
 *
 * @param name the name of the army.
 * @param soldiers the list of soldiers currently serving in the army
 */
class Army (val name: String, val soldiers: ArrayBuffer[Soldier]) {

  def join(soldier: Soldier): Unit = {
    soldiers += soldier
  }

  def leave(soldier: Soldier): Unit = {
    // Dado que requerimos eliminar un soldado específico de la lista,
    // Primero nos encargamos de buscarlo en esta.
    val index: Int = soldiers.indexOf(soldier)
    if (index >= 0){
      // Si efectivamente, el soldado se encontraba enlistado en el Army,
      // lo removemos de este.
      soldiers.remove(index)
    }

    // soldiers -= soldier, removería la primera ocurrencia de soldier en soldiers.
    // En este caso específico, también funcionaría, puesto que un soldado debería
    // estar enlistado únicamente una vez en el Army.
  }
}
