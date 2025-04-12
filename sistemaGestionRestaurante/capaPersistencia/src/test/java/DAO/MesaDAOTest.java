import DAO.MesaDAO;
import entidades.Mesa;
import enums.EstadoMesa;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


//INTENTO DE MOCKITO, YA NO ME ALCANZO EL TIEMPO
//PERO SI SE HACER PRUEBAS UNITARIAS ;)
public class MesaDAOTest {

    @Mock
    private EntityManager mockEntityManager;

    @Mock
    private EntityTransaction mockTransaction;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test of getInstanceDAO method, of class MesaDAO.
     */
    @Test
    public void testGetInstanceDAO() {
        System.out.println("getInstanceDAO");
        MesaDAO expResult = null; // Cambiar si se desea comparar con una instancia específica
        MesaDAO result = MesaDAO.getInstanceDAO();
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarMesas method, of class MesaDAO.
     */
    @Test
    public void testAgregarMesas() throws Exception {
        System.out.println("agregarMesas");

        int cantidadMesas = 3;
        IMesaDAO mesaDAO = MesaDAO.getInstanceDAO();
        when(mockEntityManager.getTransaction()).thenReturn(mockTransaction);

        doNothing().when(mockTransaction).begin();
        doNothing().when(mockTransaction).commit();

        boolean result = mesaDAO.agregarMesas(cantidadMesas);

        assertTrue(result);
        verify(mockEntityManager, times(cantidadMesas)).persist(any(Mesa.class));
    }

    /**
     * Test of consultarMesas method, of class MesaDAO.
     */
    @Test
    public void testConsultarMesas() throws Exception {
        System.out.println("consultarMesas");

        List<Mesa> mockMesas = new ArrayList<>();
        IMesaDAO mesaDAO = MesaDAO.getInstanceDAO();
        TypedQuery<Mesa> mockQuery = mock(TypedQuery.class);
        when(mockEntityManager.createQuery("SELECT m FROM Mesa m", Mesa.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(mockMesas);

        List<Mesa> result = mesaDAO.consultarMesas();

        assertEquals(mockMesas, result);
    }

    /**
     * Test of consultarMesasDisponibles method, of class MesaDAO.
     */
    @Test
    public void testConsultarMesasDisponibles() throws Exception {
        System.out.println("consultarMesasDisponibles");

        List<Mesa> mockMesas = new ArrayList<>();
        IMesaDAO mesaDAO = MesaDAO.getInstanceDAO();
        TypedQuery<Mesa> mockQuery = mock(TypedQuery.class);
        when(mockEntityManager.createQuery("SELECT m FROM Mesa m WHERE m.estadoMesa= :estadoMesa", Mesa.class)).thenReturn(mockQuery);
        when(mockQuery.setParameter("estadoMesa", EstadoMesa.DISPONIBLE)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(mockMesas);

        List<Mesa> result = mesaDAO.consultarMesasDisponibles();

        assertEquals(mockMesas, result);
    }

    /**
     * Test of cambiarEstadoDeMesa method, of class MesaDAO.
     */
    @Test
    public void testCambiarEstadoDeMesa() throws Exception {
        System.out.println("cambiarEstadoDeMesa");

        Long idMesa = 1L;
        EstadoMesa estadoMesa = EstadoMesa.OCUPADA;
        Mesa mesa = new Mesa(1, EstadoMesa.DISPONIBLE);
        IMesaDAO mesaDAO = MesaDAO.getInstanceDAO();
        when(mockEntityManager.find(Mesa.class, idMesa)).thenReturn(mesa);
        when(mockEntityManager.getTransaction()).thenReturn(mockTransaction);

        doNothing().when(mockTransaction).begin();
        doNothing().when(mockTransaction).commit();

        boolean result = mesaDAO.cambiarEstadoDeMesa(idMesa, estadoMesa);

        assertTrue(result);
        assertEquals(estadoMesa, mesa.getEstadoMesa());
    }
}
