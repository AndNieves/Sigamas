/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.mailing;

import java.io.ByteArrayInputStream;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mattahari
 */
public class MailingBeanTest {

    public MailingBeanTest() {
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

    /**
     * Test of enviarMail method, of class MailingBean.
     */
    @Test
    public void testEnviarMail() throws Exception {
        System.out.println("enviarMail");
        String destino = "andnieves@gmail.com";
        String asunto = "Hola";
        String texto = "<h1>Soy hola hola</h1>";
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        //MailingBeanLocal instance = (MailingBeanLocal)container.getContext().lookup("java:global/classes/MailingBean");
        MailingBeanLocal instance = new MailingBean();
        instance.enviarMailHTML("invitacion@sigamas.com", "invitacion", destino, asunto, texto);
        //container.close();
        

    }

    /**
     * Test of enviarMailConAdjunto method, of class MailingBean.
     */
    @Test
    public void testEnviarMailConAdjunto() throws Exception {

        fail("The test case is a prototype.");
    }

}
