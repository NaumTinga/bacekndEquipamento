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

        "/api/aquisicao"(resources:"modelo")
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



        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
