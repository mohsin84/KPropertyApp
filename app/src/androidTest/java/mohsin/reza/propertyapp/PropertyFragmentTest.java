package mohsin.reza.propertyapp;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import mohsin.reza.propertyapp.testing.SingleFragmentActivity;
import mohsin.reza.propertyapp.ui.PropertyFragment;
import mohsin.reza.propertyapp.ui.PropertyViewModel;
import mohsin.reza.propertyapp.vo.Property;
import mohsin.reza.propertyapp.vo.Resource;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class PropertyFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule =
            new ActivityTestRule<>(SingleFragmentActivity.class, true, true);

    private PropertyViewModel viewModel;

    private MutableLiveData<Resource<List<Property>>> propertyListData = new MutableLiveData<>();


    @Before
    public void init() throws Throwable {
        EspressoTestUtil.disableProgressBarAnimations(activityRule);
        PropertyFragment fragment = PropertyFragment.create();
        viewModel = mock(PropertyViewModel.class);
        when(viewModel.getPropertyLiveData()).thenReturn(propertyListData);

        fragment.viewModelFactory = ViewModelUtil.createFor(viewModel);
        activityRule.getActivity().setFragment(fragment);
        activityRule.runOnUiThread(() -> fragment.binding.get().propertyList.setItemAnimator(null));
    }

    @Test
    public void loading() {
        propertyListData.postValue(Resource.loading(null));
        onView(withId(R.id.load_more_bar)).check(matches(isDisplayed()));
        onView(withId(R.id.retry)).check(matches(not(isDisplayed())));
    }

    @Test
    public void errorNoData() throws InterruptedException {
        doNothing().when(viewModel).setRefresh(true);
        propertyListData.postValue(Resource.error("networkerror", null));

        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())));
        onView(withId(R.id.error_msg)).check(matches(withText("networkerror")));
        onView(withId(R.id.retry)).check(matches(isDisplayed()));
        onView(withId(R.id.retry)).perform(click());
        verify(viewModel).setRefresh(true);
    }

    @Test
    public void loadedRowList() {
        List<Property> propertyList = setPropertyList(2);
        for (int pos = 0; pos < propertyList.size(); pos++) {
            Property property = propertyList.get(pos);
            onView(listMatcher().atPosition(pos)).check(
                    matches(hasDescendant(withText(property.title))));
        }
    }

    private List<Property> setPropertyList(int count) {
        List<Property> propertyList = TestUtil.createProperties(count);
        propertyListData.postValue(Resource.success(propertyList));
        return propertyList;
    }

    @NonNull
    private RecyclerViewMatcher listMatcher() {
        return new RecyclerViewMatcher(R.id.property_list);
    }

}
