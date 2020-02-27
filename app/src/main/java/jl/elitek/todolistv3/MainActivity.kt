package jl.elitek.todolistv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //NUEVO
        setSupportActionBar(my_toolbar as Toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_hamburger_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener(this)
        //fin NUEVO
     //   setSupportActionBar(toolbar) no funciona, ya existe una actionBar por omisión
        setupNavigation()
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.nav_host_fragment),
            drawerLayout
        )
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        // Update action bar to reflect navigation
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // Handle nav drawer item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

        // Tie nav graph to items in nav drawer
        NavigationUI.setupWithNavController(navigationView, navController)
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when(menu.itemId){
            R.id.nuevo_proyecto_menu_item -> {
//                cambiarFragment(Fragment1.newInstance())
            }
            R.id.nueva_tarea_menu_item-> {
  //              cambiarFragment(Fragment2.newInstance())
            }
            R.id.nuevo_usuario_menu_item -> {
//                cambiarFragment(Fragment3.newInstance())
            }
        }
        return true
    }

}
