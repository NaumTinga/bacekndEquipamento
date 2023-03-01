package Parametros

import grails.gorm.services.Service

@Service(ItemsReparacao)
interface ItemsReparacaoService {

    ItemsReparacao get(Serializable id)

    List<ItemsReparacao> list(Map args)

    Long count()

    void delete(Serializable id)

    ItemsReparacao save(ItemsReparacao itemsReparacao)

}