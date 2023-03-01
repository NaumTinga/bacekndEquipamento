package Parametros

class ItemsAlocacao {

    Date dataAlocacao

    static constraints = {

        dataAlocacao nullable: false, blank: false
    }
}
