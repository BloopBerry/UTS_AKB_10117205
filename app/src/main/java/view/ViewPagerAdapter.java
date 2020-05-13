package view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProfilFragment();
            case 1:
                return new KontakFragment();
            case 2:
                return new DaftarFragment();
            case 3:
                return new InfoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}
