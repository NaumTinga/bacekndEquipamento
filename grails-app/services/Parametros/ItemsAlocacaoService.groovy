package Parametros

import grails.gorm.services.Service

@Service(ItemsAlocacao)
interface ItemsAlocacaoService {

    ItemsAlocacao get(Serializable id)

    List<ItemsAlocacao> list(Map args)

    Long count()

    void delete(Serializable id)

    ItemsAlocacao save(ItemsAlocacao itemsAlocacao)

}