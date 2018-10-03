package cl.helpcom.pyxismobile.Clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {


    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS mae_clientes" +
                "(cli_id int primary key not null,cli_rut varchar(12),cli_nombre varchar(150)," +
                "cli_direccion varchar(150),cli_ciudad varchar(50),cli_nombre_contacto varchar(150),cli_cargo varcahr(150)," +
                "cli_telefono varchar(14),cli_fax varchar(14),cli_celular varchar(14),cli_mail varchar(50),tcp_id int(1)," +
                "cli_fecha_nacimiento date,cli_activo int(1) default(1) ,cli_limite_credito int(1) default(0)," +
                "cli_giro varchar(150) default(''),cli_sobrecargo int(1) default(0),cli_credito_ilimitado int(1) default(1)," +
                "cli_descuento_venta double,cli_sucursal varchar(150) default(''),clv_codigo_barra varchar(15) default('')," +
                "rut_id int(11) default(0),rut_orden tinyint(4) default(0),cli_comuna varchar(45),cli_region varchar(45) default(''),cli_fpago varchar(45) " +
                "default('CONTADO'),cli_rapel int(10) default(0),cli_motivo_bloqueo varchar(200) default('')," +
                "cli_fantasia varchar(50) default(''),lpr_id int(10) default(0),cli_dias_pago int(5) default(0),ban_id int(10) default(0)," +
                "cli_cuenta_corriente varchar(40) default('') )");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS mae_usuarios " +
                "(usu_nusuario varchar(15) default(''), usu_password varchar(15) default(''),usu_nombre varchar(50)," +
                "per_id int(10),car_id int(10),sec_id int(10),usu_activo int(1),ven_id int(10),usu_su char(2) default('NO')," +
                "usu_telefono varchar(20) default(''))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS nve_nota_venta" +
                "(nve_id int(10) default(0) primary key not null,wst_id int(10) default(0),nve_fecha date default(0000-00-00)," +
                "nve_hora varchar(8) default(''),ven_id int(10) default(0),cli_id int(10) default(0),nve_estado char(2) default('')," +
                "nve_total double default(0),nve_enviado char(2) default('NO'),nve_observacion text,nve_dia varchar(9) default('LUNES'))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS nve_nota_venta_mov" +
                "(nvm_id int(10) primary key not null,nve_id int(10)default(0),pro_codigo_plu int(10) default(0),pro_descripcion varchar(100)" +
                "default(''),pro_stock double default(0),nvm_plista int(10) default(0),nvm_cantidad double default(0),nvm_descuento double" +
                " default(0),nvm_total double default(0),wst_id int(10) default(0))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS nve_workstation" +
                "(nvw_id int(11) primary key not null,nvw_nombre_equipo varchar(50) default(''),nvw_nombre_usuario varchar(50) " +
                "default(''),nvw_fecha date default(0000-00-00), nvw_hora varchar(8) default(''))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS mae_productos" +
                "(pro_codigo_plu int(10) default(0) primary key not null,pro_codigo_barra varchar(18) default('')," +
                "pro_tipo int(1) default(1),pro_nombre_producto varchar(80),pro_nombre_corto varchar(30),med_id int(10),emb_id int(10)," +
                "pro_unidades_embalaje int(10),dep_id int(10),lin_id int(10),pro_precio_compra_neto double,pro_precio_compra_bruto double," +
                "pro_precio_compra_oferta double,pro_precio_venta int(10),pro_margen_actual double,pro_oferta char(2) default('NO')," +
                "pro_fecha_inicio_oferta date default(000-00-00),pro_fecha_termino_oferta date default(0000-00-00),pro_precio_oferta double," +
                "pro_stock_minimo int(10),pro_stock_critico int(10),pro_entradas_bodega double,pro_salidas_bodega double,pro_mermas_bodega double," +
                "pro_ajustes_bodega double,pro_entradas_sv double,pro_salidas_sv double,pro_mermas_sv double,pro_ajustes_sv double,pro_activo int(1)," +
                "pro_ultima_compra date default(0000-00-00),pro_ultimo_proveedor varchar(30),rec_numero int(10),pro_estado int(1),pro_unidad int(1)," +
                "pro_consumo_bodega double,pro_consumo_sv double,mar_id int(10),pro_capacidad double,pro_funcion_plu int(1),pro_iva int(1)," +
                "pro_flejes int(1),pro_ultima_venta date default(0000-00-00),pro_precio_fiscal int(10) default(0),pro_plu_asociado int(10) " +
                "default(0),pro_envase char(2) default('NO'),pro_duracion int(10),pro_numero_etiqueta int(10),prv_id int(10) default(0)," +
                "pro_reservado_sv int(11) default(0),pro_descto_general double default(0),pro_descto_rapel double default(0))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS mae_lista_precios" +
                "(lpr_id int(10) default(0) primary key not  null,lpr_nombre varchar(45) default('') not null)");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS mae_lista_precios_mov" +
                "(lpm_id int(10) primary key not null,lpr_id int(10) default(0),pro_codigo_plu int(11) default(0),lpm_precio int(10)" +
                " default(0))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS sys_parametros" +
                "(par_id int(10) primary key not null,par_nombre varchar(60) default(''),par_valor varchar(60) default('')," +
                "par_activo char(2) default('SI'),par_descripcion text default(''))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS sys_perfiles" +
                "(per_id int(10) default(0) primary key not null,per_nombre varchar(45) default(''),per_activo char(2) default('SI'))");

        baseDeDatos.execSQL("CREATE TABLE IF NOT EXISTS sys_usuarios" +
                "(usu_login varchar(20) default('') primary key not null,usu_password varchar(20) default(''),usu_nombre varchar(45) " +
                "default(''),per_id int(10) default(0),usu_activo char(2) default('SI'))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mae_clientes");
        db.execSQL("DROP TABLE IF EXISTS mae_usuarios");
        db.execSQL("DROP TABLE IF EXISTS nve_nota_venta");
        db.execSQL("DROP TABLE IF EXISTS nve_nota_venta_mov");
        db.execSQL("DROP TABLE IF EXISTS nve_workstation");
        db.execSQL("DROP TABLE IF EXISTS mae_productos");
        db.execSQL("DROP TABLE IF EXISTS mae_lista_precios");
        db.execSQL("DROP TABLE IF EXISTS mae_lista_precios_mov");
        db.execSQL("DROP TABLE IF EXISTS sys_parametros");
        db.execSQL("DROP TABLE IF EXISTS sys_perfiles");
        db.execSQL("DROP TABLE IF EXISTS sys_usuarios");

        onCreate(db);

    }
}
