package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DevolucaoServiceSpec extends Specification {

    DevolucaoService devolucaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Devolucao(...).save(flush: true, failOnError: true)
        //new Devolucao(...).save(flush: true, failOnError: true)
        //Devolucao devolucao = new Devolucao(...).save(flush: true, failOnError: true)
        //new Devolucao(...).save(flush: true, failOnError: true)
        //new Devolucao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //devolucao.id
    }

    void "test get"() {
        setupData()

        expect:
        devolucaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Devolucao> devolucaoList = devolucaoService.list(max: 2, offset: 2)

        then:
        devolucaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        devolucaoService.count() == 5
    }

    void "test delete"() {
        Long devolucaoId = setupData()

        expect:
        devolucaoService.count() == 5

        when:
        devolucaoService.delete(devolucaoId)
        sessionFactory.currentSession.flush()

        then:
        devolucaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Devolucao devolucao = new Devolucao()
        devolucaoService.save(devolucao)

        then:
        devolucao.id != null
    }
}
