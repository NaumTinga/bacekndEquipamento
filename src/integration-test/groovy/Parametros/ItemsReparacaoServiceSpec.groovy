package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ItemsReparacaoServiceSpec extends Specification {

    ItemsReparacaoService itemsReparacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ItemsReparacao(...).save(flush: true, failOnError: true)
        //new ItemsReparacao(...).save(flush: true, failOnError: true)
        //ItemsReparacao itemsReparacao = new ItemsReparacao(...).save(flush: true, failOnError: true)
        //new ItemsReparacao(...).save(flush: true, failOnError: true)
        //new ItemsReparacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //itemsReparacao.id
    }

    void "test get"() {
        setupData()

        expect:
        itemsReparacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ItemsReparacao> itemsReparacaoList = itemsReparacaoService.list(max: 2, offset: 2)

        then:
        itemsReparacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemsReparacaoService.count() == 5
    }

    void "test delete"() {
        Long itemsReparacaoId = setupData()

        expect:
        itemsReparacaoService.count() == 5

        when:
        itemsReparacaoService.delete(itemsReparacaoId)
        sessionFactory.currentSession.flush()

        then:
        itemsReparacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ItemsReparacao itemsReparacao = new ItemsReparacao()
        itemsReparacaoService.save(itemsReparacao)

        then:
        itemsReparacao.id != null
    }
}
