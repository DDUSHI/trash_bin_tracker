package com.example.trash_bin_tracker;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
    Context mContext;
    MainActivity mainActivity;

    WebAppInterface(Context c) {
        mContext = c;
        mainActivity = (MainActivity) c;
    }

    @JavascriptInterface
    public void updateMarkerPosition(int index, double latitude, double longitude) {
//        mainActivity.updateMarkerPosition(index, latitude, longitude);
    }
}
