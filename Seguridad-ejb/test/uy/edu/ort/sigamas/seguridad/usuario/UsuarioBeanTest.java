/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Rol;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

/**
 *
 * @author Mattahari
 */
public class UsuarioBeanTest {
    
    public UsuarioBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of crearUsuario method, of class UsuarioBean.
//     */
//    @Test
//    public void testCrearUsuario() throws Exception {
//        System.out.println("crearUsuario");
//        Usuario nuevoUsuario = null;
//        Rol rol = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioBeanLocal instance = (UsuarioBeanLocal)container.getContext().lookup("java:global/classes/UsuarioBean");
//        Usuario expResult = null;
//        Usuario result = instance.crearUsuario(nuevoUsuario, rol);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modificarUsuario method, of class UsuarioBean.
//     */
//    @Test
//    public void testModificarUsuario() throws Exception {
//        System.out.println("modificarUsuario");
//        Usuario nuevoUsuario = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioBeanLocal instance = (UsuarioBeanLocal)container.getContext().lookup("java:global/classes/UsuarioBean");
//        Usuario expResult = null;
//        Usuario result = instance.modificarUsuario(nuevoUsuario);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarUsuario method, of class UsuarioBean.
//     */
//    @Test
//    public void testEliminarUsuario() throws Exception {
//        System.out.println("eliminarUsuario");
//        String nombreUsuario = "";
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioBeanLocal instance = (UsuarioBeanLocal)container.getContext().lookup("java:global/classes/UsuarioBean");
//        boolean expResult = false;
//        boolean result = instance.eliminarUsuario(nombreUsuario);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verificarUsuario method, of class UsuarioBean.
//     */
//    @Test
//    public void testVerificarUsuario() throws Exception {
//        System.out.println("verificarUsuario");
//        String nombreUsuario = "";
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioBeanLocal instance = (UsuarioBeanLocal)container.getContext().lookup("java:global/classes/UsuarioBean");
//        instance.verificarUsuario(nombreUsuario);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerUsuarios method, of class UsuarioBean.
//     */
//    @Test
//    public void testObtenerUsuarios() throws Exception {
//        System.out.println("obtenerUsuarios");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioBeanLocal instance = (UsuarioBeanLocal)container.getContext().lookup("java:global/classes/UsuarioBean");
//        List<Usuario> expResult = null;
//        List<Usuario> result = instance.obtenerUsuarios();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of cambiarContraseña method, of class UsuarioBean.
//     */
//    @Test
//    public void testCambiarContraseña() throws Exception {
//        System.out.println("cambiarContrase\u00f1a");
//        Usuario usuarioLoggeado = null;
//        String viejaContraseña = "";
//        String nuevaContraseña = "";
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioBeanLocal instance = (UsuarioBeanLocal)container.getContext().lookup("java:global/classes/UsuarioBean");
//        instance.cambiarContraseña(usuarioLoggeado, viejaContraseña, nuevaContraseña);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of invitarUsuario method, of class UsuarioBean.
     */
    @Test
    public void testInvitarUsuario() throws Exception {
        System.out.println("invitarUsuario");
        String emailInvitado = "andnieves@gmail.com";
        Usuario usuarioEmisor = new Usuario(0, "pepito@prueba.com", "", "", "");
        Cuenta cuentaInvitacion = new Cuenta(0, "cuentaprueba", "");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioBeanLocal instance = (UsuarioBeanLocal)container.getContext().lookup("java:global/classes/UsuarioBean");
        instance.invitarUsuario(emailInvitado, usuarioEmisor, cuentaInvitacion);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
