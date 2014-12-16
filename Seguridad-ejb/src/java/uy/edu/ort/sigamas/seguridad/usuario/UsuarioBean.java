/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.entidades.seguridad.Rol;
import uy.edu.ort.sigamas.entidades.seguridad.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.UsuarioExistenteException;
import uy.edu.ort.sigamas.seguridad.usuario.excepciones.ViejaContraseñaIncorrectaException;
import uy.edu.ort.sigamas.seguridad.usuario.utils.UtilUsuario;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario, Rol rol) throws UsuarioExistenteException{
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
    public void verificarUsuario(String nombreUsuario) throws UsuarioExistenteException{
        UtilUsuario.verificarNombreUsuario(em, nombreUsuario);
    }
    
    @Override 
    public List<Usuario> obtenerUsuarios(){
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }
    
    @Override
    public void cambiarContraseña(Usuario usuarioLoggeado, String viejaContraseña, String nuevaContraseña) throws ViejaContraseñaIncorrectaException{
        UtilUsuario.cambiarContraseña(em, usuarioLoggeado, viejaContraseña, nuevaContraseña);
    }
}
