package army

import soldier.Soldier

import scala.collection.mutable.ArrayBuffer

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
