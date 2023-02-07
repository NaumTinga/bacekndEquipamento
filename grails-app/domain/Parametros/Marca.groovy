package Parametros

class Marca {

    String nome
    Date dataRegisto

    static constraints = {
        nome nullable: false, blank: false
        dataRegisto nullable: false, blank: false
    }
}
