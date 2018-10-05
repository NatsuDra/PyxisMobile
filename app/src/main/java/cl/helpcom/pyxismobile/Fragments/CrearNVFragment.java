package cl.helpcom.pyxismobile.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import cl.helpcom.pyxismobile.BuscarCliente;
import cl.helpcom.pyxismobile.BuscarProducto;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_clientes;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_usuarios;
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
    public static TextView txtVendedor,txtCliente;
    Button btnAyudaCliente, btnAyudaProductos, btnProdutoOk;
    public static String CLIENTE_JSON;
    private TableLayout tableLayout;


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
        if (getArguments() != null) {
            usuario = (mae_usuarios) getArguments().getSerializable("usuario");
        }

        try{
            CLIENTE_JSON = getArguments().getString("CLIENTE");
            Gson gson = new Gson();
             mae_clientes cliente = gson.fromJson(CLIENTE_JSON,mae_clientes.class);
            Toast.makeText(getContext(), ""+cliente.getCli_ciudad(), Toast.LENGTH_SHORT).show();
            txtCliente.setText(cliente.getCli_nombre());
        }catch (Exception e){
            Toast.makeText(getContext(), "Error "+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("ERROR CLIENTE ",e.getMessage().toString());

        }
    }

    public static CrearNVFragment nueva(String cliente_json){

        CrearNVFragment framnet = new CrearNVFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CLIENTE",cliente_json);
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

        //txtVendedor.setText("Vendedor: "+usuario.getUsu_nombre());

        txtCliente.setEnabled(false);

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

                Toast.makeText(getContext(), "Producto Agregado", Toast.LENGTH_SHORT).show();

            }
        });


        return  vista;
    }


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
