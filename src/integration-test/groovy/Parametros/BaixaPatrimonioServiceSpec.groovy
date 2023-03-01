package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BaixaPatrimonioServiceSpec extends Specification {

    BaixaPatrimonioService baixaPatrimonioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new BaixaPatrimonio(...).save(flush: true, failOnError: true)
        //new BaixaPatrimonio(...).save(flush: true, failOnError: true)
        //BaixaPatrimonio baixaPatrimonio = new BaixaPatrimonio(...).save(flush: true, failOnError: true)
        //new BaixaPatrimonio(...).save(flush: true, failOnError: true)
        //new BaixaPatrimonio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //baixaPatrimonio.id
    }

    void "test get"() {
        setupData()

        expect:
        baixaPatrimonioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<BaixaPatrimonio> baixaPatrimonioList = baixaPatrimonioService.list(max: 2, offset: 2)

        then:
        baixaPatrimonioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        baixaPatrimonioService.count() == 5
    }

    void "test delete"() {
        Long baixaPatrimonioId = setupData()

        expect:
        baixaPatrimonioService.count() == 5

        when:
        baixaPatrimonioService.delete(baixaPatrimonioId)
        sessionFactory.currentSession.flush()

        then:
        baixaPatrimonioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        BaixaPatrimonio baixaPatrimonio = new BaixaPatrimonio()
        baixaPatrimonioService.save(baixaPatrimonio)

        then:
        baixaPatrimonio.id != null
    }
}
