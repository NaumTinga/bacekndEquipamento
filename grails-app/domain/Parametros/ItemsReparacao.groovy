package Parametros

class ItemsReparacao {

    Date dataAlocacao

    static constraints = {
        dataAlocacao nullable: false, blank: false
    }
}
