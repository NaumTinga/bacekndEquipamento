package Utilizador

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UtilizadorController {

    @Transactional
    def save () {
        def requisicao = request?.JSON
        String nome = requisicao.nome

        if (!nome) {
            render([status: false, message: 'informe o nome '] as JSON)
            return
        }

        Utilizador utilizador = new Utilizador(nome: nome)

        if (utilizador.save(flush:true)) {
            render([status: true, message: 'Utilizador gravado', id: utilizador?.id] as JSON)
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

        Utilizador utilizador = Utilizador.findById(Long.parseLong(id))

        if (Utilizador) {
            utilizador.nome = nome
            if(utilizador.save(flush:true)) {
                render([status: true, message: 'Utilizador actualizado', id: utilizador?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o Utilizador'] as JSON)
                return
            }
        } else {
            render([status: false, message: ' Utilizador nao encontrado'] as JSON)
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

        Utilizador utilizador = Utilizador.findById(Long.parseLong(id))

        if (Utilizador) {
            Utilizador.delete()
            render([status: true, message: 'Utilizador removido'] as JSON)
            return
        } else {
            render([status: false, message: 'Utilizador nao encontrado'] as JSON)
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


        def utilizador = Utilizador.executeQuery("select new map(u.nome as nome,u.id as id) from Utilizador u where u.id = :id ", [id: Long.parseLong(id)])

        if (utilizador)
            utilizador = utilizador?.first()

        render(utilizador as JSON)
    }

    def list () {
        def utilizador = Utilizador.executeQuery("select new map(u.nome as nome,u.id as id) from Utilizador u")

        render(utilizador as JSON)
    }
}
