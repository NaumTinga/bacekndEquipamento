package Utilizador

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UtilizadorServiceSpec extends Specification {

    UtilizadorService utilizadorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Utilizador(...).save(flush: true, failOnError: true)
        //new Utilizador(...).save(flush: true, failOnError: true)
        //Utilizador utilizador = new Utilizador(...).save(flush: true, failOnError: true)
        //new Utilizador(...).save(flush: true, failOnError: true)
        //new Utilizador(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //utilizador.id
    }

    void "test get"() {
        setupData()

        expect:
        utilizadorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Utilizador> utilizadorList = utilizadorService.list(max: 2, offset: 2)

        then:
        utilizadorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        utilizadorService.count() == 5
    }

    void "test delete"() {
        Long utilizadorId = setupData()

        expect:
        utilizadorService.count() == 5

        when:
        utilizadorService.delete(utilizadorId)
        sessionFactory.currentSession.flush()

        then:
        utilizadorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Utilizador utilizador = new Utilizador()
        utilizadorService.save(utilizador)

        then:
        utilizador.id != null
    }
}
