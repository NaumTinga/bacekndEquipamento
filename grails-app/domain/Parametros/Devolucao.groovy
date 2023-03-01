package Parametros

class Devolucao {

    Date dataDevolucao
    String tecnicoEntrega
    String pathGuiaDevolucao

    static constraints = {
        dataDevolucao nullable: false, blank: false
        tecnicoEntrega nullable: false, blank: false
        pathGuiaDevolucao nullable: false, blank: false
    }
}
