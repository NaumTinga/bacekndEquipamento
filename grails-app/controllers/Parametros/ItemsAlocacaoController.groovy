package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ItemsAlocacaoController {

   @Transactional
    def save () {
       def requisicao = request?.JSON
       Date dataAlocacao = requisicao.dataAlocacao

       if (!dataAlocacao) {
           render([status: false, message: 'informe a data de alocacao'] as JSON)
           return
       }

       ItemsAlocacao itemsAlocacao = new ItemsAlocacao(dataAlocacao: dataAlocacao)

       if (itemsAlocacao.save(flush: true)) {
           render([status: true, message: 'itemsAlocacao gravado', id: itemsAlocacao?.id] as JSON)
           return
       } else {
           render([status: false, message: 'ocorreu um erro ao registar a itemsAlocacao'] as JSON)
           return
       }
   }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataAlocacao = requisicao.dataAlocacao
        String id = requisicao.id

        if (!dataAlocacao) {
            render([status: false, message: 'informe a data de alocacao'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        ItemsAlocacao itemsAlocacao = ItemsAlocacao.findById(Long.parseLong(id))

        if (itemsAlocacao){

            itemsAlocacao.dataAlocacao = dataAlocacao

            if (itemsAlocacao.save(flush: true)){
                render([status: true, message: 'o modelo foi actualizado', id: itemsAlocacao?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
                return
            }
        } else {
            render([status:false, message: 'itemsAlocacao nao encontrado' ] as JSON)
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

        ItemsAlocacao itemsAlocacao = ItemsAlocacao.findById(Long.parseLong(id))

        if(itemsAlocacao){

            itemsAlocacao.delete()

            render([status: true, message: 'itemsAlocacao removido'] as JSON)
            return
        } else {
            render([status: false, message: 'itemsAlocacao nao encontrado'])
        }
    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def itemsAlocacao = ItemsAlocacao.executeQuery("select new map(i.dataAlocacao as dataAlocacao, i.id as id) from ItemsAlocacao i where i.id = :id", [id: Long.parseLong(id)])
        if (itemsAlocacao)
            itemsAlocacao = itemsAlocacao?.first()

        render(itemsAlocacao as JSON)
    }

    def list(){
        def itemsAlocacao = ItemsAlocacao.executeQuery("select new map(i.dataAlocacao as dataAlocacao, i.id as id) from ItemsAlocacao i")

        render(itemsAlocacao as JSON)
    }

}
