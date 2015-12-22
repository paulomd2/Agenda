package br.com.paulosergioxavier.agenda;

import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrador on 22/12/2015.
 */
public class Comum extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public void barraNavegacao(DrawerLayout layout, NavigationView view){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        layout.setDrawerListener(toggle);
        toggle.syncState();

        view.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String param = "";
        Intent intent;

        if (id == R.id.nav_user_verMes) {
            intent = new Intent(this, verEventos.class);
            param = "mes";
        } else if (id == R.id.nav_user_verSemana) {
            intent = new Intent(this, verEventos.class);
            param = "semana";
        } else if(id == R.id.nav_admin_listaCategoria){
            intent = new Intent(this, listaCategoria.class);
        } else if(id == R.id.nav_admin_listaUsuario){
            intent = new Intent(this, listaUsuario.class);
        }else {
            intent = new Intent();
        }

        /* else if(id == R.id.nav_admin_cadUsuario){
            intent = new Intent(this, cadUsuario.class);
        } else if(id == R.id.nav_admin_cadCategoria){
            intent = new Intent(this, cadCategoria.class);
        */

        novaPagina(intent, param);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_categoria);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void novaPagina(Intent intent, String params){
        if(params != ""){

        }

        startActivity(intent);
        overridePendingTransition(R.anim.hold, R.anim.fade_in);
    }
}
