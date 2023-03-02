package Parametros

class Aquisicao {


    String descricao
    Date dataAquisicao
    String numeroConcurso
    String pathContracto

    static  belongsTo = [Empresa: Empresa]
    static constraints = {
        descricao nullable: false, blank: false
        dataAquisicao nullable: false, blank: false
        numeroConcurso nullable: false, blank: false
        pathContracto nullable: false, blank: false
    }
}
