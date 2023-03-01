package Utilizador

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GrupoServiceSpec extends Specification {

    GrupoService grupoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Grupo(...).save(flush: true, failOnError: true)
        //new Grupo(...).save(flush: true, failOnError: true)
        //Grupo grupo = new Grupo(...).save(flush: true, failOnError: true)
        //new Grupo(...).save(flush: true, failOnError: true)
        //new Grupo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //grupo.id
    }

    void "test get"() {
        setupData()

        expect:
        grupoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Grupo> grupoList = grupoService.list(max: 2, offset: 2)

        then:
        grupoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        grupoService.count() == 5
    }

    void "test delete"() {
        Long grupoId = setupData()

        expect:
        grupoService.count() == 5

        when:
        grupoService.delete(grupoId)
        sessionFactory.currentSession.flush()

        then:
        grupoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Grupo grupo = new Grupo()
        grupoService.save(grupo)

        then:
        grupo.id != null
    }
}
