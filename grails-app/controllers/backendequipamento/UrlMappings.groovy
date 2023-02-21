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

        "/api/marca"(resources:"modelo")
        group "/api/modelo", {
            "/list"(controller:"modelo", action: 'list', method:"GET")
            "/show/$id"(controller:"modelo", action: 'show', id: $id)
            "/save"(controller:"modelo", action: 'save')
            "/update"(controller:"modelo", action: 'update')
            "/delete/$id"(controller:"modelo", action: 'delete', id: $id)
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
