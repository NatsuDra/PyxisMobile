package cl.helpcom.pyxismobile;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cl.helpcom.pyxismobile.Clases.DB;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_productos;


public class BuscarProducto extends AppCompatActivity {

    ListView listProductos;
    ArrayList<String> listainformacionProductos;
    ArrayList<mae_productos> listaProductos;
    DB conn;

    EditText txtBuscadorProducto;
    Button btnFiltroProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto);


        conn = new DB(getApplicationContext());
        listProductos= (ListView) findViewById(R.id.listViewProductos);

        consultarListaProductos();


        listProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //CrearNVFragment.txtproducto.setText(""+listaClientes.get(position).getCli_nombre());
                //CrearNVFragment.cliente=listaproducto.get(position);
                Toast.makeText(BuscarProducto.this, "Codigo barra: "+listaProductos.get(position).getPro_codigo_barra(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        txtBuscadorProducto=(EditText) findViewById(R.id.txtBuscarProductoActivity);
        btnFiltroProducto=(Button) findViewById(R.id.btnBuscarProductoActivity);

        btnFiltroProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar(txtBuscadorProducto.getText().toString());
            }
        });


    }


    private void filtrar(String texto) {
        mae_productos producto= null;
        listaProductos= new ArrayList<mae_productos>();
        String sql="";

        SQLiteDatabase database= conn.getWritableDatabase();
        if(texto!=""){
            sql="SELECT * FROM mae_productos where pro_activo=1 and pro_nombre_producto like '%"+texto+"%'";
        }else{
            sql="SELECT * FROM mae_productos where pro_activo=1";
        }


        Cursor registros= database.rawQuery(sql,null);

        while (registros.moveToNext()){
            producto = new mae_productos(Integer.parseInt(registros.getString(0)),registros.getString(1),Integer.parseInt(registros.getString(2)),
                    registros.getString(3),registros.getString(4),Integer.parseInt(registros.getString(5)),Integer.parseInt(registros.getString(6)),
                    Integer.parseInt(registros.getString(7)),Integer.parseInt(registros.getString(8)),Integer.parseInt(registros.getString(9)),
                    Double.parseDouble(registros.getString(10)),Double.parseDouble(registros.getString(11)),Double.parseDouble(registros.getString(12)),
                    Integer.parseInt(registros.getString(13)),Double.parseDouble(registros.getString(14)),registros.getString(15),registros.getString(16),
                    registros.getString(17),Integer.parseInt(registros.getString(18)),Integer.parseInt(registros.getString(19)),Integer.parseInt(registros.getString(20)),
                    Double.parseDouble(registros.getString(21)),Double.parseDouble(registros.getString(22)),Double.parseDouble(registros.getString(23)),
                    Double.parseDouble(registros.getString(24)),Double.parseDouble(registros.getString(25)),Double.parseDouble(registros.getString(26)),
                    Double.parseDouble(registros.getString(27)),Double.parseDouble(registros.getString(28)),Integer.parseInt(registros.getString(29)),
                    registros.getString(30),registros.getString(31),Integer.parseInt(registros.getString(32)),Integer.parseInt(registros.getString(33)),
                    Integer.parseInt(registros.getString(34)),Double.parseDouble(registros.getString(35)),Double.parseDouble(registros.getString(36)),
                    Integer.parseInt(registros.getString(37)),Double.parseDouble(registros.getString(38)),Integer.parseInt(registros.getString(39)),
                    Integer.parseInt(registros.getString(40)),Integer.parseInt(registros.getString(41)),registros.getString(42),Integer.parseInt(registros.getString(43)),
                    Integer.parseInt(registros.getString(44)),registros.getString(45),Integer.parseInt(registros.getString(46)),Integer.parseInt(registros.getString(47)),
                    Integer.parseInt(registros.getString(48)),Integer.parseInt(registros.getString(49)),Double.parseDouble(registros.getString(50)),Double.parseDouble(registros.getString(51)),
                    registros.getString(52),registros.getString(53),registros.getString(54),Double.parseDouble(registros.getString(55)),
                    Double.parseDouble(registros.getString(56)),registros.getString(57),registros.getString(58));
            listaProductos.add(producto);
        }

        listainformacionProductos = new ArrayList<String>();
        for (int i=0;i<listaProductos.size();i++){

            listainformacionProductos.add("PLU: "+listaProductos.get(i).getPro_codigo_plu()+ " | Nombre: "+listaProductos.get(i).getPro_nombre_producto());

        }
        conn.close();
        database.close();

        ArrayAdapter adapter= new ArrayAdapter(this,R.layout.list_item_productos,listainformacionProductos);
        listProductos.setAdapter(adapter);
    }

    public void consultarListaProductos()
    {

        mae_productos producto= null;
        listaProductos= new ArrayList<mae_productos>();
        String sql="";

        SQLiteDatabase database= conn.getWritableDatabase();

        sql="SELECT * FROM mae_productos where pro_activo=1";


        Cursor registros= database.rawQuery(sql,null);

        try {
            while (registros.moveToNext()) {
                producto = new mae_productos(Integer.parseInt(registros.getString(0)), registros.getString(1), Integer.parseInt(registros.getString(2)),
                        registros.getString(3), registros.getString(4), Integer.parseInt(registros.getString(5)), Integer.parseInt(registros.getString(6)),
                        Integer.parseInt(registros.getString(7)), Integer.parseInt(registros.getString(8)), Integer.parseInt(registros.getString(9)),
                        Double.parseDouble(registros.getString(10)), Double.parseDouble(registros.getString(11)), Double.parseDouble(registros.getString(12)),
                        Integer.parseInt(registros.getString(13)), Double.parseDouble(registros.getString(14)), registros.getString(15), registros.getString(16),
                        registros.getString(17), Integer.parseInt(registros.getString(18)), Integer.parseInt(registros.getString(19)), Integer.parseInt(registros.getString(20)),
                        Double.parseDouble(registros.getString(21)), Double.parseDouble(registros.getString(22)), Double.parseDouble(registros.getString(23)),
                        Double.parseDouble(registros.getString(24)), Double.parseDouble(registros.getString(25)), Double.parseDouble(registros.getString(26)),
                        Double.parseDouble(registros.getString(27)), Double.parseDouble(registros.getString(28)), Integer.parseInt(registros.getString(29)),
                        registros.getString(30), registros.getString(31), Integer.parseInt(registros.getString(32)), Integer.parseInt(registros.getString(33)),
                        Integer.parseInt(registros.getString(34)), Double.parseDouble(registros.getString(35)), Double.parseDouble(registros.getString(36)),
                        Integer.parseInt(registros.getString(37)), Double.parseDouble(registros.getString(38)), Integer.parseInt(registros.getString(39)),
                        Integer.parseInt(registros.getString(40)), Integer.parseInt(registros.getString(41)), registros.getString(42), Integer.parseInt(registros.getString(43)),
                        Integer.parseInt(registros.getString(44)), registros.getString(45), Integer.parseInt(registros.getString(46)), Integer.parseInt(registros.getString(47)),
                        Integer.parseInt(registros.getString(48)), Integer.parseInt(registros.getString(49)), Double.parseDouble(registros.getString(50)),Double.parseDouble(registros.getString(51)),
                        registros.getString(52),
                        registros.getString(53),
                        registros.getString(54),
                        Double.parseDouble(registros.getString(55)),
                        Double.parseDouble(registros.getString(56)),
                        registros.getString(57),
                        registros.getString(58));
                listaProductos.add(producto);
            }
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
        // mostrarLista();
        listainformacionProductos = new ArrayList<String>();
        for (int i=0;i<listaProductos.size();i++){

            listainformacionProductos.add("PLU: "+listaProductos.get(i).getPro_codigo_plu()+ " | Nombre: "+listaProductos.get(i).getPro_nombre_producto());

        }
        conn.close();
        database.close();

        ArrayAdapter adapter= new ArrayAdapter(this,R.layout.list_item_productos,listainformacionProductos);
        listProductos.setAdapter(adapter);
    }
}
