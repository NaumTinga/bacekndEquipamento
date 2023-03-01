package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional

class MarcaController {

    @Transactional
    def save(){

        def requisicao = request?.JSON
        String nome = requisicao.nome


        if (!nome){
            render([status: false, message: 'informe o nome'] as JSON)
            return
        }


        Marca marca = new Marca(nome: nome, dataRegisto: new Date())

        if (marca.save(flush: true)){
            render([e: true, message: 'gravado', id: marca?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar o seu pedido'] as JSON)
            return
        }
    }

    @Transactional
    def update(){

        def requisicao = request?.JSON
        String nome = requisicao.nome
        String id = requisicao.id

        if (!nome){
            render([status: false, message: 'informe o nome'] as JSON)
            return
        }

        if (!id){
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Marca marca = Marca.findById(Long.parseLong(id))

        if (marca){
            marca.nome = nome

            if (marca.save(flush: true)){
                render([status: true, message: 'actualizao', id: marca?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar'] as JSON)
                return
            }

        } else {
            render([status: false, message: 'marca nao encontrada'] as JSON)
            return
        }


    }

    @Transactional
    def delete(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if (!id){
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Marca marca = Marca.findById(Long.parseLong(id))

        if (marca){
            marca.delete()

            render([status: true, message: 'removido'] as JSON)
            return

        } else {
            render([status: false, message: 'marca nao encontrada'] as JSON)
            return
        }

    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if (!id){
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        def marca = Marca.executeQuery("select new map(m.nome as nome, m.dataRegisto as dataRegisto," +
                " m.id as id) from Marca m where m.id = :id ", [id: Long.parseLong(id)])

        if (marca)
            marca = marca?.first()

        render(marca as JSON)

    }

    def list(){
        def marca = Marca.executeQuery("select new map(m.nome as nome, m.dataRegisto " +
                "as dataRegisto, m.id as id) from Marca m ")

        render(marca as JSON)
    }

}
