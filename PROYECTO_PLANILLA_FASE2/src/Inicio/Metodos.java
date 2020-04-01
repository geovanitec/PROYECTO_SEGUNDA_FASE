/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.util.ArrayList;

/**
 *
 * @author Geovani
 */
public class Metodos {
    

    private ArrayList<Object> Alist = new ArrayList<Object>();

    public Metodos() {
    }

    public Metodos(ArrayList<Object> a) {
        this.Alist =Alist;
    }

    public void AgregarRegistro(Definicion_Variables Dvariables) {
        this.Alist.add(Dvariables);
    }

    public void ModificarRegistro(int i, Definicion_Variables Dvariables) {
        this.Alist.set(i, Dvariables);
    }

    public void EliminarRegistro(int i) {
        this.Alist.remove(i);
    }

    public Definicion_Variables ObtenerRegistro(int i) {
        return (Definicion_Variables) Alist.get(i);
    }

    public int CantidadRegistro() {
        return this.Alist.size();
    }

    public int BuscaCodigo(int intCodigo) {
        for (int i = 0; i < CantidadRegistro(); i++) {
            if (intCodigo == ObtenerRegistro(i).getIntCodigo()) {
                return i;
            }
        }
        return -1;
    }

}
