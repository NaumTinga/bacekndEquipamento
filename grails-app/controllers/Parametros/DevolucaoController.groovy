package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DevolucaoController {


    @Transactional
    def save () {
        def requisicao = request?.JSON
        Date dataDevolucao = requisicao.dataDevolucao
        String tecnicoEntrega = requisicao.tecnicoEntrega
        String pathGuiaDevolucao = requisicao.pathGuiaDevolucao

        if (!dataDevolucao) {
            render([status: false, message: 'informe a data de devolucao'] as JSON)
            return
        }

        if (!tecnicoEntrega) {
            render([status: false, message: 'informe o tecnico de entrega'] as JSON)
            return
        }

        if (!pathGuiaDevolucao) {
            render([status: false, message: 'informe a guia de devolucao'] as JSON)
            return
        }

        Devolucao devolucao = new Devolucao(dataDevolucao: dataDevolucao, tecnicoEntrega: tecnicoEntrega, pathGuiaDevolucao: pathGuiaDevolucao)

        if (devolucao.save(flush: true)) {
            render([status: true, message: 'devolucao grava', id: devolucao?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao gravar'] as JSON)
            return
        }
    }

    @Transactional
    def update () {
        def requisicao = request?.JSON
        Date dataDevolucao = requisicao.dataDevolucao
        String tecnicoEntrega = requisicao.tecnicoEntrega
        String pathGuiaDevolucao = requisicao.pathGuiaDevolucao
        String id = requisicao.id

        if (!dataDevolucao) {
            render([status: false, message: 'informe a data de devolucao'] as JSON)
            return
        }

        if (!tecnicoEntrega) {
            render([status: false, message: 'informe o tecnico de entrega'] as JSON)
            return
        }

        if (!pathGuiaDevolucao) {
            render([status: false, message: 'informe a guia de devolucao'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Devolucao devolucao = Devolucao.findById(Long.parseLong(id))

        if (devolucao) {
            devolucao.dataDevolucao = dataDevolucao
            devolucao.tecnicoEntrega = tecnicoEntrega
            devolucao.pathGuiaDevolucao = pathGuiaDevolucao

            if(devolucao.save(flush: true)) {
                render([status: true, message: 'devolucao actualizada', id: devolucao?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar'] as JSON)
                return
            }
        } else {
            render([status: false, message: 'devolucao nao encontrada'] as JSON)
            return
        }
    }

    @Transactional
    def delete () {
        def requisicao = request?.JSON
        String id = requisicao.id

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Devolucao devolucao = Devolucao.findById(Long.parseLong(id))

        if (devolucao) {
            devolucao.delete()
            render([status: true, message: 'removido'] as JSON)
            return
        } else {
            render([status: false, message: 'devolucao nao encontrada'] as JSON)
            return
        }
    }

    def show () {
        def requisicao = request?.JSON
        String id = requisicao.id

      def  devolucao = Devolucao.executeQuery("select new map(d.dataDevolucao as dataDevolucao, d.tecnicoEntrega as tecnicoEntrega, d.pathGuiaDevolucao as pathGuiaDevolucao," +
                "d.id as id) from Devolucao d where d.id = :id", [id: Long.parseLong(id)])
        if (devolucao)
            devolucao = devolucao?.first()

        render(devolucao as JSON)
    }

    def list () {
        def  devolucao = Devolucao.executeQuery("select new map(d.dataDevolucao as dataDevolucao, d.tecnicoEntrega as tecnicoEntrega, d.pathGuiaDevolucao as pathGuiaDevolucao," +
                "d.id as id) from Devolucao")

        render(devolucao as JSON)
    }
}
