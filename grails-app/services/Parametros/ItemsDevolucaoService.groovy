package Parametros

import grails.gorm.services.Service

@Service(ItemsDevolucao)
interface ItemsDevolucaoService {

    ItemsDevolucao get(Serializable id)

    List<ItemsDevolucao> list(Map args)

    Long count()

    void delete(Serializable id)

    ItemsDevolucao save(ItemsDevolucao itemsDevolucao)

}