package Parametros

import grails.gorm.services.Service

@Service(Alocacao)
interface AlocacaoService {

    Alocacao get(Serializable id)

    List<Alocacao> list(Map args)

    Long count()

    void delete(Serializable id)

    Alocacao save(Alocacao alocacao)

}