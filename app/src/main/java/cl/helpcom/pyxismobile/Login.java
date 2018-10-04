package cl.helpcom.pyxismobile;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import cl.helpcom.pyxismobile.Clases.DB;
import cl.helpcom.pyxismobile.Clases.Entidades.mae_usuarios;

public class Login extends AppCompatActivity {

    LocationManager locationManager;
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        int permisoAccesFineLocation = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);

        if(permisoAccesFineLocation==PackageManager.PERMISSION_DENIED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                //MENSAJE DE INFORMACION SOBRE LA SOLICITUD DEL PERMISO

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);

            }

        }

        CardView Ingresar = (CardView) findViewById(R.id.cardView);
        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = ((EditText) findViewById(R.id.txtUsuario)).getText().toString();
                String pass = ((EditText) findViewById(R.id.txtPassword)).getText().toString();
                //attemptLogin();
                DB con = new DB(Login.this);
                SQLiteDatabase database = con.getWritableDatabase();

                String sql="SELECT usu_nusuario,usu_password,usu_nombre,per_id,car_id,sec_id,usu_activo,ven_id,usu_su,usu_telefono FROM mae_usuarios " +
                        "WHERE usu_nusuario='"+user+"' AND usu_password='"+pass+"' AND usu_activo=1";

                if (!user.isEmpty() && !pass.isEmpty()){
                   // MostrarLocalizacion();

                    Cursor fila=database.rawQuery(sql,null);

                    if(fila.moveToFirst()){
                        Toast.makeText(getApplicationContext(),"Bienvenido "+fila.getString(2),Toast.LENGTH_SHORT).show();

                        mae_usuarios usuario= new mae_usuarios(fila.getString(0),fila.getString(1),
                                fila.getString(2),Integer.parseInt(fila.getString(3)),
                                Integer.parseInt(fila.getString(4)),Integer.parseInt(fila.getString(5)),
                                Integer.parseInt(fila.getString(6)),Integer.parseInt(fila.getString(7)),
                                fila.getString(8),fila.getString(9));

                        fila.close();
                        database.close();

                        Intent principal = new Intent(Login.this,MenuPrincipal.class);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("usuario",usuario);
                        principal.putExtras(bundle);

                        startActivity(principal);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"El usuario no existe",Toast.LENGTH_SHORT).show();
                        database.close();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Debe completar los campos",Toast.LENGTH_SHORT).show();
                    database.close();
                }
            }
        });



    }

    public void MostrarLocalizacion(){

        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }

        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // CODIGO A REALIZAR
                Toast.makeText(getBaseContext(),"Ubicacion [Latitud: "+location.getLatitude()+", Longitud: "+location.getLongitude()+"]",Toast.LENGTH_LONG).show();

                if(location!=null){
                    if(location.getLongitude()!=0.0 && location.getLatitude()!=0.0){
                        try{
                            Geocoder geocoder= new Geocoder(Login.this, Locale.getDefault());
                            List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                            if(!list.isEmpty()){
                                Address direccion=list.get(0);
                                Toast.makeText(Login.this,"Direccion: "+direccion.getAddressLine(0),Toast.LENGTH_SHORT).show();
                            }
                        }catch (IOException e){
                            Toast.makeText(Login.this,"Error: "+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {
                Intent intent= new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        int permisoAccesFineLocation = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);

        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, locationListener);

    }
}
