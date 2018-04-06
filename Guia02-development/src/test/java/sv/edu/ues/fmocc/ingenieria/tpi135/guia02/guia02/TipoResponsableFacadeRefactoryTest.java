package sv.edu.ues.fmocc.ingenieria.tpi135.guia02.guia02;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.powermock.reflect.Whitebox;
import static sv.edu.ues.fmocc.ingenieria.tpi135.guia02.guia02.EntityManagerProvider.persistenceUnit;
import sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.mantenimientolib.entity.TipoResponsable;

/**
 *
 * @author ale
 */
public class TipoResponsableFacadeRefactoryTest {

     @Rule
    public EntityManagerProvider emProvider = persistenceUnit("mantenimientoTestPU");
    
     
     
    @BeforeClass
    public static void init() {
       

    }

    @Test
    public void when_creating_null_tipo_responsable_expect_false() {
        System.out.println("create valid tipo responsable");
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();

        boolean result = trf.crear(null);

        assertEquals(0, trf.findAll().size());
        assertFalse(result);
    }

    @Test
    public void when_creating_new_tipo_responsable_expect_true() {
        System.out.println("create valid tipo responsable");
        TipoResponsable nuevoTipoResponsable = new TipoResponsable();
        nuevoTipoResponsable.setNombreTipoResponsable("Test Tipo Responsable");
        nuevoTipoResponsable.setDetalleTipoResponsable("Algun detalle de prueba");
        nuevoTipoResponsable.setActivo(true);

        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());

        trf.getEntityManager().getTransaction().begin();
       
        boolean result = trf.crear(nuevoTipoResponsable);

        assertTrue(result);
        assertEquals(1, trf.findAll().size());
    }

    @Test
    public void when_modify_valid_tipo_responsable_expect_true() {
        System.out.println("modify valid tipo responsable");
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();
        trf.getEntityManager().persist(new TipoResponsable(null, "test tipo responsable", true));

        TipoResponsable expected = new TipoResponsable(1, "changed tipo responsable", false);
        TipoResponsable modified = new TipoResponsable(1, "changed tipo responsable", false);

        TipoResponsable result = trf.edit(expected);

        assertNotNull(result.getIdTipoResponsable());
        assertEquals(result.getNombreTipoResponsable(), expected.getNombreTipoResponsable());
    }

    @Test
    public void when_delete_null_tipo_responsable_expect_false() {
        System.out.println("delete null tipo responsable");
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();
        boolean result = trf.eliminar(null);
        assertEquals(0, trf.findAll().size());
        assertFalse(result);
    }

    @Test
    public void when_delete_valid_tipo_responsable_expect_true() {
        System.out.println("delete valid tipo responsable");
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();
        trf.getEntityManager().persist(new TipoResponsable(null, "test tipo responsable", true));
        TipoResponsable entity = new TipoResponsable(1);
        boolean result = trf.eliminar(entity);
        assertTrue(result);
    }
    
       /**
     * Test of find method, when the searched entity exists, of class TipoResponsableFacade.
     */
    @Test
    public void testFind_existing_entity() throws Exception {
        System.out.println("find existing id");
        Object id = 1;
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();
        trf.getEntityManager().persist(new TipoResponsable(1, "test tipo responsable", true));
        int expResult = 1;
        TipoResponsable result = trf.find(id);
        assertEquals(expResult, Integer.parseInt(String.valueOf(result.getIdTipoResponsable())));
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of find method, when the searched entity does not exist, of class TipoResponsableFacade.
     */
    @Test
    public void testFind_non_existing_entity() throws Exception {
        System.out.println("find non existing id");
        Object id = 1;
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();
        TipoResponsable result = trf.find(id);
        assertEquals(null, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of findAll method, when entity is not empty, of class TipoResponsableFacade.
     */
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll not empty");
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();
        trf.getEntityManager().persist(new TipoResponsable(null, "test tipo responsable1", true));
        List<TipoResponsable> result = trf.findAll();
        assertEquals(1, result.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * Test of count method, of class TipoResponsableFacade.
     */
    
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        TipoResponsableFacade trf = new TipoResponsableFacade();
        Whitebox.setInternalState(trf, "em", emProvider.em());
        trf.getEntityManager().getTransaction().begin();
        trf.getEntityManager().persist(new TipoResponsable(null, "test tipo responsable1", true));
        int expResult = 1;
        int result = trf.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void cleanup() {
        emProvider.em().getTransaction().rollback();
//        emProvider.em().close();
    }

    @AfterClass
    public static void tearDown() {
      
    }

 

}
