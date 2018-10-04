package cl.helpcom.pyxismobile;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cl.helpcom.pyxismobile.Clases.DB;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        try{
           // DB admin = new DB(this,"db_nota_venta_daos",null,1);
           /// SQLiteDatabase database=admin.getWritableDatabase();

           // String sql="INSERT INTO mae_usuarios(usu_nusuario,usu_password,usu_nombre,per_id,car_id,sec_id,usu_activo,ven_id,usu_su,usu_telefono) VALUES ('aespinoza','13888','AGUSTIN ESPINOZA AGUILA',8,8,1,0,96,'NO','')";
           // database.execSQL(sql);

           // sql="INSERT INTO mae_usuarios(usu_nusuario,usu_password,usu_nombre,per_id,car_id,sec_id,usu_activo,ven_id,usu_su,usu_telefono) \n" +
           ///         "VALUES('helpcom','helpcom211','HELPCOM LTDA',1,0,0,0,21,'NO','')";

           // database.execSQL(sql);

            /*sql="INSERT  INTO mae_clientes(cli_id,cli_rut,cli_nombre,cli_direccion,cli_ciudad,cli_nombre_contacto,cli_cargo,cli_telefono,cli_fax,cli_celular,cli_mail,tcp_id,cli_fecha_nacimiento,cli_activo,cli_limite_credito,cli_giro,cli_sobrecargo,cli_credito_ilimitado,cli_descuento_venta,cli_sucursal,clv_codigo_barra,rut_id,rut_orden,cli_comuna,cli_region,cli_fpago,cli_rapel,cli_motivo_bloqueo,cli_fantasia,lpr_id,cli_dias_pago,ban_id,cli_cuenta_corriente) VALUES \n" +
                    "(0,'14563585-3','ALBA IRIS CALBUCOY ZANTANA','ZERRANO 064','ACHAO','','','','','68103772','',3,'2013-12-14',1,500000,'PAQUETERIA',0,0,0,'','',0,0,'ACHAO','','SOLO CONTADO',0,'','',0,0,0,''),\n" +
                    "(1,'85017900-K','AGRIC. COM. Y FORESTAL VELASQUEZ HERMANOS LIMITADA','M.MONTT 1222','TOME','','','','','','',1,'1900-01-01',1,500000,'SUPERMERCADO',0,0,0,'TOME','',0,0,'TOME','','SOLO CONTADO',0,'','',0,0,0,''),\n" +
                    "(2,'7899051-1','ABDON TORRES IBARRA','LOS COLONOS ESQ. D. PORTALES S/N','HORNIPIREN','','','84724633','','','',1,'1900-01-01',1,500000,'FERRETERIA',0,0,0,'HORNIPIREN','',0,0,'HORNIPIREN','','SOLO CONTADO',0,'','',0,0,0,''),\n" +
                    "(3,'14521304-5','ABIGAIL PATIÐO ORTEGA','2 ORIENTE 42 FRENTE BOMBEROS','LANCO','','','','','','',1,'1900-01-01',1,500000,'PROVISIONES',0,0,0,'LANCO','',0,0,'LANCO','','SOLO CONTADO',0,'','',0,0,0,''),\n" +
                    "(4,'11587311-3','ABRAHAM DEL PINO CARRASCO','SAN MATEO 0349','PITRUFQUEN','','','','','','',1,'1970-01-01',1,500000,'PROVISIONES',0,0,0,'PITRUFQUEN','',0,0,'PITRUFQUEN','','SOLO CONTADO',0,'','',36,0,0,''),\n" +
                    "(5,'5281120-1','ABRAHAM GAJARDO SARAVIA','PALGUIN 598','PUCON','','','444762','','','',1,'1900-01-01',1,500000,'PROVISIONES',0,0,0,'PUCON','',0,0,'PUCON','','SOLO CONTADO',0,'','',0,0,0,'')";


            database.execSQL(sql);
            */
            //database.close();
        }catch ( Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
            Toast.makeText(this, ""+e.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(this, ""+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inte=new Intent(Splash.this,Login.class);
                startActivity(inte);
                finish();
            }
        },2000);
    }
}
