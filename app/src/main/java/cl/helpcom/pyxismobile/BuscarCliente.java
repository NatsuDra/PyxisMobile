package cl.helpcom.pyxismobile;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cl.helpcom.pyxismobile.Clases.DB;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_clientes;

public class BuscarCliente extends AppCompatActivity {

    ListView listClientes;
    ArrayList<String> listainformacion;
    ArrayList<mae_clientes> listaClientes;
    DB conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cliente);

        conn = new DB(getApplicationContext(),"db_nota_venta_daos",null,1);
        listClientes= (ListView) findViewById(R.id.listViewClientes);

        consultarListaClientes();
        ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listainformacion);
        listClientes.setAdapter(adapter);

    }

    public void consultarListaClientes(){

        mae_clientes cliente= null;
        listaClientes= new ArrayList<mae_clientes>();

        SQLiteDatabase database= conn.getWritableDatabase();

        String sql="SELECT * FROM mae_clientes where cli_activo=1";

        Cursor registros= database.rawQuery(sql,null);
        registros.moveToNext();

        while (registros.moveToNext()){
            cliente= new mae_clientes(Integer.parseInt(registros.getString(0)),registros.getString(1),
                    registros.getString(2),registros.getString(3),registros.getString(4),
                    registros.getString(5),registros.getString(6),registros.getString(7),
                    registros.getString(8),registros.getString(9),registros.getString(10),
                    Integer.parseInt(registros.getString(11)), registros.getString(12),
                    Integer.parseInt(registros.getString(13)),Integer.parseInt(registros.getString(14)),
                    registros.getString(15),Integer.parseInt(registros.getString(16)),
                    Integer.parseInt(registros.getString(17)),Double.parseDouble(registros.getString(18)),
                    registros.getString(19),registros.getString(20),Integer.parseInt(registros.getString(21)),
                    Integer.parseInt(registros.getString(22)),registros.getString(23),registros.getString(24),
                    registros.getString(25),Integer.parseInt(registros.getString(26)),registros.getString(27),
                    registros.getString(28),Integer.parseInt(registros.getString(29)),Integer.parseInt(registros.getString(30)),
                    Integer.parseInt(registros.getString(31)),registros.getString(32));
            listaClientes.add(cliente);
        }

        mostrarLista();
        conn.close();
        database.close();
    }

    private void mostrarLista() {

        for (int i=0;i<listaClientes.size();i++){

            listainformacion.add("Nombre: "+listaClientes.get(i).getCli_nombre()+ " | Rut: "+listaClientes.get(i).getCli_rut());

        }
    }
}
