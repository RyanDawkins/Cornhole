package ryanddawkins.com.cornhole.data;

import com.firebase.client.Firebase;

/**
 * Created by ryan on 12/21/15.
 */
public class RootRef {

    private static Firebase myFirebaseRef;

    public static Firebase get() {
        if(myFirebaseRef == null) {
            myFirebaseRef = new Firebase("https://cornhole.firebaseio.com/");
        }
        return myFirebaseRef;
    }

}
