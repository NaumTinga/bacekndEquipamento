package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ItemsAlocacaoServiceSpec extends Specification {

    ItemsAlocacaoService itemsAlocacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ItemsAlocacao(...).save(flush: true, failOnError: true)
        //new ItemsAlocacao(...).save(flush: true, failOnError: true)
        //ItemsAlocacao itemsAlocacao = new ItemsAlocacao(...).save(flush: true, failOnError: true)
        //new ItemsAlocacao(...).save(flush: true, failOnError: true)
        //new ItemsAlocacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //itemsAlocacao.id
    }

    void "test get"() {
        setupData()

        expect:
        itemsAlocacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ItemsAlocacao> itemsAlocacaoList = itemsAlocacaoService.list(max: 2, offset: 2)

        then:
        itemsAlocacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemsAlocacaoService.count() == 5
    }

    void "test delete"() {
        Long itemsAlocacaoId = setupData()

        expect:
        itemsAlocacaoService.count() == 5

        when:
        itemsAlocacaoService.delete(itemsAlocacaoId)
        sessionFactory.currentSession.flush()

        then:
        itemsAlocacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ItemsAlocacao itemsAlocacao = new ItemsAlocacao()
        itemsAlocacaoService.save(itemsAlocacao)

        then:
        itemsAlocacao.id != null
    }
}
