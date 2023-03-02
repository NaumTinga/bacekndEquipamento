package Parametros

import grails.gorm.services.Service

@Service(Reparacao)
interface ReparacaoService {

    Reparacao get(Serializable id)

    List<Reparacao> list(Map args)

    Long count()

    void delete(Serializable id)

    Reparacao save(Reparacao reparacao)

}