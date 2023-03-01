package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ItemsDevolucaoController {

    @Transactional
    def save () {
        def requisicao = request?.JSON
        Date dataDevolucao = requisicao.dataDevolucao

        if (!dataDevolucao) {
            render([status: false, message: 'informe a data de alocacao'] as JSON)
            return
        }

        ItemsDevolucao itemsDevolucao = new ItemsDevolucao(dataDevolucao: dataDevolucao)

        if (itemsDevolucao.save(flush: true)) {
            render([status: true, message: 'itemsDevolucao gravado', id: itemsDevolucao?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar a itemsDevolucao'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataDevolucao = requisicao.dataDevolucao
        String id = requisicao.id

        if (!dataDevolucao) {
            render([status: false, message: 'informe a data de alocacao'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        ItemsDevolucao itemsDevolucao = ItemsDevolucao.findById(Long.parseLong(id))

        if (itemsDevolucao){

            itemsDevolucao.dataDevolucao = dataDevolucao

            if (itemsDevolucao.save(flush: true)){
                render([status: true, message: 'o modelo foi actualizado', id: itemsDevolucao?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
                return
            }
        } else {
            render([status:false, message: 'itemsDevolucao nao encontrado' ] as JSON)
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

        ItemsDevolucao itemsDevolucao = ItemsDevolucao.findById(Long.parseLong(id))

        if(itemsDevolucao){

            itemsDevolucao.delete()

            render([status: true, message: 'itemsDevolucao removido'] as JSON)
            return
        } else {
            render([status: false, message: 'itemsDevolucao nao encontrado'])
        }
    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def itemsDevolucao = ItemsDevolucao.executeQuery("select new map(i.dataDevolucao as dataDevolucao, i.id as id) from itemsDevolucao i where i.id = :id", [id: Long.parseLong(id)])
        if (itemsDevolucao)
            itemsDevolucao = itemsDevolucao?.first()

        render(itemsDevolucao as JSON)
    }

    def list(){
        def itemsDevolucao = ItemsDevolucao.executeQuery("select new map(i.dataDevolucao as dataDevolucao, i.id as id) from itemsDevolucao i")

        render(itemsDevolucao as JSON)
    }

}
