package Parametros

class ItemsReparacao {

    Date dataAlocacao
    static  belongsTo = [ItemsReparacao: ItemsReparacao]

    static constraints = {
        dataAlocacao nullable: false, blank: false
    }
}
