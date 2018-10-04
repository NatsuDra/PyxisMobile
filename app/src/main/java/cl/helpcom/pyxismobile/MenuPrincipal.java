package cl.helpcom.pyxismobile;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cl.helpcom.pyxismobile.Clases.Entidades.mae_usuarios;
import cl.helpcom.pyxismobile.Fragments.ClientesFragment;
import cl.helpcom.pyxismobile.Fragments.CrearNVFragment;
import cl.helpcom.pyxismobile.Fragments.InicioFragment;
import cl.helpcom.pyxismobile.Fragments.VerNVFragment;

public class MenuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, InicioFragment.OnFragmentInteractionListener,
        VerNVFragment.OnFragmentInteractionListener,CrearNVFragment.OnFragmentInteractionListener,ClientesFragment.OnFragmentInteractionListener {

    public static  mae_usuarios usuario=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Bundle objetoRecibido=getIntent().getExtras();

        if(objetoRecibido!=null){
            usuario=(mae_usuarios) objetoRecibido.getSerializable("usuario");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //ESTABLECE EL FRAMENTS INCIO COMO PRINCIPAL Y SE VISUALIZA AL INICIAR
        Fragment fragment= new InicioFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Cerrando Sección", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Fragment mifragment=null;//android support 24 esa elejir


        Bundle bundle = new Bundle();
        bundle.putSerializable("usuario",usuario);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();



        if (id == R.id.nav_inicio) {
            InicioFragment mifragment= new InicioFragment();
            mifragment.setArguments(bundle);

            Toast.makeText(getBaseContext(),"Inicio",Toast.LENGTH_SHORT).show();
            fragmentTransaction.replace(R.id.contenedor,mifragment).commit();




        } else if (id == R.id.nav_crear_nv) {

           CrearNVFragment  mifragment= new CrearNVFragment();

            mifragment.setArguments(bundle);

            Toast.makeText(getBaseContext(),"Crear Nota de Venta",Toast.LENGTH_SHORT).show();

            fragmentTransaction.replace(R.id.contenedor,mifragment).commit();

        } else if (id == R.id.nav_ver_nv) {
            Toast.makeText(getBaseContext(),"Ver Nota de Venta",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_clientes) {
            Toast.makeText(getBaseContext(),"Clientes",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_productos) {
            Toast.makeText(getBaseContext(),"Productos",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(getBaseContext(),"Share",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(getBaseContext(),"Send",Toast.LENGTH_SHORT).show();
        }

       /* if(fragmentSelecionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_menu_principal,mifragment).commit();

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
