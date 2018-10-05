package cl.helpcom.pyxismobile.Clases.Entidades;

import java.io.Serializable;

public class mae_productos implements Serializable {

    private int pro_codigo_plu;
    private String pro_codigo_barra;
    private int pro_tipo;
    private String pro_nombre_producto;
    private String pro_nombre_corto;
    private int med_id;
    private int emd_id;
    private int pro_unidades_embalaje;
    private int dep_id;
    private int lin_id;
    private double pro_precio_compra_neto;
    private double pro_precio_compr_bruto;
    private double pro_precio_compra_oferta;
    private int pro_precio_venta;
    private double pro_margen_actual;
    private String pro_oferta;
    private String pro_fecha_inicio_oferta;
    private String pro_fecha_termino_oferta;
    private int pro_precio_oferta;
    private int pro_stock_minimo;
    private int pro_stock_critico;
    private double pro_entradas_bodega;
    private double pro_salidas_bodega;
    private double pro_mermas_bodega;
    private double pro_ajuste__bodega;
    private double pro_entradas_sv;
    private double pro_salidas_sv;
    private double pro_mermas_sv;
    private double pro_ajuste_sv;
    private int pro_activo;
    private String pro_ultima_compra;
    private String pro_ultimo_proveedor;
    private int rec_numero;
    private int pro_estado;
    private int pro_unidad;
    private double pro_consumo_bodega;
    private double pro_consumo_sv;
    private int mar_id;
    private double pro_capacidad;
    private int pro_funcion_plu;
    private int pro_iva;
    private int pro_flejes;
    private String pro_ultima_venta;
    private int pro_precio_fiscal;
    private int pro_plu_asociado;
    private String pro_envase;
    private int pro_duracion;
    private int pro_numero_etiqueta;
    private int prv_id;
    private int pro_reservado_sv;
    private double pro_descto_general;
    private double pro_descto_rapel;
    private String pro_observacion;
    private String pro_posicion;
    private String pro_ubicacion;
    private double pro_peso;
    private double pro_volumen;
    private String pro_proveedor_primario;
    private String pro_proveedor_rut;


    public mae_productos(int pro_codigo_plu, String pro_codigo_barra, int pro_tipo, String pro_nombre_producto, String pro_nombre_corto, int med_id, int emd_id, int pro_unidades_embalaje,
                         int dep_id, int lin_id, double pro_precio_compra_neto, double pro_precio_compr_bruto, double pro_precio_compra_oferta, int pro_precio_venta,
                         double pro_margen_actual, String pro_oferta, String pro_fecha_inicio_oferta, String pro_fecha_termino_oferta, int pro_precio_oferta, int pro_stock_minimo,
                         int pro_stock_critico, double pro_entradas_bodega, double pro_salidas_bodega, double pro_mermas_bodega, double pro_ajuste__bodega, double pro_entradas_sv,
                         double pro_salidas_sv, double pro_mermas_sv, double pro_ajuste_sv, int pro_activo, String pro_ultima_compra, String pro_ultimo_proveedor, int rec_numero,
                         int pro_estado, int pro_unidad, double pro_consumo_bodega, double pro_consumo_sv, int mar_id, double pro_capacidad, int pro_funcion_plu, int pro_iva,
                         int pro_flejes, String pro_ultima_venta, int pro_precio_fiscal, int pro_plu_asociado, String pro_envase, int pro_duracion, int pro_numero_etiqueta,
                         int prv_id, int pro_reservado_sv, double pro_descto_general, double pro_descto_rapel, String pro_observacion, String pro_posicion, String pro_ubicacion,
                         double pro_peso, double pro_volumen, String pro_proveedor_primario, String pro_proveedor_rut) {

        this.pro_codigo_plu = pro_codigo_plu;
        this.pro_codigo_barra = pro_codigo_barra;
        this.pro_tipo = pro_tipo;
        this.pro_nombre_producto = pro_nombre_producto;
        this.pro_nombre_corto = pro_nombre_corto;
        this.med_id = med_id;
        this.emd_id = emd_id;
        this.pro_unidades_embalaje = pro_unidades_embalaje;
        this.dep_id = dep_id;
        this.lin_id = lin_id;
        this.pro_precio_compra_neto = pro_precio_compra_neto;
        this.pro_precio_compr_bruto = pro_precio_compr_bruto;
        this.pro_precio_compra_oferta = pro_precio_compra_oferta;
        this.pro_precio_venta = pro_precio_venta;
        this.pro_margen_actual = pro_margen_actual;
        this.pro_oferta = pro_oferta;
        this.pro_fecha_inicio_oferta = pro_fecha_inicio_oferta;
        this.pro_fecha_termino_oferta = pro_fecha_termino_oferta;
        this.pro_precio_oferta = pro_precio_oferta;
        this.pro_stock_minimo = pro_stock_minimo;
        this.pro_stock_critico = pro_stock_critico;
        this.pro_entradas_bodega = pro_entradas_bodega;
        this.pro_salidas_bodega = pro_salidas_bodega;
        this.pro_mermas_bodega = pro_mermas_bodega;
        this.pro_ajuste__bodega = pro_ajuste__bodega;
        this.pro_entradas_sv = pro_entradas_sv;
        this.pro_salidas_sv = pro_salidas_sv;
        this.pro_mermas_sv = pro_mermas_sv;
        this.pro_ajuste_sv = pro_ajuste_sv;
        this.pro_activo = pro_activo;
        this.pro_ultima_compra = pro_ultima_compra;
        this.pro_ultimo_proveedor = pro_ultimo_proveedor;
        this.rec_numero = rec_numero;
        this.pro_estado = pro_estado;
        this.pro_unidad = pro_unidad;
        this.pro_consumo_bodega = pro_consumo_bodega;
        this.pro_consumo_sv = pro_consumo_sv;
        this.mar_id = mar_id;
        this.pro_capacidad = pro_capacidad;
        this.pro_funcion_plu = pro_funcion_plu;
        this.pro_iva = pro_iva;
        this.pro_flejes = pro_flejes;
        this.pro_ultima_venta = pro_ultima_venta;
        this.pro_precio_fiscal = pro_precio_fiscal;
        this.pro_plu_asociado = pro_plu_asociado;
        this.pro_envase = pro_envase;
        this.pro_duracion = pro_duracion;
        this.pro_numero_etiqueta = pro_numero_etiqueta;
        this.prv_id = prv_id;
        this.pro_reservado_sv = pro_reservado_sv;
        this.pro_descto_general = pro_descto_general;
        this.pro_descto_rapel = pro_descto_rapel;
        this.pro_observacion = pro_observacion;
        this.pro_posicion = pro_posicion;
        this.pro_ubicacion = pro_ubicacion;
        this.pro_peso = pro_peso;
        this.pro_volumen = pro_volumen;
        this.pro_proveedor_primario = pro_proveedor_primario;
        this.pro_proveedor_rut = pro_proveedor_rut;
    }


    public mae_productos() {

    }

    public int getPro_codigo_plu() {
        return pro_codigo_plu;
    }

    public String getPro_codigo_barra() {
        return pro_codigo_barra;
    }

    public int getPro_tipo() {
        return pro_tipo;
    }

    public String getPro_nombre_producto() {
        return pro_nombre_producto;
    }

    public String getPro_nombre_corto() {
        return pro_nombre_corto;
    }

    public int getMed_id() {
        return med_id;
    }

    public int getEmd_id() {
        return emd_id;
    }

    public int getPro_unidades_embalaje() {
        return pro_unidades_embalaje;
    }

    public int getDep_id() {
        return dep_id;
    }

    public int getLin_id() {
        return lin_id;
    }

    public double getPro_precio_compra_neto() {
        return pro_precio_compra_neto;
    }

    public double getPro_precio_compr_bruto() {
        return pro_precio_compr_bruto;
    }

    public double getPro_precio_compra_oferta() {
        return pro_precio_compra_oferta;
    }

    public int getPro_precio_venta() {
        return pro_precio_venta;
    }

    public double getPro_margen_actual() {
        return pro_margen_actual;
    }

    public String getPro_oferta() {
        return pro_oferta;
    }

    public String getPro_fecha_inicio_oferta() {
        return pro_fecha_inicio_oferta;
    }

    public String getPro_fecha_termino_oferta() {
        return pro_fecha_termino_oferta;
    }

    public int getPro_precio_oferta() {
        return pro_precio_oferta;
    }

    public int getPro_stock_minimo() {
        return pro_stock_minimo;
    }

    public int getPro_stock_critico() {
        return pro_stock_critico;
    }

    public double getPro_entradas_bodega() {
        return pro_entradas_bodega;
    }

    public double getPro_salidas_bodega() {
        return pro_salidas_bodega;
    }

    public double getPro_mermas_bodega() {
        return pro_mermas_bodega;
    }

    public double getPro_ajuste__bodega() {
        return pro_ajuste__bodega;
    }

    public double getPro_entradas_sv() {
        return pro_entradas_sv;
    }

    public double getPro_salidas_sv() {
        return pro_salidas_sv;
    }

    public double getPro_mermas_sv() {
        return pro_mermas_sv;
    }

    public double getPro_ajuste_sv() {
        return pro_ajuste_sv;
    }

    public int getPro_activo() {
        return pro_activo;
    }

    public String getPro_ultima_compra() {
        return pro_ultima_compra;
    }

    public String getPro_ultimo_proveedor() {
        return pro_ultimo_proveedor;
    }

    public int getRec_numero() {
        return rec_numero;
    }

    public int getPro_estado() {
        return pro_estado;
    }

    public int getPro_unidad() {
        return pro_unidad;
    }

    public double getPro_consumo_bodega() {
        return pro_consumo_bodega;
    }

    public double getPro_consumo_sv() {
        return pro_consumo_sv;
    }

    public int getMar_id() {
        return mar_id;
    }

    public double getPro_capacidad() {
        return pro_capacidad;
    }

    public int getPro_funcion_plu() {
        return pro_funcion_plu;
    }

    public int getPro_iva() {
        return pro_iva;
    }

    public int getPro_flejes() {
        return pro_flejes;
    }

    public String getPro_ultima_venta() {
        return pro_ultima_venta;
    }

    public int getPro_precio_fiscal() {
        return pro_precio_fiscal;
    }

    public int getPro_plu_asociado() {
        return pro_plu_asociado;
    }

    public String getPro_envase() {
        return pro_envase;
    }

    public int getPro_duracion() {
        return pro_duracion;
    }

    public int getPro_numero_etiqueta() {
        return pro_numero_etiqueta;
    }

    public int getPrv_id() {
        return prv_id;
    }

    public int getPro_reservado_sv() {
        return pro_reservado_sv;
    }

    public double getPro_descto_general() {
        return pro_descto_general;
    }

    public double getPro_descto_rapel() {
        return pro_descto_rapel;
    }

    public String getPro_observacion() {
        return pro_observacion;
    }

    public String getPro_posicion() {
        return pro_posicion;
    }

    public String getPro_ubicacion() {
        return pro_ubicacion;
    }

    public double getPro_peso() {
        return pro_peso;
    }

    public double getPro_volumen() {
        return pro_volumen;
    }

    public String getPro_proveedor_primario() {
        return pro_proveedor_primario;
    }

    public String getPro_proveedor_rut() {
        return pro_proveedor_rut;
    }


    public void setPro_codigo_plu(int pro_codigo_plu) {
        this.pro_codigo_plu = pro_codigo_plu;
    }

    public void setPro_codigo_barra(String pro_codigo_barra) {
        this.pro_codigo_barra = pro_codigo_barra;
    }

    public void setPro_tipo(int pro_tipo) {
        this.pro_tipo = pro_tipo;
    }

    public void setPro_nombre_producto(String pro_nombre_producto) {
        this.pro_nombre_producto = pro_nombre_producto;
    }

    public void setPro_nombre_corto(String pro_nombre_corto) {
        this.pro_nombre_corto = pro_nombre_corto;
    }

    public void setMed_id(int med_id) {
        this.med_id = med_id;
    }

    public void setEmd_id(int emd_id) {
        this.emd_id = emd_id;
    }

    public void setPro_unidades_embalaje(int pro_unidades_embalaje) {
        this.pro_unidades_embalaje = pro_unidades_embalaje;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public void setLin_id(int lin_id) {
        this.lin_id = lin_id;
    }

    public void setPro_precio_compra_neto(double pro_precio_compra_neto) {
        this.pro_precio_compra_neto = pro_precio_compra_neto;
    }

    public void setPro_precio_compr_bruto(double pro_precio_compr_bruto) {
        this.pro_precio_compr_bruto = pro_precio_compr_bruto;
    }

    public void setPro_precio_compra_oferta(double pro_precio_compra_oferta) {
        this.pro_precio_compra_oferta = pro_precio_compra_oferta;
    }

    public void setPro_precio_venta(int pro_precio_venta) {
        this.pro_precio_venta = pro_precio_venta;
    }

    public void setPro_margen_actual(double pro_margen_actual) {
        this.pro_margen_actual = pro_margen_actual;
    }

    public void setPro_oferta(String pro_oferta) {
        this.pro_oferta = pro_oferta;
    }

    public void setPro_fecha_inicio_oferta(String pro_fecha_inicio_oferta) {
        this.pro_fecha_inicio_oferta = pro_fecha_inicio_oferta;
    }

    public void setPro_fecha_termino_oferta(String pro_fecha_termino_oferta) {
        this.pro_fecha_termino_oferta = pro_fecha_termino_oferta;
    }

    public void setPro_precio_oferta(int pro_precio_oferta) {
        this.pro_precio_oferta = pro_precio_oferta;
    }

    public void setPro_stock_minimo(int pro_stock_minimo) {
        this.pro_stock_minimo = pro_stock_minimo;
    }

    public void setPro_stock_critico(int pro_stock_critico) {
        this.pro_stock_critico = pro_stock_critico;
    }

    public void setPro_entradas_bodega(double pro_entradas_bodega) {
        this.pro_entradas_bodega = pro_entradas_bodega;
    }

    public void setPro_salidas_bodega(double pro_salidas_bodega) {
        this.pro_salidas_bodega = pro_salidas_bodega;
    }

    public void setPro_mermas_bodega(double pro_mermas_bodega) {
        this.pro_mermas_bodega = pro_mermas_bodega;
    }

    public void setPro_ajuste__bodega(double pro_ajuste__bodega) {
        this.pro_ajuste__bodega = pro_ajuste__bodega;
    }

    public void setPro_entradas_sv(double pro_entradas_sv) {
        this.pro_entradas_sv = pro_entradas_sv;
    }

    public void setPro_salidas_sv(double pro_salidas_sv) {
        this.pro_salidas_sv = pro_salidas_sv;
    }

    public void setPro_mermas_sv(double pro_mermas_sv) {
        this.pro_mermas_sv = pro_mermas_sv;
    }

    public void setPro_ajuste_sv(double pro_ajuste_sv) {
        this.pro_ajuste_sv = pro_ajuste_sv;
    }

    public void setPro_activo(int pro_activo) {
        this.pro_activo = pro_activo;
    }

    public void setPro_ultima_compra(String pro_ultima_compra) {
        this.pro_ultima_compra = pro_ultima_compra;
    }

    public void setPro_ultimo_proveedor(String pro_ultimo_proveedor) {
        this.pro_ultimo_proveedor = pro_ultimo_proveedor;
    }

    public void setRec_numero(int rec_numero) {
        this.rec_numero = rec_numero;
    }

    public void setPro_estado(int pro_estado) {
        this.pro_estado = pro_estado;
    }

    public void setPro_unidad(int pro_unidad) {
        this.pro_unidad = pro_unidad;
    }

    public void setPro_consumo_bodega(double pro_consumo_bodega) {
        this.pro_consumo_bodega = pro_consumo_bodega;
    }

    public void setPro_consumo_sv(double pro_consumo_sv) {
        this.pro_consumo_sv = pro_consumo_sv;
    }

    public void setMar_id(int mar_id) {
        this.mar_id = mar_id;
    }

    public void setPro_capacidad(double pro_capacidad) {
        this.pro_capacidad = pro_capacidad;
    }

    public void setPro_funcion_plu(int pro_funcion_plu) {
        this.pro_funcion_plu = pro_funcion_plu;
    }

    public void setPro_iva(int pro_iva) {
        this.pro_iva = pro_iva;
    }

    public void setPro_flejes(int pro_flejes) {
        this.pro_flejes = pro_flejes;
    }

    public void setPro_ultima_venta(String pro_ultima_venta) {
        this.pro_ultima_venta = pro_ultima_venta;
    }

    public void setPro_precio_fiscal(int pro_precio_fiscal) {
        this.pro_precio_fiscal = pro_precio_fiscal;
    }

    public void setPro_plu_asociado(int pro_plu_asociado) {
        this.pro_plu_asociado = pro_plu_asociado;
    }

    public void setPro_envase(String pro_envase) {
        this.pro_envase = pro_envase;
    }

    public void setPro_duracion(int pro_duracion) {
        this.pro_duracion = pro_duracion;
    }

    public void setPro_numero_etiqueta(int pro_numero_etiqueta) {
        this.pro_numero_etiqueta = pro_numero_etiqueta;
    }

    public void setPrv_id(int prv_id) {
        this.prv_id = prv_id;
    }

    public void setPro_reservado_sv(int pro_reservado_sv) {
        this.pro_reservado_sv = pro_reservado_sv;
    }

    public void setPro_descto_general(double pro_descto_general) {
        this.pro_descto_general = pro_descto_general;
    }

    public void setPro_descto_rapel(double pro_descto_rapel) {
        this.pro_descto_rapel = pro_descto_rapel;
    }

    public void setPro_observacion(String pro_observacion) {
        this.pro_observacion = pro_observacion;
    }

    public void setPro_posicion(String pro_posicion) {
        this.pro_posicion = pro_posicion;
    }

    public void setPro_ubicacion(String pro_ubicacion) {
        this.pro_ubicacion = pro_ubicacion;
    }

    public void setPro_peso(double pro_peso) {
        this.pro_peso = pro_peso;
    }

    public void setPro_volumen(double pro_volumen) {
        this.pro_volumen = pro_volumen;
    }

    public void setPro_proveedor_primario(String pro_proveedor_primario) {
        this.pro_proveedor_primario = pro_proveedor_primario;
    }

    public void setPro_proveedor_rut(String pro_proveedor_rut) {
        this.pro_proveedor_rut = pro_proveedor_rut;
    }
}
