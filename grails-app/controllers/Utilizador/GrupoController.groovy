package Utilizador


import grails.converters.JSON
import grails.gorm.transactions.Transactional


class GrupoController {

   @Transactional
    def save () {
       def requisicao = request?.JSON
       String nome = requisicao.nome

       if (!nome) {
           render([status: false, message: 'informe o nome '] as JSON)
           return
       }

       Grupo grupo = new Grupo(nome: nome)

       if (grupo.save(flush:true)) {
           render([status: true, message: 'grupo gravado', id: grupo?.id] as JSON)
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

        Grupo grupo = Grupo.findById(Long.parseLong(id))

        if (grupo) {
            grupo.nome = nome
            if(grupo.save(flush:true)) {
                render([status: true, message: 'Grupo actualizado', id: grupo?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o grupo'] as JSON)
                return
            }
        } else {
            render([status: false, message: ' grupo nao encontrado'] as JSON)
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

        Grupo grupo = Grupo.findById(Long.parseLong(id))

        if (grupo) {
            grupo.delete()
            render([status: true, message: 'grupo removido'] as JSON)
            return
        } else {
            render([status: false, message: 'grupo nao encontrado'] as JSON)
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


        def grupo = Grupo.executeQuery("select new map(g.nome as nome,g.id as id) from Grupo g where g.id = :id ", [id: Long.parseLong(id)])

        if (grupo)
            grupo = grupo?.first()

        render(grupo as JSON)
    }

    def list () {
        def grupo = Grupo.executeQuery("select new map(g.nome as nome,g.id as id) from Grupo g")

        render(grupo as JSON)
    }
}
