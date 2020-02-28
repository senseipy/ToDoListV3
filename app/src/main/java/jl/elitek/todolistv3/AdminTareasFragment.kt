package jl.elitek.todolistv3

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.admin_tareas_fragment.*


class AdminTareasFragment : Fragment() {

    companion object {
        fun newInstance() = AdminTareasFragment()
    }
    //Pager para administrar Tabs
    private lateinit var viewPager: ViewPager
    private lateinit var viewModel: AdminTareasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            return inflater.inflate(R.layout.admin_tareas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AdminTareasViewModel::class.java)


        /*
        val tabLayout = view.findViewById(R.id.adminTabs)
        val adminTabLayout = adminTabs
        val viewPager: ViewPager = findViewById(R.id.adminFragmentPager)
        val viewPagerAdapter = AdminTabFragmentPagerAdapter(supportFragmentManager)
        // probablemente hay que añadir de a uno los fragmentos...
//        viewPagerAdapter.appendFragment()
        viewPager.adapter = viewPagerAdapter
        //     adminTabLayout.setupWithViewPager(viewPager)
                */

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // viewPager = adminFragmentPager;
        // val viewPagerAdapter = AdminTabFragmentPagerAdapter(activity!!.supportFragmentManager)
        // viewPagerAdapter.appendFragment(TabProyectoFragment.newInstance(), "PPppp")
        // viewPagerAdapter.appendFragment(TabActividadFragment.newInstance(), "AAaaa")
        // viewPagerAdapter.appendFragment(TabTareaFragment.newInstance(), "PPppp")
        // //viewPager.adapter = viewPagerAdapter
        // val tabLayout = view.findViewById<TabLayout>(R.id.adminTabs)
        // tabLayout.setupWithViewPager(viewPager)
    }

}
