package Parametros

import Enumerations.EstadoEquipamentoEnum

class Modelo {

    String nome
    Date dataRegisto

    static belongsTo = [marca: Marca]

    static constraints = {
        nome nullable: false, blank: false
        dataRegisto nullable: false, blank: false
        marca nullable: false, blank: false
    }
}
