package Utilizador

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UnidadeServiceSpec extends Specification {

    UnidadeService unidadeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Unidade(...).save(flush: true, failOnError: true)
        //new Unidade(...).save(flush: true, failOnError: true)
        //Unidade unidade = new Unidade(...).save(flush: true, failOnError: true)
        //new Unidade(...).save(flush: true, failOnError: true)
        //new Unidade(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //unidade.id
    }

    void "test get"() {
        setupData()

        expect:
        unidadeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Unidade> unidadeList = unidadeService.list(max: 2, offset: 2)

        then:
        unidadeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        unidadeService.count() == 5
    }

    void "test delete"() {
        Long unidadeId = setupData()

        expect:
        unidadeService.count() == 5

        when:
        unidadeService.delete(unidadeId)
        sessionFactory.currentSession.flush()

        then:
        unidadeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Unidade unidade = new Unidade()
        unidadeService.save(unidade)

        then:
        unidade.id != null
    }
}
