package backendequipamento

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
		
		"/api/marca"(resources:"marca")
        group "/api/marca", {
            "/list"(controller:"marca", action: 'list', method:"GET")
            "/show/$id"(controller:"marca", action: 'show', id: $id)
            "/save"(controller:"marca", action: 'save')
            "/update"(controller:"marca", action: 'update')
            "/delete/$id"(controller:"marca", action: 'delete', id: $id)
        }

        "/api/modelo"(resources:"modelo")
        group "/api/modelo", {
            "/list"(controller:"modelo", action: 'list', method:"GET")
            "/show/$id"(controller:"modelo", action: 'show', id: $id)
            "/save"(controller:"modelo", action: 'save')
            "/update"(controller:"modelo", action: 'update')
            "/delete/$id"(controller:"modelo", action: 'delete', id: $id)
        }



        "/api/aquisicao"(resources:"aquisicao")
        group "/api/aquisicao", {
            "/list"(controller:"aquisicao", action: 'list', method:"GET")
            "/show/$id"(controller:"aquisicao", action: 'show', id: $id)
            "/save"(controller:"aquisicao", action: 'save')
            "/update"(controller:"aquisicao", action: 'update')
            "/delete/$id"(controller:"aquisicao", action: 'delete', id: $id)
        }

        "/api/empresa"(resources:"empresa")
        group "/api/empresa", {
            "/list"(controller:"empresa", action: 'list', method:"GET")
            "/show/$id"(controller:"empresa", action: 'show', id: $id)
            "/save"(controller:"empresa", action: 'save')
            "/update"(controller:"empresa", action: 'update')
            "/delete/$id"(controller:"empresa", action: 'delete', id: $id)
        }

        "/api/equipamento"(resources:"equipamento")
        group "/api/equipamento", {
            "/list"(controller:"equipamento", action: 'list', method:"GET")
            "/show/$id"(controller:"equipamento", action: 'show', id: $id)
            "/save"(controller:"equipamento", action: 'save')
            "/update"(controller:"equipamento", action: 'update')
            "/delete/$id"(controller:"equipamento", action: 'delete', id: $id)
        }



        "/api/tipoEquipamento"(resources:"tipoEquipamento")
        group "/api/tipoEquipamento", {
            "/list"(controller:"tipoEquipamento", action: 'list', method:"GET")
            "/show/$id"(controller:"tipoEquipamento", action: 'show', id: $id)
            "/save"(controller:"tipoEquipamento", action: 'save')
            "/update"(controller:"tipoEquipamento", action: 'update')
            "/delete/$id"(controller:"tipoEquipamento", action: 'delete', id: $id)
        }

        "/api/baixaPatrimonio"(resources:"baixaPatrimonio")
        group "/api/baixaPatrimonio", {
            "/list"(controller:"baixaPatrimonio", action: 'list', method:"GET")
            "/show/$id"(controller:"baixaPatrimonio", action: 'show', id: $id)
            "/save"(controller:"baixaPatrimonio", action: 'save')
            "/update"(controller:"baixaPatrimonio", action: 'update')
            "/delete/$id"(controller:"baixaPatrimonio", action: 'delete', id: $id)
        }

        "/api/alocacao"(resources:"alocacao")
        group "/api/alocacao", {
            "/list"(controller:"alocacao", action: 'list', method:"GET")
            "/show/$id"(controller:"alocacao", action: 'show', id: $id)
            "/save"(controller:"alocacao", action: 'save')
            "/update"(controller:"alocacao", action: 'update')
            "/delete/$id"(controller:"alocacao", action: 'delete', id: $id)
        }

        "/api/itemsAlocacao"(resources:"itemsAlocacao")
        group "/api/itemsAlocacao", {
            "/list"(controller:"itemsAlocacao", action: 'list', method:"GET")
            "/show/$id"(controller:"itemsAlocacao", action: 'show', id: $id)
            "/save"(controller:"itemsAlocacao", action: 'save')
            "/update"(controller:"itemsAlocacao", action: 'update')
            "/delete/$id"(controller:"itemsAlocacao", action: 'delete', id: $id)
        }

        "/api/itemsReparacao"(resources:"itemsReparacao")
        group "/api/itemsReparacao", {
            "/list"(controller:"itemsReparacao", action: 'list', method:"GET")
            "/show/$id"(controller:"itemsReparacao", action: 'show', id: $id)
            "/save"(controller:"itemsReparacao", action: 'save')
            "/update"(controller:"itemsReparacao", action: 'update')
            "/delete/$id"(controller:"itemsReparacao", action: 'delete', id: $id)
        }

        "/api/itemsBaixaPatrimonio"(resources:"itemsBaixaPatrimonio")
        group "/api/itemsBaixaPatrimonio", {
            "/list"(controller:"itemsBaixaPatrimonio", action: 'list', method:"GET")
            "/show/$id"(controller:"itemsBaixaPatrimonio", action: 'show', id: $id)
            "/save"(controller:"itemsBaixaPatrimonio", action: 'save')
            "/update"(controller:"itemsBaixaPatrimonio", action: 'update')
            "/delete/$id"(controller:"itemsBaixaPatrimonio", action: 'delete', id: $id)
        }

        "/api/itemsDevolucao"(resources:"itemsDevolucao")
        group "/api/itemsDevolucao", {
            "/list"(controller:"itemsDevolucao", action: 'list', method:"GET")
            "/show/$id"(controller:"itemsDevolucao", action: 'show', id: $id)
            "/save"(controller:"itemsDevolucao", action: 'save')
            "/update"(controller:"itemsDevolucao", action: 'update')
            "/delete/$id"(controller:"itemsDevolucao", action: 'delete', id: $id)
        }

        "/api/devolucao"(resources:"devolucao")
        group "/api/devolucao", {
            "/list"(controller:"devolucao", action: 'list', method:"GET")
            "/show/$id"(controller:"devolucao", action: 'show', id: $id)
            "/save"(controller:"devolucao", action: 'save')
            "/update"(controller:"devolucao", action: 'update')
            "/delete/$id"(controller:"devolucao", action: 'delete', id: $id)
        }

        "/api/reparacao"(resources:"reparacao")
        group "/api/reparacao", {
            "/list"(controller:"reparacao", action: 'list', method:"GET")
            "/show/$id"(controller:"reparacao", action: 'show', id: $id)
            "/save"(controller:"reparacao", action: 'save')
            "/update"(controller:"reparacao", action: 'update')
            "/delete/$id"(controller:"reparacao", action: 'delete', id: $id)
        }



        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
