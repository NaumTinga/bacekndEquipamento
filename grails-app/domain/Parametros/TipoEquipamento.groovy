package Parametros

class TipoEquipamento {

    String nome
    Date dataRegisto

    static belongsTo = [equipamento: Equipamento]

    static constraints = {
        nome nullable: false, blank: false
        dataRegisto nullable: false, blank: false
   }
}
