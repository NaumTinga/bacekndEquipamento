package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReparacaoServiceSpec extends Specification {

    ReparacaoService reparacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Reparacao(...).save(flush: true, failOnError: true)
        //new Reparacao(...).save(flush: true, failOnError: true)
        //Reparacao reparacao = new Reparacao(...).save(flush: true, failOnError: true)
        //new Reparacao(...).save(flush: true, failOnError: true)
        //new Reparacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reparacao.id
    }

    void "test get"() {
        setupData()

        expect:
        reparacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Reparacao> reparacaoList = reparacaoService.list(max: 2, offset: 2)

        then:
        reparacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reparacaoService.count() == 5
    }

    void "test delete"() {
        Long reparacaoId = setupData()

        expect:
        reparacaoService.count() == 5

        when:
        reparacaoService.delete(reparacaoId)
        sessionFactory.currentSession.flush()

        then:
        reparacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Reparacao reparacao = new Reparacao()
        reparacaoService.save(reparacao)

        then:
        reparacao.id != null
    }
}
