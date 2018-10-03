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

import cl.helpcom.pyxismobile.BuscarCliente;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_clientes;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_usuarios;
import cl.helpcom.pyxismobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrearNVFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrearNVFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrearNVFragment extends Fragment implements BuscarClienteFragment.OnFragmentInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private static mae_usuarios usuario=null;
    private static mae_clientes cliente=null;
    View vista;
    TextView txtVendedor,txtCliente;
    Button btnAyudaCliente;

    public CrearNVFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrearNVFragment.
     */
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


        btnAyudaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCliente.setText("Juanito Perez Pereira");
                Intent buscarCliente = new Intent(getContext(),BuscarCliente.class);

                startActivity(buscarCliente);
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

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
