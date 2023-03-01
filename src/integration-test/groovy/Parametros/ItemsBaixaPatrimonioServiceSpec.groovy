package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ItemsBaixaPatrimonioServiceSpec extends Specification {

    ItemsBaixaPatrimonioService itemsBaixaPatrimonioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ItemsBaixaPatrimonio(...).save(flush: true, failOnError: true)
        //new ItemsBaixaPatrimonio(...).save(flush: true, failOnError: true)
        //ItemsBaixaPatrimonio itemsBaixaPatrimonio = new ItemsBaixaPatrimonio(...).save(flush: true, failOnError: true)
        //new ItemsBaixaPatrimonio(...).save(flush: true, failOnError: true)
        //new ItemsBaixaPatrimonio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //itemsBaixaPatrimonio.id
    }

    void "test get"() {
        setupData()

        expect:
        itemsBaixaPatrimonioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ItemsBaixaPatrimonio> itemsBaixaPatrimonioList = itemsBaixaPatrimonioService.list(max: 2, offset: 2)

        then:
        itemsBaixaPatrimonioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemsBaixaPatrimonioService.count() == 5
    }

    void "test delete"() {
        Long itemsBaixaPatrimonioId = setupData()

        expect:
        itemsBaixaPatrimonioService.count() == 5

        when:
        itemsBaixaPatrimonioService.delete(itemsBaixaPatrimonioId)
        sessionFactory.currentSession.flush()

        then:
        itemsBaixaPatrimonioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ItemsBaixaPatrimonio itemsBaixaPatrimonio = new ItemsBaixaPatrimonio()
        itemsBaixaPatrimonioService.save(itemsBaixaPatrimonio)

        then:
        itemsBaixaPatrimonio.id != null
    }
}
