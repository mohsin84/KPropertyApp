package mohsin.reza.propertyapp;

import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import mohsin.reza.propertyapp.ui.PropertyFragment;
import mohsin.reza.propertyapp.ui.PropertyFragment;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        PropertyFragment propertyFragment = new PropertyFragment();
        fragmentManager.beginTransaction()                      //Adding the fragment to the Activity container
                .replace(R.id.container, propertyFragment)
                .commitAllowingStateLoss();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

}
