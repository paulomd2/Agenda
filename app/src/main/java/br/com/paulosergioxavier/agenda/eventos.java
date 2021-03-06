package br.com.paulosergioxavier.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class eventos extends Comum {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout layout = (DrawerLayout) findViewById(R.id.drawer_layout_eventos);
        NavigationView view = (NavigationView) findViewById(R.id.nav_view_eventos);

        barraNavegacao(layout,view);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_eventos);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        }/* else if(id == R.id.nav_admin_cadUsuario){
            intent = new Intent(this, cadUsuario.class);
        }*/ else if(id == R.id.nav_admin_listaUsuario){
            intent = new Intent(this, listaUsuario.class);
        }/* else if(id == R.id.nav_admin_cadCategoria){
            intent = new Intent(this, cadCategoria.class);
        }*/ else if(id == R.id.nav_admin_listaCategoria){
            intent = new Intent(this, listaCategoria.class);
        }else {
            intent = new Intent();
        }

        novaPagina(intent,param);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_eventos);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void novoEvento(Intent view){
        startActivity(view);
        overridePendingTransition(R.anim.hold, R.anim.fade_in);
    }

}