package Parametros

class Equipamento {

    String numeroSerie
    Date dataRegisto
    static  belongsTo = [Aquisicao: Aquisicao]

    static constraints = {
        numeroSerie nullable: false, blank: false
        dataRegisto nullable: false, blank: false
    }
}
