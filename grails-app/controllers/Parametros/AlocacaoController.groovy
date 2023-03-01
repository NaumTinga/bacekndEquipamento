package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional

class AlocacaoController {

    @Transactional
    def save () {

        def requisicao = request?.JSON
        Date dataAlocacao = requisicao.dataAlocao
        Date periodoAlocacao = requisicao.peiodoAlocacao //Anos
        String pathGuiaRecepcao = requisicao.pathGuiaRecepcao

        if (!dataAlocacao) {
            render([status: false, message: 'informe a data alocacao'] as JSON)
            return
        }
        if (!periodoAlocacao) {
            render([status: false, message: 'informe a periodo alocacao'] as JSON)
            return
        }
        if (!pathGuiaRecepcao) {
            render([status: false, message: 'informe a Guia de recepcao'] as JSON)
            return
        }

        Alocacao alocacao = new Alocacao(dataAlocacao: new Date(), periodoAlocacao: periodoAlocacao, pathGuiaRecepcao: pathGuiaRecepcao)

        if (alocacao.save(flush:true)) {
            render([status: true, message: 'alocacao gravada', id: alocacao?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao gravar o seu pedido'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataAlocacao = requisicao.dataAlocao
        Date periodoAlocacao = requisicao.peiodoAlocacao //Anos
        String pathGuiaRecepcao = requisicao.pathGuiaRecepcao
        String id = requisicao.id

        if (!dataAlocacao) {
            render([status: false, message: 'informe a data alocacao'] as JSON)
            return
        }
        if (!periodoAlocacao) {
            render([status: false, message: 'informe a periodo alocacao'] as JSON)
            return
        }
        if (!pathGuiaRecepcao) {
            render([status: false, message: 'informe a Guia de recepcao'] as JSON)
            return
        }
        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Alocacao alocacao = Alocacao.findById(Long.parseLong(id))

        if (alocacao) {
            alocacao.dataAlocacao = dataAlocao
            alocacao.periodoAlocacao = peiodoAlocacao //Anos
            alocacao.pathGuiaRecepcao = pathGuiaRecepcao

            if(alocacao.save(flush:true)) {
                render([status: true, message: 'alocacao actualizada', id: alocacao?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar a alocacao'] as JSON)
                return
            }
        } else {
            render([status: false, message: 'alocacao nao existe'] as JSON)
            return
        }

    }

    @Transactional
    def delete(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Alocacao alocacao = Alocacao.findById(Long.parseLong(id))

        if(alocacao){

            alocacao.delete()

            render([status: true, message: 'alocacao removido'] as JSON)
            return
        } else {
            render([status: false, message: 'alocacao nao encontrado'])
        }
    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def alocacao = Alocacao.executeQuery("select new map(a.dataAlocacao as dataAlocacao, a.periodoAlocacao as periodoAlocacao, a.pathGuiaRecepcao as pathGuiaRecepcao" +
                " a.id as id) from Alocacao a where a.id = :id", [id: Long.parseLong(id)])
        if (alocacao)
            alocacao = alocacao?.first()

        render(alocacao as JSON)
    }

    def list(){
        def alocacao = Alocacao.executeQuery("select new map(a.dataAlocacao as dataAlocacao, a.periodoAlocacao as periodoAlocacao, a.pathGuiaRecepcao as pathGuiaRecepcao\" +\n" +
                "                \" a.id as id) from Alocacao a")

        render(alocacao as JSON)
    }

}
