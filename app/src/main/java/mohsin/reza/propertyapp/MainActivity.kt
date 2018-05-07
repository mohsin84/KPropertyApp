package mohsin.reza.propertyapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import mohsin.reza.propertyapp.ui.PropertyFragment
import mohsin.reza.propertyapp.ui.TitleFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, PropertyFragment.BackToActivity {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private var fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val propertyFragment = PropertyFragment()
            fragmentManager.beginTransaction()                      //Adding the fragment to the Activity container
                    .replace(R.id.container, propertyFragment)
                    .commitAllowingStateLoss()
        }
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector


    override fun onBackToActivity(property: String) {
        val container = R.id.container1
        val fragmentTransaction = fragmentManager.beginTransaction()
        val titleFragment = TitleFragment.create(property)
        val existing = fragmentManager.findFragmentById(container)

        if (existing == null) {
            fragmentTransaction.add(container, titleFragment, titleFragment.javaClass.name)
        } else {
            fragmentTransaction.replace(container, titleFragment, titleFragment.javaClass.name)
            //fragmentTransaction.addToBackStack(existing.getClass().getName());
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}
