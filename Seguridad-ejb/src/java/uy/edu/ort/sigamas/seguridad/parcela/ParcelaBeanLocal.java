/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.parcela;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;

/**
 *
 * @author Pikachuss
 */
@Local
public interface ParcelaBeanLocal {

    List<Parcela> obtenerParcelas();
    
}