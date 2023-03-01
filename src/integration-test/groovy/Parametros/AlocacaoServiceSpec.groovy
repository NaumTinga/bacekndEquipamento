package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AlocacaoServiceSpec extends Specification {

    AlocacaoService alocacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Alocacao(...).save(flush: true, failOnError: true)
        //new Alocacao(...).save(flush: true, failOnError: true)
        //Alocacao alocacao = new Alocacao(...).save(flush: true, failOnError: true)
        //new Alocacao(...).save(flush: true, failOnError: true)
        //new Alocacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //alocacao.id
    }

    void "test get"() {
        setupData()

        expect:
        alocacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Alocacao> alocacaoList = alocacaoService.list(max: 2, offset: 2)

        then:
        alocacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        alocacaoService.count() == 5
    }

    void "test delete"() {
        Long alocacaoId = setupData()

        expect:
        alocacaoService.count() == 5

        when:
        alocacaoService.delete(alocacaoId)
        sessionFactory.currentSession.flush()

        then:
        alocacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Alocacao alocacao = new Alocacao()
        alocacaoService.save(alocacao)

        then:
        alocacao.id != null
    }
}
