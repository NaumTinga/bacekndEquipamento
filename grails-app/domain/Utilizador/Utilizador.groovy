package Utilizador

class Utilizador {

    String nome
    Grupo grupo

    static constraints = {
        nome nullable: false, blank: false
        grupo nullable: false, blank: false

    }
}
