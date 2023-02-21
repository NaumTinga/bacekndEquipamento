package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional


class TipoEquipamentoController {

    @Transactional
    def save() {

        def requisicao = request?.JSON
        String nome = requisicao.nome

        if (!nome) {
            render([status: false, message: 'informe o nome'] as JSON)
            return
        }

        TipoEquipamento tipoEquipamento = new TipoEquipamento(nome: nome, dataRegisto: new Date())

        if (tipoEquipamento.save(flush: true)) {
            render([status: true, message: 'gravado', id: tipoEquipamento?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreum um erro ao registar o seu pedido'])
            return
        }
    }

    @Transactional
    def update() {

        def requisicao = request?.JSON
        String nome = requisicao.nome
        String id = requisicao.id

        if (!nome) {
            render([status: false, message: 'informe o nome'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        TipoEquipamento tipoEquipamento = TipoEquipamento.findById(Long.parseLong(id))

        if (tipoEquipamento) {
            tipoEquipamento.nome = nome

            if (tipoEquipamento.save(flush: true)) {
                render([status: true, message: 'actualizado', id: tipoEquipamento?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar'])
                return
            }

        } else {
            render([status: false, message: 'Tipo equipamento nao encontrado'] as JSON)
            return
        }
    }

    @Transactional
    def delete() {

        def requisicao = request?.JSON
        String id = requisicao?.id

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        TipoEquipamento tipoEquipamento = TipoEquipamento.findById(Long.parseLong(id))
    }

    def show() {
        def requisicao = request?.JSON
        String id = requisicao.id

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        def tipoEquipamento = TipoEquipamento.executeQuery("select new map(t.nome as nome, t.dataRegisto as dataRegisto," +
                "t.id as id) from TipoEquipamento t where t.id = :id", [id: Long.parseLong(id)])

        if (tipoEquipamento)
            tipoEquipamento = tipoEquipamento?.first()

        render(tipoEquipamento as JSON)
    }

    def list(){
        def tipoEquipamento = TipoEquipamento.executeQuery("select new map(t.nome as nome, t.dataRegisto as dataRegisto," +
                "t.id as id) from TipoEquipamento t")

        render(tipoEquipamento as JSON)
    }






}
