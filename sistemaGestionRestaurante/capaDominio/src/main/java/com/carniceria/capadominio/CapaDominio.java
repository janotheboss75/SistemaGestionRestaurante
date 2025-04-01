 package com.carniceria.capadominio;

import entidades.Cliente;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import entidades.Ingrediente;
import entidades.IngredienteProducto;
import entidades.Mesa;
import entidades.Producto;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import enums.EstadoMesa;
import enums.TipoProducto;
import enums.UnidadDeMedida;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author janot
 */
public class CapaDominio {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        //MESAS
        Mesa mesa1 = new Mesa(1, EstadoMesa.DISPONIBLE);
        Mesa mesa2 = new Mesa(2, EstadoMesa.DISPONIBLE);
        Mesa mesa3= new Mesa(3, EstadoMesa.DISPONIBLE);
        Mesa mesa4 = new Mesa(4, EstadoMesa.DISPONIBLE);
        
        //INGREDIENTES
        Ingrediente ingrediente1 = new Ingrediente("Pan", UnidadDeMedida.PIEZAS, 10);
        Ingrediente ingrediente2 = new Ingrediente("Carne", UnidadDeMedida.GRAMOS, 1000);
        Ingrediente ingrediente3 = new Ingrediente("Lechuga", UnidadDeMedida.PIEZAS, 10);
        Ingrediente ingrediente4 = new Ingrediente("Tomate", UnidadDeMedida.PIEZAS, 10);
        Ingrediente ingrediente5 = new Ingrediente("Tocino", UnidadDeMedida.PIEZAS, 10);
        Ingrediente ingrediente6 = new Ingrediente("Limon", UnidadDeMedida.PIEZAS, 10);
        Ingrediente ingrediente7 = new Ingrediente("azucar", UnidadDeMedida.GRAMOS, 1000);
        Ingrediente ingrediente8 = new Ingrediente("agua", UnidadDeMedida.MILILITROS, 1000);
        Ingrediente ingrediente9 = new Ingrediente("Leche", UnidadDeMedida.MILILITROS, 1000);
        Ingrediente ingrediente10 = new Ingrediente("Levadura", UnidadDeMedida.GRAMOS, 1000);
        Ingrediente ingrediente11 = new Ingrediente("Harina", UnidadDeMedida.GRAMOS, 1000);
        Ingrediente ingrediente12 = new Ingrediente("Huevo", UnidadDeMedida.PIEZAS, 1000);
        
        //PRODUCTOS
        Producto producto1 = new Producto("Hamburguesa", 150, TipoProducto.PLATILLO);
        Producto producto2 = new Producto("Limonada", 20, TipoProducto.BEBIDA);
        Producto producto3 = new Producto("Cheese-cake", 70, TipoProducto.POSTRE);
        
        //CLIENTES
        Cliente cliente1 = new ClienteFrecuente("6442200293", "Alejandro", "Valdez", "Hermosillo", "janovaldezhillo@gmail.com", new Date());
        Cliente cliente2 = new ClienteFrecuente("6441330539","Rocko","Valdez","Hermosillo","rockolocko@gmail.com",new Date());
        Cliente cliente3 = new ClienteFrecuente("6441388452","Pedro","Narez","Osuna","pedritoAntritaxgmail.com",new Date());
        
        //COMANDAS
        Comanda comanda1 = new Comanda("3ewudjsjd", new Date(), EstadoComanda.ABIERTA, 0, entityManager.find(ClienteFrecuente.class, 101L), entityManager.find(Mesa.class, 1L));
        Comanda comanda2 = new Comanda("333223", new Date(), EstadoComanda.ABIERTA, 0, entityManager.find(ClienteFrecuente.class, 102L), entityManager.find(Mesa.class, 2L));
        Comanda comanda3 = new Comanda("344e", new Date(), EstadoComanda.ABIERTA, 0, entityManager.find(ClienteFrecuente.class, 103L), entityManager.find(Mesa.class, 3L));
        Comanda comanda4 = new Comanda("334345", new Date(), EstadoComanda.ABIERTA, 0, entityManager.find(ClienteFrecuente.class, 103L), entityManager.find(Mesa.class, 4L));
        
        //INGREDIENTES PRODUCTO
        IngredienteProducto ingProd1 = new IngredienteProducto(entityManager.find(Producto.class, 151L), entityManager.find(Ingrediente.class, 351L), 2);
        IngredienteProducto ingProd2 = new IngredienteProducto(entityManager.find(Producto.class, 151L), entityManager.find(Ingrediente.class, 352L), 100);
        IngredienteProducto ingProd3 = new IngredienteProducto(entityManager.find(Producto.class, 151L), entityManager.find(Ingrediente.class, 353L), 2);
        IngredienteProducto ingProd4 = new IngredienteProducto(entityManager.find(Producto.class, 151L), entityManager.find(Ingrediente.class, 354L), 1);
        IngredienteProducto ingProd5 = new IngredienteProducto(entityManager.find(Producto.class, 151L), entityManager.find(Ingrediente.class, 355L), 1);
        IngredienteProducto ingProd6 = new IngredienteProducto(entityManager.find(Producto.class, 152L), entityManager.find(Ingrediente.class, 356L), 2);
        IngredienteProducto ingProd7 = new IngredienteProducto(entityManager.find(Producto.class, 152L), entityManager.find(Ingrediente.class, 357L), 30);
        IngredienteProducto ingProd8 = new IngredienteProducto(entityManager.find(Producto.class, 152L), entityManager.find(Ingrediente.class, 358L), 150);
        IngredienteProducto ingProd9 = new IngredienteProducto(entityManager.find(Producto.class, 153L), entityManager.find(Ingrediente.class, 359L), 100);
        IngredienteProducto ingProd10 = new IngredienteProducto(entityManager.find(Producto.class, 153L), entityManager.find(Ingrediente.class, 360L), 50);
        IngredienteProducto ingProd11= new IngredienteProducto(entityManager.find(Producto.class, 153L), entityManager.find(Ingrediente.class, 361L), 30);
        IngredienteProducto ingProd12 = new IngredienteProducto(entityManager.find(Producto.class, 153L), entityManager.find(Ingrediente.class, 362L), 150);
        
        //PRODUCTOS COMANDA
        ProductoComanda prodCom1 = new ProductoComanda(entityManager.find(Comanda.class, 301L), entityManager.find(Producto.class, 151L), 150, "Sin tomate",2,300);
        ProductoComanda prodCom2 = new ProductoComanda(entityManager.find(Comanda.class, 301L), entityManager.find(Producto.class, 152L), 20, "Con hielo",1,20);
        
        ProductoComanda prodCom3 = new ProductoComanda(entityManager.find(Comanda.class, 302L), entityManager.find(Producto.class, 153L), 70, null, 1, 70);
        ProductoComanda prodCom4 = new ProductoComanda(entityManager.find(Comanda.class, 302L), entityManager.find(Producto.class, 152L), 20, "Con hielo", 1, 20);
        
        ProductoComanda prodCom5 = new ProductoComanda(entityManager.find(Comanda.class, 303L), entityManager.find(Producto.class, 151L), 150, null, 2, 300);
        ProductoComanda prodCom6 = new ProductoComanda(entityManager.find(Comanda.class, 303L), entityManager.find(Producto.class, 153L), 70, null, 2,140);
        
        /*
        //Agregar Mesas a la BD
        entityManager.getTransaction().begin();
        entityManager.persist(mesa1);
        entityManager.persist(mesa2);
        entityManager.persist(mesa3);
        entityManager.persist(mesa4);
        entityManager.getTransaction().commit();
        */
        
        /*
        //Agregar Clientes a la BD
        entityManager.getTransaction().begin();
        entityManager.persist(cliente1);
        entityManager.persist(cliente2);
        entityManager.persist(cliente3);
        entityManager.getTransaction().commit();
        */
        
        /*
        //Agregar Producto a la BD
        entityManager.getTransaction().begin();
        entityManager.persist(producto1);
        entityManager.persist(producto2);
        entityManager.persist(producto3);
        entityManager.getTransaction().commit();
        */
        
        /*
        //Agregar Comanda a la BD
        entityManager.getTransaction().begin();
        entityManager.persist(comanda1);
        entityManager.persist(comanda2);
        entityManager.persist(comanda3);
        entityManager.persist(comanda4);
        entityManager.getTransaction().commit();
        */
        
        /*
        //Agregar Ingredientes a la BD
        entityManager.getTransaction().begin();
        entityManager.persist(ingrediente1);
        entityManager.persist(ingrediente2);
        entityManager.persist(ingrediente3);
        entityManager.persist(ingrediente4);
        entityManager.persist(ingrediente5);
        entityManager.persist(ingrediente6);
        entityManager.persist(ingrediente7);
        entityManager.persist(ingrediente8);
        entityManager.persist(ingrediente9);
        entityManager.persist(ingrediente10);
        entityManager.persist(ingrediente11);
        entityManager.persist(ingrediente12);
        entityManager.getTransaction().commit();
        */
        
        /*
        //AGREGAR INGREDIENTES A PRODUCTOS EN LA BD
        entityManager.getTransaction().begin();
        entityManager.persist(ingProd1);
        entityManager.persist(ingProd2);
        entityManager.persist(ingProd3);
        entityManager.persist(ingProd4);
        entityManager.persist(ingProd5);
        entityManager.persist(ingProd6);
        entityManager.persist(ingProd7);
        entityManager.persist(ingProd8);
        entityManager.persist(ingProd9);
        entityManager.persist(ingProd10);
        entityManager.persist(ingProd11);
        entityManager.persist(ingProd12);
        entityManager.getTransaction().commit();
        */
        
        /*
        //AGREGAR PRODUCTOS A LAS COMANDAS
        entityManager.getTransaction().begin();
        entityManager.persist(prodCom1);
        entityManager.persist(prodCom2);
        entityManager.persist(prodCom3);
        entityManager.persist(prodCom4);
        entityManager.persist(prodCom5);
        entityManager.persist(prodCom6);
        entityManager.getTransaction().commit();
        */
        
        //VER SI LA LISTA DE INGREDIENTES SE ESTA GUARDANDO
        /*
        Producto p1 = entityManager.find(Producto.class, 151L);
        System.out.println(p1.getIngredientes());
        */
        
        /*
        Comanda c1 = entityManager.find(Comanda.class, 301L);
        System.out.println(c1.getProductos());
        */
        
        //PRUEBA PARA VER SI SIRVE CASCADETYPE.REMOVE
        //ELIMINANDO COMANDA
        /*
        entityManager.getTransaction().begin();
        entityManager.remove(c1);
        entityManager.getTransaction().commit();
        */
        
        /* DUDA EN ESTE POR QUE SI SE ELIMINA UN PRODUCTO TAMBIEN TIENE REGISTRO EN LAS COMANDAS
           ASI QUE LE QUITARE LO DE CASCADETYPE.REMOVE
        //ELIMINANDO PRODUCTO
        Producto p1 = entityManager.find(Producto.class, "Hamburguesa");
        System.out.println(p1.getIngredientes());
        
        entityManager.getTransaction().begin();
        entityManager.remove(p1);
        entityManager.getTransaction().commit();
        */
    }
}
