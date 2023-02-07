package Parametros

class Equipamento {

    String numeroSerie
    Date dataRegisto

    static constraints = {
        numeroSerie nullable: false, blank: false
        dataRegisto nullable: false, blank: false
    }
}
