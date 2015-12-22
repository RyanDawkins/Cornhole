package ryanddawkins.com.cornhole;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by ryan on 12/21/15.
 */
public class CornHole extends Application {

    public CornHole() {

        Firebase.setAndroidContext(this.getBaseContext());

    }

}
