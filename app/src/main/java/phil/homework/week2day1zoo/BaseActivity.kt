package phil.homework.week2day1zoo

import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import phil.homework.week2day1zoo.activity.AnimalTypesListActivity
import phil.homework.week2day1zoo.activity.FavoritesActivity
import phil.homework.week2day1zoo.activity.HomeActivity


open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun setContentView(layoutResID: Int) {
        val fullView = layoutInflater.inflate(R.layout.activity_base, null) as DrawerLayout
        val hostedActivityContainer = fullView.findViewById(R.id.hosted_activity) as FrameLayout
        layoutInflater.inflate(layoutResID, hostedActivityContainer, true)
        super.setContentView(fullView)
        val toolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        title = "CaZoo"

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true;
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { item: MenuItem -> this.onNavigationItemSelected(item) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home -> {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
            R.id.animals -> {
                startActivity(Intent(applicationContext, AnimalTypesListActivity::class.java))
            }
            R.id.favorites -> {
                startActivity(Intent(applicationContext, FavoritesActivity::class.java))
            }
            else -> { }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }
}