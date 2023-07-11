package com.example.projectole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.projectole.databinding.ActivityMainBinding
import com.example.projectole.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            val selectedFragment: Fragment = when (menuItem.itemId) {
                R.id.beranda -> HomeFragment()
                R.id.profil -> ProfilFragment()
                R.id.produk -> ProdukFragment()
                R.id.notifikasi -> NotifikasiFragment()
                R.id.keranjang -> KeranjangFragment()
                else -> HomeFragment()
            }
            switchFragment(selectedFragment)
            true
        }

        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment)
            .commit()
    }
}