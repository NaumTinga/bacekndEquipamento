package Parametros

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DevolucaoController {

    DevolucaoService devolucaoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond devolucaoService.list(params), model:[devolucaoCount: devolucaoService.count()]
    }

    def show(Long id) {
        respond devolucaoService.get(id)
    }

    def save(Devolucao devolucao) {
        if (devolucao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            devolucaoService.save(devolucao)
        } catch (ValidationException e) {
            respond devolucao.errors, view:'create'
            return
        }

        respond devolucao, [status: CREATED, view:"show"]
    }

    def update(Devolucao devolucao) {
        if (devolucao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            devolucaoService.save(devolucao)
        } catch (ValidationException e) {
            respond devolucao.errors, view:'edit'
            return
        }

        respond devolucao, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        devolucaoService.delete(id)

        render status: NO_CONTENT
    }
}
