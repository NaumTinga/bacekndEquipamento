package Parametros

import grails.gorm.services.Service

@Service(Devolucao)
interface DevolucaoService {

    Devolucao get(Serializable id)

    List<Devolucao> list(Map args)

    Long count()

    void delete(Serializable id)

    Devolucao save(Devolucao devolucao)

}