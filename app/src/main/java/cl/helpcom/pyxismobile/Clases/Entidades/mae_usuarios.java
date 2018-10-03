package cl.helpcom.pyxismobile.Clases.Entidades;

import java.io.Serializable;

public class mae_usuarios implements Serializable {

    private String usu_nusuario;
    private String usu_password;
    private String usu_nombre;
    private int per_id;
    private int car_id;
    private int sec_id;
    private int usu_activo;
    private int ven_id;
    private String usu_su;
    private String usu_telefono;

    public mae_usuarios(String usu_nusuario, String usu_password, String usu_nombre,
                        int per_id, int car_id, int sec_id, int usu_activo, int ven_id, String usu_su, String usu_telefono) {
        this.usu_nusuario = usu_nusuario;
        this.usu_password = usu_password;
        this.usu_nombre = usu_nombre;
        this.per_id = per_id;
        this.car_id = car_id;
        this.sec_id = sec_id;
        this.usu_activo = usu_activo;
        this.ven_id = ven_id;
        this.usu_su = usu_su;
        this.usu_telefono = usu_telefono;
    }

    public mae_usuarios() {

    }

    public String getUsu_nusuario() {
        return usu_nusuario;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public int getPer_id() {
        return per_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public int getSec_id() {
        return sec_id;
    }

    public int getUsu_activo() {
        return usu_activo;
    }

    public int getVen_id() {
        return ven_id;
    }

    public String getUsu_su() {
        return usu_su;
    }

    public String getUsu_telefono() {
        return usu_telefono;
    }

    public void setUsu_nusuario(String usu_nusuario) {
        this.usu_nusuario = usu_nusuario;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setSec_id(int sec_id) {
        this.sec_id = sec_id;
    }

    public void setUsu_activo(int usu_activo) {
        this.usu_activo = usu_activo;
    }

    public void setVen_id(int ven_id) {
        this.ven_id = ven_id;
    }

    public void setUsu_su(String usu_su) {
        this.usu_su = usu_su;
    }

    public void setUsu_telefono(String usu_telefono) {
        this.usu_telefono = usu_telefono;
    }
}
