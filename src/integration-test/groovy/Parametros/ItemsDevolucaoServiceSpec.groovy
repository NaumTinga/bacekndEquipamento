package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ItemsDevolucaoServiceSpec extends Specification {

    ItemsDevolucaoService itemsDevolucaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ItemsDevolucao(...).save(flush: true, failOnError: true)
        //new ItemsDevolucao(...).save(flush: true, failOnError: true)
        //ItemsDevolucao itemsDevolucao = new ItemsDevolucao(...).save(flush: true, failOnError: true)
        //new ItemsDevolucao(...).save(flush: true, failOnError: true)
        //new ItemsDevolucao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //itemsDevolucao.id
    }

    void "test get"() {
        setupData()

        expect:
        itemsDevolucaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ItemsDevolucao> itemsDevolucaoList = itemsDevolucaoService.list(max: 2, offset: 2)

        then:
        itemsDevolucaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemsDevolucaoService.count() == 5
    }

    void "test delete"() {
        Long itemsDevolucaoId = setupData()

        expect:
        itemsDevolucaoService.count() == 5

        when:
        itemsDevolucaoService.delete(itemsDevolucaoId)
        sessionFactory.currentSession.flush()

        then:
        itemsDevolucaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ItemsDevolucao itemsDevolucao = new ItemsDevolucao()
        itemsDevolucaoService.save(itemsDevolucao)

        then:
        itemsDevolucao.id != null
    }
}
