package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EquipamentoController {

    @Transactional
    def save() {

        String numeroSerie = params.numeroSerie

        if (!numeroSerie) {
            render([status: false, message: 'informe o numero de serie'] as JSON)
            return
        }

        Equipamento equipamento = new Equipamento(numeroSerie: numeroSerie, dataRegisto: new Date())

        if (equipamento.save(flush: true)) {
            render([status: true, message: 'gravado', id: equipamento?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreum um erro ao registar o seu pedido'])
            return
        }
    }

    @Transactional
    def update() {
        String numeroSerie = params.numeroSerie
        String id = params.id

        if (!numeroSerie) {
            render([status: false, message: 'informe o numero de serie'] as JSON)
            return
        }

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        Equipamento equipamento = Equipamento.findById(Long.parseLong(id))

        if (equipamento) {
            equipamento.numeroSerie = numeroSerie

            if (equipamento.save(flush: true)) {
                render([status: true, message: 'actualizado', id: tipoEquipamento?.id] as JSON)
                return
            } else {
                render([status: false, message: 'ocorreu um erro ao actualizar'])
                return
            }

        } else {
            render([status: false, message: 'Equipamento nao encontrado'] as JSON)
            return
        }
    }

    def show() {

        String id = params.id

        if (!id) {
            render([status: false, message: 'informe o id'] as JSON)
            return
        }

        def equipamento = Equipamento.executeQuery("select new map(e.numeroSerie as numeroSerie, e.dataRegisto as dataRegisto," +
                "e.id as id) from Equipamento e where t.id = :id", [id: Long.parseLong(id)])

        if (equipamento)
            equipamento = equipamento?.first()

        render(equipamento as JSON)
    }

    def list(){
        def equipamento = Equipamento.executeQuery("select new map(e.numeroSerie as numeroSerie, e.dataRegisto as dataRegisto," +
                "e.id as id) from Equipamento t")

        render(equipamento as JSON)
    }
}
