/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.sigamas.enums.EstadosInvitacion;
import uy.edu.ort.sigamas.mailing.MailingBeanLocal;
import uy.edu.ort.sigamas.mailing.exceptions.MailErrorException;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.InvitacionCuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Rol;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.UsuarioExistenteException;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.ViejaContraseñaIncorrectaException;
import uy.edu.ort.sigamas.seguridad.usuario.utils.UtilUsuario;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {

    @EJB
    private MailingBeanLocal mailingBeanLocal;

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;

    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario, Rol rol) throws UsuarioExistenteException {
        return UtilUsuario.crearUsuario(em, nuevoUsuario, rol);
    }

    @Override
    public Usuario modificarUsuario(Usuario nuevoUsuario) {
        return UtilUsuario.modificarUsuario(em, nuevoUsuario);
    }

    @Override
    public boolean eliminarUsuario(String nombreUsuario) {
        return UtilUsuario.eliminarUsuario(em, nombreUsuario);
    }

    @Override
    public void verificarUsuario(String nombreUsuario) throws UsuarioExistenteException {
        UtilUsuario.verificarNombreUsuario(em, nombreUsuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public void cambiarContraseña(Usuario usuarioLoggeado, String viejaContraseña, String nuevaContraseña) throws ViejaContraseñaIncorrectaException {
        UtilUsuario.cambiarContraseña(em, usuarioLoggeado, viejaContraseña, nuevaContraseña);
    }

    @Override
    public void invitarUsuario(String emailInvitado, Usuario usuarioEmisor, Cuenta cuentaInvitacion) {
        //Configuracion del mail
        String username = "invitacion@sigamas.com";
        String password = "invitacion";
        //Se verifica si el usuario existe previamente
        Query q = em.createNamedQuery("Usuario.findByNombreUsuario");
        q.setParameter("nombreUsuario", emailInvitado);
        List<Usuario> retorno = (List<Usuario>) q.getResultList();
        if (retorno.isEmpty()) {
            try {
                //El usuario no existe, se debe enviar una invitacion por mail
                InvitacionCuenta i = new InvitacionCuenta();
                i.setEmisor(usuarioEmisor.getEmailUsuario());
                i.setReceptor(emailInvitado);
                i.setEstado(EstadosInvitacion.PENDIENTE);
                i.setIdCuenta(cuentaInvitacion.getIdCuenta());
                em.persist(i);
                String html = "<h1>Invitaci&oacute;n a Cuenta de Sigamas</h1><br/>"
                        + "<img src=\"http://www.sigamas.com/web/images/nuevoLogo.png\"/>"
                        +"<p>"+usuarioEmisor.getNombre()+" "+usuarioEmisor.getApellidos()+" te invito a la cuenta "+cuentaInvitacion.getNombre() +"</p>"
                        + "<br/><a>http://localhost:8080/Sigamas/direccion+"+i.getIdCuenta()+"</a>";
                mailingBeanLocal.enviarMailHTML(username, password, emailInvitado, "Sigamas - Invitacion a Cuenta", html);
            } catch (MailErrorException ex) {
                Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

}
