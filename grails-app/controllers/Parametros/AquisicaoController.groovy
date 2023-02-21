package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AquisicaoController {

    @Transactional
    def save() {

        def requisicao = request?.JSON
        String descricao = requisicao.descricao
        String dataAquisicao = requisicao.dataAquisicao
        String numeroConcurso = requisicao.numeroConcurso
        String pathContracto = requisicao.pathContracto

        if (!descricao) {

            render([status: false, message: 'informe a descricao'] as JSON)
            return
        }

        if (!dataAquisicao) {

            render([status: false, message: 'informe a data de aquisicao'] as JSON)
            return
        }

        if (!numeroConcurso) {

            render([status: false, message: 'informe o numero do concurso'] as JSON)
            return
        }

        if (!pathContracto) {

            render([status: false, message: 'informe o path contracto'] as JSON)
            return
        }

        Aquisicao aquisicao = new Aquisicao(descricao: descricao, dataAquisicao: new Date(), numeroConcurso: numeroConcurso, pathContracto: pathContracto)

        if (aquisicao.save(flush: true)) {
            render([status: true, message: 'Aquisicao gravado', id: aquisicao?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar a aquisicao'] as JSON)
            return
        }
    }

    @Transactional
    def update(){

        def requisicao = request?.JSON
        String descricao = requisicao.descricao
        String dataAquisicao = requisicao.dataAquisicao
        String numeroConcurso = requisicao.numeroConcurso
        String pathContracto = requisicao.pathContracto
        String id = requisicao.id

        if (!descricao) {

            render([status: false, message: 'informe a descricao'] as JSON)
            return
        }

        if (!dataAquisicao) {

            render([status: false, message: 'informe a data de aquisicao'] as JSON)
            return
        }

        if (!numeroConcurso) {

            render([status: false, message: 'informe o numero do concurso'] as JSON)
            return
        }

        if (!pathContracto) {

            render([status: false, message: 'informe o path contracto'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o ID'])
        }

        Aquisicao aquisicao = Aquisicao.findById(Long.parseLong(id))

        if (aquisicao){

            aquisicao.descricao = descricao

            if (aquisicao.save(flush: true)){
                render([status: true, message: 'o modelo foi actualizado', id: aquisicao?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
                return
            }
        } else {
            render([status:false, message: 'aquisicao nao encontrado' ] as JSON)
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

        Aquisicao aquisicao = Aquisicao.findById(Long.parseLong(id))

        if(aquisicao){

            aquisicao.delete()

            render([status: true, message: 'aquisicao removido'] as JSON)
            return
        } else {
            render([status: false, message: 'aquisicao nao encontrado'])
        }
    }

    def show(){

        def requisicao = request?.JSON
        String id = requisicao.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def aquisicao = Aquisicao.executeQuery("select new map(a.descricao as descricao, a.dataAquisicao as dataAquisicao, a.numeroConcurso as numeroConcurso" +
                "a.pathContracto as pathContracto, a.id as id) from Aquisicao a where a.id = :id", [id: Long.parseLong(id)])
        if (aquisicao)
            aquisicao = aquisicao?.first()

        render(aquisicao as JSON)
    }

    def list(){
        def aquisicao = Aquisicao.executeQuery("select new map(a.descricao as descricao, a.dataAquisicao as dataAquisicao, a.numeroConcurso as numeroConcurso" +
                "a.pathContracto as pathContracto, a.id as id) from Aquisicao a")

        render(aquisicao as JSON)
    }

}
