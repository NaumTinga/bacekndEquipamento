package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BaixaPatrimonioController {

    @Transactional
    def save () {
        def requisicao = request?.JSON
        Date dataBaixa = requisicao.dataBaixa

        if (!dataBaixa) {
            render([status: false, message: 'informe a data de baixa'] as JSON)
            return
        }

        BaixaPatrimonio baixaPatrimonio = new BaixaPatrimonio(dataBaixa: dataBaixa)

        if (baixaPatrimonio.save(flush: true)) {
            render([status: true, message: 'baixaPatrimonio gravado', id: baixaPatrimonio?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar a baixaPatrimonio'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataBaixa = requisicao.dataBaixa
        String id = requisicao.id

        if (!dataBaixa) {
            render([status: false, message: 'informe a data de baixa'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        BaixaPatrimonio baixaPatrimonio = BaixaPatrimonio.findById(Long.parseLong(id))

        if (baixaPatrimonio){

            baixaPatrimonio.dataBaixa = dataBaixa

            if (baixaPatrimonio.save(flush: true)){
                render([status: true, message: 'o modelo foi actualizado', id: baixaPatrimonio?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
                return
            }
        } else {
            render([status:false, message: 'baixaPatrimonio nao encontrado' ] as JSON)
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

        BaixaPatrimonio baixaPatrimonio = BaixaPatrimonio.findById(Long.parseLong(id))

        if(baixaPatrimonio){

            baixaPatrimonio.delete()

            render([status: true, message: 'baixaPatrimonio removido'] as JSON)
            return
        } else {
            render([status: false, message: 'baixaPatrimonio nao encontrado'])
        }
    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def baixaPatrimonio = BaixaPatrimonio.executeQuery("select new map(b.dataBaixa as dataBaixa, b.id as id) from baixaPatrimonio b where b.id = :id", [id: Long.parseLong(id)])
        if (baixaPatrimonio)
            baixaPatrimonio = baixaPatrimonio?.first()

        render(baixaPatrimonio as JSON)
    }

    def list(){
        def baixaPatrimonio = BaixaPatrimonio.executeQuery("select new map(b.dataBaixa as dataBaixa, b.id as id) from baixaPatrimonio b")

        render(baixaPatrimonio as JSON)
    }
}
