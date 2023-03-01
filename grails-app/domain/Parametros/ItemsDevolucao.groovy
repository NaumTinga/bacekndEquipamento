package Parametros

class ItemsDevolucao {

    Date dataDevolucao

    static constraints = {
        dataDevolucao nullable: false, blank: false
    }
}
