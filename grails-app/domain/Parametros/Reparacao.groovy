package Parametros

import Utilizador.Utilizador

class Reparacao {

    Date dataEnvioReparacao
    String avaria
    Date dataPrevistaDevolucao
    //Utilizador utilizador
    String tecnicoEmpresaReparacao
    Integer telefoneTecnicoEmpresaReparacao
    String pathGuiaSaida
    Date dataDevolucao
    String tecnicoRecepcaoDevolucao
    String pathGuiaRecepcaoDevolucao

    static  belongsTo = [Empresa: Empresa]
    static constraints = {
         dataEnvioReparacao nullable: false, blank: false
         avaria nullable: false, blank: false
         dataPrevistaDevolucao nullable: false, blank: false
        //utilizador
         tecnicoEmpresaReparacao nullable: false, blank: false
         telefoneTecnicoEmpresaReparacao nullable: false, blank: false
         pathGuiaSaida nullable: false, blank: false
         dataDevolucao nullable: false, blank: false
         tecnicoRecepcaoDevolucao nullable: false, blank: false
         pathGuiaRecepcaoDevolucao nullable: false, blank: false

    }
}
