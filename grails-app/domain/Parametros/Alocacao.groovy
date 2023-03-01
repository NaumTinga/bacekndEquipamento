package Parametros

class Alocacao {

    Date dataAlocacao
    Date periodoAlocacao //Anos
    String pathGuiaRecepcao

    static constraints = {
        dataAlocao nullable: false, blank: false
        periodoAlocacao nullable: false, blank: false
        pathGuiaRecepcao nullable: false, blank: false
    }
}
