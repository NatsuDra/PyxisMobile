package cl.helpcom.pyxismobile.Clases.Entidades;

public class mae_clientes {

    private int clid_id;
    private String cli_rut;
    private String cli_nombre;
    private String cli_direccion;
    private String cli_ciudad;
    private String cli_nombre_contacto;
    private String cli_cargo;
    private String cli_telefono;
    private String cli_fax;
    private String cli_celular;
    private String cli_mail;
    private int tcp_id;
    private String cli_fecha_nacimiento;
    private int cli_activo;
    private int cli_limite_credito;
    private String cli_giro;
    private int cli_sobrecargo;
    private int cli_credito_ilimitado;
    private double cli_descuento_venta;
    private String cli_sucursal;
    private String clv_codigo_barra;
    private int rut_id;
    private int rut_orden;
    private String cli_comuna;
    private String cli_region;
    private String cli_fpago;
    private int cli_rapel;
    private String cli_motivo_bloqueo;
    private String cli_fantasia;
    private int lpr_id;
    private int cli_dias_pago;
    private int ban_id;
    private String cli_cuenta_corriente;

    public mae_clientes(int clid_id, String cli_rut, String cli_nombre, String cli_direccion, String cli_ciudad,
                        String cli_nombre_contacto, String cli_cargo, String cli_telefono, String cli_fax, String cli_celular,
                        String cli_mail, int tcp_id, String cli_fecha_nacimiento, int cli_activo, int cli_limite_credito,
                        String cli_giro, int cli_sobrecargo, int cli_credito_ilimitado, double cli_descuento_venta,
                        String cli_sucursal, String clv_codigo_barra, int rut_id, int rut_orden, String cli_comuna,
                        String cli_region, String cli_fpago, int cli_rapel, String cli_motivo_bloqueo, String cli_fantasia,
                        int lpr_id, int cli_dias_pago, int ban_id, String cli_cuenta_corriente) {

        this.clid_id = clid_id;
        this.cli_rut = cli_rut;
        this.cli_nombre = cli_nombre;
        this.cli_direccion = cli_direccion;
        this.cli_ciudad = cli_ciudad;
        this.cli_nombre_contacto = cli_nombre_contacto;
        this.cli_cargo = cli_cargo;
        this.cli_telefono = cli_telefono;
        this.cli_fax = cli_fax;
        this.cli_celular = cli_celular;
        this.cli_mail = cli_mail;
        this.tcp_id = tcp_id;
        this.cli_fecha_nacimiento = cli_fecha_nacimiento;
        this.cli_activo = cli_activo;
        this.cli_limite_credito = cli_limite_credito;
        this.cli_giro = cli_giro;
        this.cli_sobrecargo = cli_sobrecargo;
        this.cli_credito_ilimitado = cli_credito_ilimitado;
        this.cli_descuento_venta = cli_descuento_venta;
        this.cli_sucursal = cli_sucursal;
        this.clv_codigo_barra = clv_codigo_barra;
        this.rut_id = rut_id;
        this.rut_orden = rut_orden;
        this.cli_comuna = cli_comuna;
        this.cli_region = cli_region;
        this.cli_fpago = cli_fpago;
        this.cli_rapel = cli_rapel;
        this.cli_motivo_bloqueo = cli_motivo_bloqueo;
        this.cli_fantasia = cli_fantasia;
        this.lpr_id = lpr_id;
        this.cli_dias_pago = cli_dias_pago;
        this.ban_id = ban_id;
        this.cli_cuenta_corriente = cli_cuenta_corriente;
    }

    public mae_clientes() {

    }

    public int getClid_id() {
        return clid_id;
    }

    public String getCli_rut() {
        return cli_rut;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public String getCli_ciudad() {
        return cli_ciudad;
    }

    public String getCli_nombre_contacto() {
        return cli_nombre_contacto;
    }

    public String getCli_cargo() {
        return cli_cargo;
    }

    public String getCli_telefono() {
        return cli_telefono;
    }

    public String getCli_fax() {
        return cli_fax;
    }

    public String getCli_celular() {
        return cli_celular;
    }

    public String getCli_mail() {
        return cli_mail;
    }

    public int getTcp_id() {
        return tcp_id;
    }

    public String getCli_fecha_nacimiento() {
        return cli_fecha_nacimiento;
    }

    public int getCli_activo() {
        return cli_activo;
    }

    public int getCli_limite_credito() {
        return cli_limite_credito;
    }

    public String getCli_giro() {
        return cli_giro;
    }

    public int getCli_sobrecargo() {
        return cli_sobrecargo;
    }

    public int getCli_credito_ilimitado() {
        return cli_credito_ilimitado;
    }

    public double getCli_descuento_venta() {
        return cli_descuento_venta;
    }

    public String getCli_sucursal() {
        return cli_sucursal;
    }

    public String getClv_codigo_barra() {
        return clv_codigo_barra;
    }

    public int getRut_id() {
        return rut_id;
    }

    public int getRut_orden() {
        return rut_orden;
    }

    public String getCli_comuna() {
        return cli_comuna;
    }

    public String getCli_region() {
        return cli_region;
    }

    public String getCli_fpago() {
        return cli_fpago;
    }

    public int getCli_rapel() {
        return cli_rapel;
    }

    public String getCli_motivo_bloqueo() {
        return cli_motivo_bloqueo;
    }

    public String getCli_fantasia() {
        return cli_fantasia;
    }

    public int getLpr_id() {
        return lpr_id;
    }

    public int getCli_dias_pago() {
        return cli_dias_pago;
    }

    public int getBan_id() {
        return ban_id;
    }

    public String getCli_cuenta_corriente() {
        return cli_cuenta_corriente;
    }

    public void setClid_id(int clid_id) {
        this.clid_id = clid_id;
    }

    public void setCli_rut(String cli_rut) {
        this.cli_rut = cli_rut;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public void setCli_ciudad(String cli_ciudad) {
        this.cli_ciudad = cli_ciudad;
    }

    public void setCli_nombre_contacto(String cli_nombre_contacto) {
        this.cli_nombre_contacto = cli_nombre_contacto;
    }

    public void setCli_cargo(String cli_cargo) {
        this.cli_cargo = cli_cargo;
    }

    public void setCli_telefono(String cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public void setCli_fax(String cli_fax) {
        this.cli_fax = cli_fax;
    }

    public void setCli_celular(String cli_celular) {
        this.cli_celular = cli_celular;
    }

    public void setCli_mail(String cli_mail) {
        this.cli_mail = cli_mail;
    }

    public void setTcp_id(int tcp_id) {
        this.tcp_id = tcp_id;
    }

    public void setCli_fecha_nacimiento(String cli_fecha_nacimiento) {
        this.cli_fecha_nacimiento = cli_fecha_nacimiento;
    }

    public void setCli_activo(int cli_activo) {
        this.cli_activo = cli_activo;
    }

    public void setCli_limite_credito(int cli_limite_credito) {
        this.cli_limite_credito = cli_limite_credito;
    }

    public void setCli_giro(String cli_giro) {
        this.cli_giro = cli_giro;
    }

    public void setCli_sobrecargo(int cli_sobrecargo) {
        this.cli_sobrecargo = cli_sobrecargo;
    }

    public void setCli_credito_ilimitado(int cli_credito_ilimitado) {
        this.cli_credito_ilimitado = cli_credito_ilimitado;
    }

    public void setCli_descuento_venta(double cli_descuento_venta) {
        this.cli_descuento_venta = cli_descuento_venta;
    }

    public void setCli_sucursal(String cli_sucursal) {
        this.cli_sucursal = cli_sucursal;
    }

    public void setClv_codigo_barra(String clv_codigo_barra) {
        this.clv_codigo_barra = clv_codigo_barra;
    }

    public void setRut_id(int rut_id) {
        this.rut_id = rut_id;
    }

    public void setRut_orden(int rut_orden) {
        this.rut_orden = rut_orden;
    }

    public void setCli_comuna(String cli_comuna) {
        this.cli_comuna = cli_comuna;
    }

    public void setCli_region(String cli_region) {
        this.cli_region = cli_region;
    }

    public void setCli_fpago(String cli_fpago) {
        this.cli_fpago = cli_fpago;
    }

    public void setCli_rapel(int cli_rapel) {
        this.cli_rapel = cli_rapel;
    }

    public void setCli_motivo_bloqueo(String cli_motivo_bloqueo) {
        this.cli_motivo_bloqueo = cli_motivo_bloqueo;
    }

    public void setCli_fantasia(String cli_fantasia) {
        this.cli_fantasia = cli_fantasia;
    }

    public void setLpr_id(int lpr_id) {
        this.lpr_id = lpr_id;
    }

    public void setCli_dias_pago(int cli_dias_pago) {
        this.cli_dias_pago = cli_dias_pago;
    }

    public void setBan_id(int ban_id) {
        this.ban_id = ban_id;
    }

    public void setCli_cuenta_corriente(String cli_cuenta_corriente) {
        this.cli_cuenta_corriente = cli_cuenta_corriente;
    }
}
