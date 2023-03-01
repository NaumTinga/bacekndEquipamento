package Utilizador

import grails.gorm.services.Service

@Service(Utilizador)
interface UtilizadorService {

    Utilizador get(Serializable id)

    List<Utilizador> list(Map args)

    Long count()

    void delete(Serializable id)

    Utilizador save(Utilizador utilizador)

}