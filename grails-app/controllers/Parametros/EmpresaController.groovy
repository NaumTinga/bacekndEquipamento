package Parametros

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmpresaController {

   @Transactional
    def save() {

       def requisicao = request?.JSON
       String designacao = requisicao.designacao
       String descricao = requisicao.descricao

       if (!designacao) {
           render([status: false, message: 'informe a designacao'] as JSON)
           return
       }

       if (!descricao) {
           render([status: false, message: 'informe a descricao'] as JSON)
           return
       }

       Empresa empresa = new Empresa(designacao: designacao,descricao: descricao)

       if (empresa.save(flush: true)) {
           render([status: true, message: 'empresa gravada', id: empresa?.id] as JSON)
           return
       } else {
           render([status: false, message: 'ocorreu um erro ao registar o seu pedido'] as JSON)
           return
       }

   }

   @Transactional
    def update() {

       def requisicao = request?.JSON
       String designacao = requisicao.designacao
       String descricao = requisicao.descricao
       String id = requisicao.id

       if (!designacao) {
           render([status: false, message: 'informe a designacao'] as JSON)
           return
       }

       if (!descricao) {
           render([status: false, message: 'informe a descricao'] as JSON)
           return
       }

       if (!id) {
           render([status: false, message: 'informe a id'] as JSON)
           return
       }

       Empresa empresa = Empresa.findById(Long.parseLong(id))

       if (empresa) {

           empresa.designacao = designacao
           empresa.descricao = descricao

           if (empresa.save(flush: true)){
               render([status: true, message: 'a empresa foi actualizado', id: empresa?.id] as JSON)
               return
           } else {
               render([status: false, message: 'ocorreu um erro ao actualizar o seu pedido'] as JSON)
               return
           }
       } else {
           render([status:false, message: 'empresa nao encontrado' ] as JSON)
           return
       }

   }

   @Transactional
    def delete() {

       def requisicao = request?.JSON
       String id = requisicao.id

       if (!id) {
           render([status: false, message: 'informe o id da empresa'] as JSON)
           return
       }

       Empresa empresa = Empresa.findById(Long.parseLong(id))

       if (empresa) {

           empresa.delete()

           render([status: true, message: 'empresa removida'] as JSON)
           return
       } else {
           render([status: false, message: 'empresa nao enocntrada'])
       }
   }

   def show() {

       def requisicao = request?.JSON
       String id = requisicao.id

       if (!id) {
           render([status: false, message: 'informe o id da empresa'] as JSON)
           return
       }

       def  empresa = Empresa.executeQuery("select new map(e.designacao as designacao, e.descricao as descricao" +
               "e.id as id) from Empresa e where e.id = :id", [id: Long.parseLong(id)])

       if (empresa)
           empresa = empresa?.first()

       render(empresa as JSON)


   }

   def list() {
        def empresa = Empresa.executeQuery("select new map(e.designacao as designacao, e.descricao as descricao" +
                "e.id as id) from Empresa e")
       render(empresa as JSON)
   }
}
