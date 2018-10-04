package cl.helpcom.pyxismobile.Fragments;
/** Holiwi */

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import cl.helpcom.pyxismobile.Clases.Entidades.mae_usuarios;
import cl.helpcom.pyxismobile.Login;
import cl.helpcom.pyxismobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InicioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment implements LocationListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private mae_usuarios usuario=null;

    TextView t1, t2, t3, t4;
    Button btn1;
    View vista;
    LocationManager locationManager;
    String provider;


    public InicioFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
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
        vista = inflater.inflate(R.layout.fragment_inicio, container, false);


        t1 = (TextView) vista.findViewById(R.id.txtLatitud);
        t2 = (TextView) vista.findViewById(R.id.txtLongitud);
        t3 = (TextView) vista.findViewById(R.id.txtDireccion);
        t4 = (TextView) vista.findViewById(R.id.txtProveedorLocalizacion);

        btn1 = (Button) vista.findViewById(R.id.btnGps);

        if(usuario!=null){
            t1.setText(usuario.getUsu_nombre());
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciarServicio();
                muestraPosicion();


            }
        });



        return vista;
    }


    public void iniciarServicio() {
        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        Toast.makeText(getContext(),"Busqueda de ubicacion Activada",Toast.LENGTH_SHORT).show();
        Criteria c = new Criteria();
        c.setAccuracy(Criteria.ACCURACY_FINE);
        provider = locationManager.getBestProvider(c, true);
        t4.setText("Proveedor Localizacion = " + provider);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            pararServicio();
            return;

        }
        locationManager.requestLocationUpdates(provider, 10000, 1, this);

    }

    public void muestraPosicion() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        t1.setText("Logitud = "+String.valueOf(location.getLongitude()));
        t2.setText("Latitud = "+String.valueOf(location.getLatitude()));

        if(location!=null){
            if(location.getLongitude()!=0.0 && location.getLatitude()!=0.0){
                try{
                    Geocoder geocoder= new Geocoder(getContext(), Locale.getDefault());
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if(!list.isEmpty()){
                        Address direccion=list.get(0);
                        t3.setText("Direccion = "+direccion.getAddressLine(0));
                        pararServicio();
                    }
                }catch (IOException e){
                    Toast.makeText(getContext(),"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
                    pararServicio();
                }
            }
        }
    }

    public void pararServicio(){
        locationManager.removeUpdates(this);
        Toast.makeText(getContext(),"Busqueda de ubicacion desactivada",Toast.LENGTH_SHORT).show();
        //t1.setText("");
        //t2.setText("");
        //t3.setText("");
        //t4.setText("");
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
    public void onLocationChanged(Location location) {
        if(location!=null){
            if(location.getLongitude()!=0.0 && location.getLatitude()!=0.0){

                t1.setText("Logitud = "+String.valueOf(location.getLongitude()));
                t2.setText("Latitud = "+String.valueOf(location.getLatitude()));
                try{
                    Geocoder geocoder= new Geocoder(getContext(), Locale.getDefault());
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if(!list.isEmpty()){
                        Address direccion=list.get(0);


                        t3.setText("Direccion = "+direccion.getAddressLine(0));
                        pararServicio();
                    }
                }catch (IOException e){
                    Toast.makeText(getContext(),"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
                    pararServicio();
                }
            }
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        Intent intent= new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
