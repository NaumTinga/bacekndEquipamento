package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReparacaoController {




    @Transactional
    def save () {
        def requisicao = request?.JSON
        Date dataEnvioReparacao = requisicao.dataEnvioReparacao
        String avaria = requisicao.avaria
        Date dataPrevistaDevolucao = requisicao.dataPrevistaDevolucao
        //Utilizador utilizador = requisicao.utilizador
        String tecnicoEmpresaReparacao = requisicao.tecnicoEmpresaReparacao
        Integer telefoneTecnicoEmpresaReparacao = requisicao.telefoneTecnicoEmpresaReparacao
        String pathGuiaSaida = requisicao.pathGuiaSaida
        Date dataDevolucao = requisicao.dataDevolucao
        String tecnicoRecepcaoDevolucao = requisicao.tecnicoRecepcaoDevolucao
        String pathGuiaRecepcaoDevolucao = requisicao.pathGuiaRecepcaoDevolucao

        if (!dataEnvioReparacao) {
            render([status: false, message: 'informe a data de envio'] as JSON)
            return
        }

        if (!avaria) {
            render([status: false, message: 'informe a avaria'] as JSON)
            return
        }

        if (!dataPrevistaDevolucao) {
            render([status: false, message: 'informe a data prevista para devolucao'] as JSON)
            return
        }
        if (!tecnicoEmpresaReparacao) {
            render([status: false, message: 'informe o tecnixo reparacao'] as JSON)
            return
        }
        if (!telefoneTecnicoEmpresaReparacao) {
            render([status: false, message: 'informe o telefone'] as JSON)
            return
        }
        if (!pathGuiaSaida) {
            render([status: false, message: 'informe a guia de saida'] as JSON)
            return
        }
        if (!dataDevolucao) {
            render([status: false, message: 'informe a data de devolucao'] as JSON)
            return
        }
        if (!tecnicoRecepcaoDevolucao) {
            render([status: false, message: 'informe o tecnico recepcao '] as JSON)
            return
        }
        if (!pathGuiaRecepcaoDevolucao) {
            render([status: false, message: 'informe a guia de recepcao'] as JSON)
            return
        }

        Reparacao reparacao = new Reparacao(dataEnvioReparacao: dataEnvioReparacao, avaria: avaria, dataPrevistaDevolucao: dataPrevistaDevolucao,
                    tecnicoEmpresaReparacao: tecnicoEmpresaReparacao, telefoneTecnicoEmpresaReparacao: telefoneTecnicoEmpresaReparacao,
                    pathGuiaSaida: pathGuiaSaida, dataDevolucao: dataDevolucao, tecnicoRecepcaoDevolucao: tecnicoRecepcaoDevolucao, pathGuiaRecepcaoDevolucao: pathGuiaRecepcaoDevolucao)

        if (reparacao.save(flush: true)) {
            render([status: true, message: 'reparacao grava', id: reparacao?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao gravar'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataEnvioReparacao = requisicao.dataEnvioReparacao
        String avaria = requisicao.avaria
        Date dataPrevistaDevolucao = requisicao.dataPrevistaDevolucao
        //Utilizador utilizador = requisicao.utilizador
        String tecnicoEmpresaReparacao = requisicao.tecnicoEmpresaReparacao
        Integer telefoneTecnicoEmpresaReparacao = requisicao.telefoneTecnicoEmpresaReparacao
        String pathGuiaSaida = requisicao.pathGuiaSaida
        Date dataDevolucao = requisicao.dataDevolucao
        String tecnicoRecepcaoDevolucao = requisicao.tecnicoRecepcaoDevolucao
        String pathGuiaRecepcaoDevolucao = requisicao.pathGuiaRecepcaoDevolucao
        String id = requisicao.id

        if (!dataEnvioReparacao) {
            render([status: false, message: 'informe a data de envio'] as JSON)
            return
        }

        if (!avaria) {
            render([status: false, message: 'informe a avaria'] as JSON)
            return
        }

        if (!dataPrevistaDevolucao) {
            render([status: false, message: 'informe a data prevista para devolucao'] as JSON)
            return
        }
        if (!tecnicoEmpresaReparacao) {
            render([status: false, message: 'informe o tecnixo reparacao'] as JSON)
            return
        }
        if (!telefoneTecnicoEmpresaReparacao) {
            render([status: false, message: 'informe o telefone'] as JSON)
            return
        }
        if (!pathGuiaSaida) {
            render([status: false, message: 'informe a guia de saida'] as JSON)
            return
        }
        if (!dataDevolucao) {
            render([status: false, message: 'informe a data de devolucao'] as JSON)
            return
        }
        if (!tecnicoRecepcaoDevolucao) {
            render([status: false, message: 'informe o tecnico recepcao '] as JSON)
            return
        }
        if (!pathGuiaRecepcaoDevolucao) {
            render([status: false, message: 'informe a guia de recepcao'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Reparacao reparacao = Reparacao.findById(Long.parseLong(id))

        if (reparacao) {
            reparacao.dataEnvioReparacao = dataEnvioReparacao
            reparacao.avaria = avaria
            reparacao.dataPrevistaDevolucao = dataPrevistaDevolucao
            // reparacao.utilizador = utilizador
            reparacao.tecnicoEmpresaReparacao = tecnicoEmpresaReparacao
            reparacao.telefoneTecnicoEmpresaReparacao = telefoneTecnicoEmpresaReparacao
            reparacao.pathGuiaSaida = pathGuiaSaida
            reparacao.dataDevolucao = dataDevolucao
            reparacao.tecnicoRecepcaoDevolucao = tecnicoRecepcaoDevolucao
            reparacao.pathGuiaRecepcaoDevolucao = pathGuiaRecepcaoDevolucao
            reparacao.id = id

            if(reparacao.save(flush: true)) {
                render([status: true, message: 'reparacao actualizada', id: reparacao?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar'] as JSON)
                return
            }
        } else {
            render([status: false, message: 'reparacao nao encontrada'] as JSON)
            return
        }
    }

    @Transactional
    def delete () {
        def requisicao = request?.JSON
        String id = requisicao.id

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Reparacao reparacao = Reparacao.findById(Long.parseLong(id))

        if (reparacao) {
            reparacao.delete()
            render([status: true, message: 'removido'] as JSON)
            return
        } else {
            render([status: false, message: 'reparacao nao encontrada'] as JSON)
            return
        }
    }

    def show () {
        def requisicao = request?.JSON
        String id = requisicao.id

        def  reparacao = Reparacao.executeQuery("select new map(r.dataEnvioReparacao as dataEnvioReparacao, r.avaria as avaria, r.dataPrevistaDevolucao as dataPrevistaDevolucao," +
                "r.tecnicoEmpresaReparacao as tecnicoEmpresaReparacao, r.telefoneTecnicoEmpresaReparacao as telefoneTecnicoEmpresaReparacao," +
                "r.pathGuiaSaida as pathGuiaSaida, r.dataDevolucao as dataDevolucao, r.tecnicoRecepcaoDevolucao as tecnicoRecepcaoDevolucao, r.pathGuiaRecepcaoDevolucao as pathGuiaRecepcaoDevolucao" +
                "d.id as id) from reparacao r where r.id = :id", [id: Long.parseLong(id)])
        if (reparacao)
            reparacao = reparacao?.first()

        render(reparacao as JSON)
    }

    def list () {
        def  reparacao = Reparacao.executeQuery("select new map(r.dataEnvioReparacao as dataEnvioReparacao, r.avaria as avaria, r.dataPrevistaDevolucao as dataPrevistaDevolucao," +
                "r.tecnicoEmpresaReparacao as tecnicoEmpresaReparacao, r.telefoneTecnicoEmpresaReparacao as telefoneTecnicoEmpresaReparacao," +
                "r.pathGuiaSaida as pathGuiaSaida, r.dataDevolucao as dataDevolucao, r.tecnicoRecepcaoDevolucao as tecnicoRecepcaoDevolucao, r.pathGuiaRecepcaoDevolucao as pathGuiaRecepcaoDevolucao" +
                " d.id as id) from reparacao r")

        render(reparacao as JSON)
    }
}
