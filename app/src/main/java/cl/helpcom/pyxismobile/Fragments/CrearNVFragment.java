package cl.helpcom.pyxismobile.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cl.helpcom.pyxismobile.BuscarCliente;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_clientes;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_usuarios;
import cl.helpcom.pyxismobile.R;

public class CrearNVFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static mae_usuarios usuario=null;
    public static mae_clientes cliente=null;
    View vista;
    public static TextView txtVendedor,txtCliente;
    Button btnAyudaCliente;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_crear_nv, container, false);
        txtVendedor = vista.findViewById(R.id.txtVendedor_fragment_crear_nv);
        txtCliente = vista.findViewById(R.id.txtCliente_fragment_crear_nv);
        btnAyudaCliente = vista.findViewById(R.id.btnAyudaCliente_fragment_crear_nv);

        txtVendedor.setText("Vendedor: "+usuario.getUsu_nombre());

        txtCliente.setEnabled(true);

        btnAyudaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCliente.setText("");
                Intent buscarCliente = new Intent(getContext(),BuscarCliente.class);

                startActivity(buscarCliente);

            }
        });

        //Toast.makeText(getContext(), ""+cliente.getCli_comuna(), Toast.LENGTH_SHORT).show();



        return  vista;
    }

    public static void cargarCliente(mae_clientes cliente){
         CrearNVFragment.cliente=cliente;
        if(cliente!=null){
     //       txtCliente.setText(cliente.getCli_nombre());
        }
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
