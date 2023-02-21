package backendequipamento

class Empresa {


    String designacao
    String descricao

    static constraints = {
        designacao nullable: false, blank: false
        descricao nullable: false, blank: false
    }
}
