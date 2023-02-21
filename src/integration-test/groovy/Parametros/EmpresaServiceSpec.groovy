package Parametros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmpresaServiceSpec extends Specification {

    EmpresaService empresaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Empresa(...).save(flush: true, failOnError: true)
        //new Empresa(...).save(flush: true, failOnError: true)
        //Empresa empresa = new Empresa(...).save(flush: true, failOnError: true)
        //new Empresa(...).save(flush: true, failOnError: true)
        //new Empresa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //empresa.id
    }

    void "test get"() {
        setupData()

        expect:
        empresaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Empresa> empresaList = empresaService.list(max: 2, offset: 2)

        then:
        empresaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        empresaService.count() == 5
    }

    void "test delete"() {
        Long empresaId = setupData()

        expect:
        empresaService.count() == 5

        when:
        empresaService.delete(empresaId)
        sessionFactory.currentSession.flush()

        then:
        empresaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Empresa empresa = new Empresa()
        empresaService.save(empresa)

        then:
        empresa.id != null
    }
}
