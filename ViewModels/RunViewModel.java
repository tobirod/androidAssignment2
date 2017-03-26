package skistarassignment.tobias.home.com.skistar.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import skistarassignment.tobias.home.com.skistar.BR;

public class RunViewModel extends BaseObservable {

    private String date;
    private String location;
    private String distance;

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
        Log.i("AndroidExample", date);
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
        notifyPropertyChanged(BR.distance);
    }

}
