package Utilizador

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UnidadeController {

    @Transactional
    def save () {
        def requisicao = request?.JSON
        String nome = requisicao.nome

        if (!nome) {
            render([status: false, message: 'informe o nome '] as JSON)
            return
        }

        Unidade unidade = new Unidade(nome: nome)

        if (unidade.save(flush:true)) {
            render([status: true, message: 'unidade gravado', id: unidade?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar o seu pedido'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        String nome = requisicao.nome
        String id = requisicao.id

        if (!nome) {
            render([status: false, message: 'informe o nome '] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id '] as JSON)
            return
        }

        Unidade unidade = Unidade.findById(Long.parseLong(id))

        if (unidade) {
            unidade.nome = nome
            if(unidade.save(flush:true)) {
                render([status: true, message: 'unidade actualizado', id: unidade?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o unidade'] as JSON)
                return
            }
        } else {
            render([status: false, message: ' unidade nao encontrado'] as JSON)
            return
        }
    }

    @Transactional
    def delete () {
        def requisicao = request?.JSON
        String id = requisicao.id

        if (!id) {
            render([status: false, message: 'informe o id '] as JSON)
            return
        }

        Unidade unidade = Unidade.findById(Long.parseLong(id))

        if (unidade) {
            unidade.delete()
            render([status: true, message: 'unidade removido'] as JSON)
            return
        } else {
            render([status: false, message: 'unidade nao encontrado'] as JSON)
            return
        }

    }

    def show () {
        def requisicao = request?.JSON
        String id = requisicao.id

        if (!id) {
            render([status: false, message: 'informe o id '] as JSON)
            return
        }


        def unidade = Unidade.executeQuery("select new map(u.nome as nome,u.id as id) from Unidade u where u.id = :id ", [id: Long.parseLong(id)])

        if (unidade)
            unidade = unidade?.first()

        render(unidade as JSON)
    }

    def list () {
        def unidade = Unidade.executeQuery("select new map(u.nome as nome,u.id as id) from Unidade u")

        render(unidade as JSON)
    }
}
