package cl.helpcom.pyxismobile.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import cl.helpcom.pyxismobile.BuscarCliente;
import cl.helpcom.pyxismobile.BuscarProducto;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_clientes;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_usuarios;
import cl.helpcom.pyxismobile.Clases.TablaDynamica;
import cl.helpcom.pyxismobile.R;

public class CrearNVFragment extends Fragment  {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static mae_usuarios usuario=null;
   // public static mae_clientes cliente=null;
    View vista;
    public static TextView txtVendedor,txtCliente,txtCodigoPluProducto,txtNombreProducto,txtPrecioUnitarioProducto,txtCantidadProducto,txtDescuentoProducto,txtTotalProducto;
    Button btnAyudaCliente, btnAyudaProductos, btnProdutoOk;
    public static String CLIENTE_JSON;
    private TableLayout tableLayout;

    private String[] nombreColumnas={"CodigoPlu","NombreProducto","Precio","Cantidad","Descuento","Total"};
    private ArrayList<String[]> rows = new ArrayList<String[]>();
    TablaDynamica tablaDynamica;

    public CrearNVFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CrearNVFragment newInstance(String param1, String param2) {
        CrearNVFragment fragment = new CrearNVFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
        if (getArguments().getSerializable("usuario") != null) {
            usuario = (mae_usuarios) getArguments().getSerializable("usuario");
        }


            if(getArguments().get("CLIENTE")!=null){
                CLIENTE_JSON = getArguments().getString("CLIENTE");
                Gson gson = new Gson();
                mae_clientes cliente = gson.fromJson(CLIENTE_JSON,mae_clientes.class);
                Toast.makeText(getContext(), ""+cliente.getCli_ciudad(), Toast.LENGTH_SHORT).show();
                txtCliente.setText(cliente.getCli_nombre());
            }

        }catch (Exception e){
            Toast.makeText(getContext(), "Error "+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("ERROR CLIENTE ",e.getMessage().toString());

        }
    }

    public static CrearNVFragment nueva(String cliente_json){

        CrearNVFragment framnet = new CrearNVFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CLIENTE",cliente_json);

        bundle.putSerializable("usuario",usuario);
        framnet.setArguments(bundle);

        return framnet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_crear_nv, container, false);
        txtVendedor = vista.findViewById(R.id.txtVendedor_fragment_crear_nv);
        txtCliente = vista.findViewById(R.id.txtCliente_fragment_crear_nv);
        btnAyudaCliente = vista.findViewById(R.id.btnAyudaCliente_fragment_crear_nv);
        btnAyudaProductos = vista.findViewById(R.id.btnAyudaProducto_frament_crear_nv);
        btnProdutoOk = vista.findViewById(R.id.btnOkProducto_frament_crear_nv);
        tableLayout = vista.findViewById(R.id.table_fragmentCrearNV);

        txtCodigoPluProducto=vista.findViewById(R.id.txtCodigoPluProducto_fragment_crear_nv);
        txtNombreProducto=vista.findViewById(R.id.txtNombreProducto_fragment_crear_nv);
        txtPrecioUnitarioProducto=vista.findViewById(R.id.txtPrecioUnitarioProducto_fragment_crear_nv);
        txtCantidadProducto=vista.findViewById(R.id.txtCantidadProducto_fragment_crear_nv);
        txtDescuentoProducto=vista.findViewById(R.id.txtDescuentoProducto_fragment_crear_nv);
        txtTotalProducto=vista.findViewById(R.id.txtTotalProducto_fragment_crear_nv);

        txtVendedor.setText("Vendedor: "+usuario.getUsu_nombre());


        txtCliente.setEnabled(false);

        //TABLA PRODUCTOS
        tablaDynamica= new TablaDynamica(tableLayout,getContext());
        tablaDynamica.addHeader(nombreColumnas);
        tablaDynamica.addData(getProductos());
        tablaDynamica.backgroundHeader(Color.parseColor("#558B2F"));
        tablaDynamica.backgroundData(Color.MAGENTA,Color.LTGRAY);
        tablaDynamica.lineColor(Color.BLACK);
        tablaDynamica.textColorData(Color.WHITE);
        tablaDynamica.textColorHeader(Color.parseColor("#004D40"));
        //----------------------------------------------------------------------
        btnAyudaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //txtCliente.setText("");
                Intent buscarCliente = new Intent(getContext(),BuscarCliente.class);

                startActivity(buscarCliente);

            }
        });

        btnAyudaProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent buscarProductos= new Intent(getContext(),BuscarProducto.class);

                Toast.makeText(getContext(), "Listando productos", Toast.LENGTH_SHORT).show();

                startActivity(buscarProductos);

            }
        });

        btnProdutoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //agregaProducto();
               // Toast.makeText(getContext(), "Producto Agregado", Toast.LENGTH_SHORT).show();
                String[] item = new String[]{txtCodigoPluProducto.getText().toString(),txtNombreProducto.getText().toString(),txtPrecioUnitarioProducto.getText().toString(),
                        txtCantidadProducto.getText().toString(),txtDescuentoProducto.getText().toString(),txtTotalProducto.getText().toString()};
                tablaDynamica.addItems(item);
                tablaDynamica.backgroundData(Color.parseColor("#827717"),Color.parseColor("#C0CA33"));

            }
        });


        return  vista;
    }

    public void agregaProducto(){
        String[] item = new String[]{txtCodigoPluProducto.getText().toString(),txtNombreProducto.getText().toString(),txtPrecioUnitarioProducto.getText().toString(),
                txtCantidadProducto.getText().toString(),txtDescuentoProducto.getText().toString(),txtTotalProducto.getText().toString()};
        tablaDynamica.addItems(item);
    }


    //----------------------------------------------------------------------------------------------
    private ArrayList<String[]> getProductos(){
        rows.add(new String[]{"1","Tomate","100","4","50","350"});
        rows.add(new String[]{"2","Peraz 1k","200","1","1","190"});
        rows.add(new String[]{"3","Chocolate","500","1","0","500"});
        rows.add(new String[]{"4","Coca-cola-1L","1000","1","100","900"});

        return rows;
    }

    //----------------------------------------------------------------------------------------------

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
