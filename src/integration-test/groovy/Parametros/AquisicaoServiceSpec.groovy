package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AquisicaoServiceSpec extends Specification {

    AquisicaoService aquisicaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Aquisicao(...).save(flush: true, failOnError: true)
        //new Aquisicao(...).save(flush: true, failOnError: true)
        //Aquisicao aquisicao = new Aquisicao(...).save(flush: true, failOnError: true)
        //new Aquisicao(...).save(flush: true, failOnError: true)
        //new Aquisicao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //aquisicao.id
    }

    void "test get"() {
        setupData()

        expect:
        aquisicaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Aquisicao> aquisicaoList = aquisicaoService.list(max: 2, offset: 2)

        then:
        aquisicaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        aquisicaoService.count() == 5
    }

    void "test delete"() {
        Long aquisicaoId = setupData()

        expect:
        aquisicaoService.count() == 5

        when:
        aquisicaoService.delete(aquisicaoId)
        sessionFactory.currentSession.flush()

        then:
        aquisicaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Aquisicao aquisicao = new Aquisicao()
        aquisicaoService.save(aquisicao)

        then:
        aquisicao.id != null
    }
}
