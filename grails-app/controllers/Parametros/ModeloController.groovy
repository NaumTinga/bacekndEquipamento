package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional


class ModeloController {

    @Transactional
    def save() {

        def requisicao = request?.JSON
        String nome = requisicao.nome

        if (!nome) {

            render([status: false, message: 'informe o nome do modelo'] as JSON)
            return
        }

        Modelo modelo = new Modelo(nome: nome, dataRegisto: new Date())

        if (modelo.save(flush: true)) {
            render([status: true, message: 'Modelo gravado', id: modelo?.id] as JSON)
            return
        } else {
            render([status: false, message: 'ocorreu um erro ao registar o modelo'] as JSON)
            return
        }
    }

        @Transactional
        def update(){

            def requisicao = request?.JSON
            String nome = requisicao.nome
            String id = requisicao.id

            if (!nome){
                render([status: false,message: 'informe o nome'] as JSON)
                return
            }
            if (!id) {
                render([status: false, message: 'informe o ID'])
            }

            Modelo modelo = Modelo.findById(Long.parseLong(id))

            if (modelo){
                modelo.nome = nome

                if (modelo.save(flush: true)){
                    render([status: true, message: 'o modelo foi actualizado', id: modelo?.id] as JSON)
                    return
                } else {
                    render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
                    return
                }
            } else {
                render([status:false, message: 'modelo nao encontrado' ] as JSON)
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

        Modelo modelo = Modelo.findById(Long.parseLong(id))

        if(modelo){
            modelo.delete()

            render([status: false, message: 'modelo removido'] as JSON)
            return
        } else {
            render([status: false, message: 'modelo nao encontrado'])
        }
    }

    def show(){
        String id = params.id

        if(!id){
            render([status: false, message: 'informe o id'])
            return
        }

        def modelo = Modelo.executeQuery("select new map(m.nome as nome, m.dataRegisto as dataRegisto," +
                "m.id as id) from Modelo m where m.id = :id", [id: Long.parseLong(id)])
        if (modelo)
            modelo = modelo?.first()

        render(modelo as JSON)
    }

    def list(){

//        def modelo = Modelo.executeQuery("select new map(m.nome as nome, m.dataRegisto " +
//                "as dataRegisto, m.id as id) from Modelo m ")

        def modelo = Modelo.executeQuery("select new map(m.nome as nome, m.dataRegisto " +
                "as dataRegisto, m.id as id) from Modelo m ")

        render(modelo as JSON)
    }

}
