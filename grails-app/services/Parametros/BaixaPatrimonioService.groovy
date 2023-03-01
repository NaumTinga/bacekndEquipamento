package Parametros

import grails.gorm.services.Service

@Service(BaixaPatrimonio)
interface BaixaPatrimonioService {

    BaixaPatrimonio get(Serializable id)

    List<BaixaPatrimonio> list(Map args)

    Long count()

    void delete(Serializable id)

    BaixaPatrimonio save(BaixaPatrimonio baixaPatrimonio)

}