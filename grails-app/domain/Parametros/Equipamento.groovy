package Parametros

class Equipamento {

    String numeroSerie
    Date dataRegisto
    static  belongsTo = [aquisicao: Aquisicao]

    static constraints = {
        numeroSerie nullable: false, blank: false
        dataRegisto nullable: false, blank: false
    }
}
