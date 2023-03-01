package Utilizador

import grails.gorm.services.Service

@Service(Unidade)
interface UnidadeService {

    Unidade get(Serializable id)

    List<Unidade> list(Map args)

    Long count()

    void delete(Serializable id)

    Unidade save(Unidade unidade)

}