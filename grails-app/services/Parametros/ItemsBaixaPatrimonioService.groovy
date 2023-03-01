package Parametros

import grails.gorm.services.Service

@Service(ItemsBaixaPatrimonio)
interface ItemsBaixaPatrimonioService {

    ItemsBaixaPatrimonio get(Serializable id)

    List<ItemsBaixaPatrimonio> list(Map args)

    Long count()

    void delete(Serializable id)

    ItemsBaixaPatrimonio save(ItemsBaixaPatrimonio itemsBaixaPatrimonio)

}