/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.swdws.ejb;

import cat.paucasesnovescifp.swdws.dades.Foto;
import javax.ejb.Stateless;

/**
 *
 * @author alumne
 */
@Stateless
public class FotosSB {

    public void insertFoto(Foto foto){
//        foto.setId(2); //Si la
        //Guardam l'entitat. Si l'id és AI en acabar el persist foto tendrà l'id que toca.
        //em.persist(foto);
        //Cercam el darrer punt per mantenir l'extensió del fitxer
        int posicio=foto.getNom().lastIndexOf('.');
        //Recuperam l'extensió del fitxer
        String extensio=foto.getNom().substring(posicio);
        //Canviam el nom del fitxer. Com que foto encara està managed farà l'update automàticament.
        foto.setNom(foto.getId()+extensio);
    }
}
