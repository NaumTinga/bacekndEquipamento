package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ItemsReparacaoController {

    @Transactional
    def save () {
        def requisicao = request?.JSON
        Date dataReparacao = requisicao.dataReparacao

        if (!dataReparacao) {
            render([status: false, message: 'informe a data de reparacao'] as JSON)
            return
        }

        ItemsReparacao itemsReparacao = new ItemsReparacao(dataReparacao: dataReparacao)

        if (itemsReparacao.save(flush: true)) {
            render([status: true, message: 'itemsReparacao gravado', id: itemsReparacao?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar a itemsReparacao'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataReparacao = requisicao.dataReparacao
        String id = requisicao.id

        if (!dataReparacao) {
            render([status: false, message: 'informe a data de reparacao'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        ItemsReparacao itemsReparacao = ItemsReparacao.findById(Long.parseLong(id))

        if (itemsReparacao){

            itemsReparacao.dataReparacao = dataReparacao

            if (itemsReparacao.save(flush: true)){
                render([status: true, message: 'o modelo foi actualizado', id: itemsReparacao?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
                return
            }
        } else {
            render([status:false, message: 'itemsReparacao nao encontrado' ] as JSON)
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

        ItemsReparacao itemsReparacao = ItemsReparacao.findById(Long.parseLong(id))

        if(itemsReparacao){

            itemsReparacao.delete()

            render([status: true, message: 'itemsReparacao removido'] as JSON)
            return
        } else {
            render([status: false, message: 'itemsReparacao nao encontrado'])
        }
    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def itemsReparacao = ItemsReparacao.executeQuery("select new map(i.dataReparacao as dataReparacao, i.id as id) from ItemsReparacao i where i.id = :id", [id: Long.parseLong(id)])
        if (itemsReparacao)
            itemsReparacao = itemsReparacao?.first()

        render(itemsReparacao as JSON)
    }

    def list(){
        def itemsReparacao = ItemsReparacao.executeQuery("select new map(i.dataReparacao as dataReparacao, i.id as id) from ItemsReparacao i")

        render(itemsReparacao as JSON)
    }
}
