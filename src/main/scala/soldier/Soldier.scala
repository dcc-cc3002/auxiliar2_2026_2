package soldier

class Soldier (var hp: Int, val name: String, val attack: Int, private var isAlive: Boolean = true){
  // En el constructor, la variable isAlive es private
  // dado que solo se utiliza dentro de la misma clase.
  // Es decir, solo Soldier la modifica.

}
