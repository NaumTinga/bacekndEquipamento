package Parametros

import grails.gorm.services.Service

@Service(Aquisicao)
interface AquisicaoService {

    Aquisicao get(Serializable id)

    List<Aquisicao> list(Map args)

    Long count()

    void delete(Serializable id)

    Aquisicao save(Aquisicao aquisicao)

}