package Parametros

class ItemsReparacao {

    Date dataAlocacao
    static  belongsTo = [itemsReparacao: ItemsReparacao]

    static constraints = {
        dataAlocacao nullable: false, blank: false
    }
}
