/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.swdws.dades;

/**
 *
 * @author alumne
 */
public class Foto {
    private int id;
    private int idClient;
    private String nom;
    
    public Foto(){
        this(0,null);
    }

    public Foto(int idClient, String nom) {
        this.idClient = idClient;
        this.nom = nom;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Foto{" + "id=" + id + ", idClient=" + idClient + ", nom=" + nom + '}';
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
   
    
}
