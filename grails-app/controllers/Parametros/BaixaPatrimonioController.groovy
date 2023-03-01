package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BaixaPatrimonioController {

    @Transactional
    def save () {
        def requisicao = request?.JSON
        Date dataBaixaPatrimonio = requisicao.dataBaixaPatrimonio

        if (!dataBaixaPatrimonio) {
            render([status: false, message: 'informe a data de reparacao'] as JSON)
            return
        }

        ItemsBaixaPatrimonio itemsBaixaPatrimonio = new ItemsBaixaPatrimonio(dataBaixaPatrimonio: dataBaixaPatrimonio)

        if (itemsBaixaPatrimonio.save(flush: true)) {
            render([status: true, message: 'itemsBaixaPatrimonio gravado', id: itemsBaixaPatrimonio?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar a itemsBaixaPatrimonio'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataBaixaPatrimonio = requisicao.dataBaixaPatrimonio
        String id = requisicao.id

        if (!dataBaixaPatrimonio) {
            render([status: false, message: 'informe a data de reparacao'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        ItemsBaixaPatrimonio itemsBaixaPatrimonio = ItemsBaixaPatrimonio.findById(Long.parseLong(id))

        if (itemsBaixaPatrimonio){

            itemsBaixaPatrimonio.dataBaixaPatrimonio = dataBaixaPatrimonio

            if (itemsBaixaPatrimonio.save(flush: true)){
                render([status: true, message: 'o modelo foi actualizado', id: itemsBaixaPatrimonio?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
                return
            }
        } else {
            render([status:false, message: 'itemsBaixaPatrimonio nao encontrado' ] as JSON)
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

        ItemsBaixaPatrimonio itemsBaixaPatrimonio = ItemsBaixaPatrimonio.findById(Long.parseLong(id))

        if(itemsBaixaPatrimonio){

            itemsBaixaPatrimonio.delete()

            render([status: true, message: 'itemsBaixaPatrimonio removido'] as JSON)
            return
        } else {
            render([status: false, message: 'itemsBaixaPatrimonio nao encontrado'])
        }
    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def itemsBaixaPatrimonio = ItemsBaixaPatrimonio.executeQuery("select new map(i.dataBaixaPatrimonio as dataBaixaPatrimonio, i.id as id) from itemsBaixaPatrimonio i where i.id = :id", [id: Long.parseLong(id)])
        if (itemsBaixaPatrimonio)
            itemsBaixaPatrimonio = itemsBaixaPatrimonio?.first()

        render(itemsBaixaPatrimonio as JSON)
    }

    def list(){
        def itemsBaixaPatrimonio = ItemsBaixaPatrimonio.executeQuery("select new map(i.dataBaixaPatrimonio as dataBaixaPatrimonio, i.id as id) from itemsBaixaPatrimonio i")

        render(itemsBaixaPatrimonio as JSON)
    }
}
