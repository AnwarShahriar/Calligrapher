package me.anwarshahriar.calligrapher;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anwarshahriar on 10/1/16.
 */

public class Calligrapher {
    private AssetManager mAssetManager;
    private Map<String, Typeface> mTypefaceMap;


    public Calligrapher(Context context) {
        mTypefaceMap = new HashMap<>();
        mAssetManager = context.getAssets();
    }


    public void setFont(Activity activity, String fontPath) {
        Typeface typeface = cacheFont(fontPath);
        View rootView = activity.getWindow().getDecorView();
        traverseView(rootView, typeface);
    }


    public void setFont(View view, String fontPath) {
        Typeface typeface = cacheFont(fontPath);
        traverseView(view, typeface);
    }


    private void traverseView(View view, Typeface typeface) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View v = viewGroup.getChildAt(i);
                if (v instanceof TextView) {
                    ((TextView) v).setTypeface(typeface);
                }
                if (v instanceof ViewGroup) {
                    traverseView(v, typeface);
                }
            }
        }
    }


    private Typeface cacheFont(String fontPath) {
        Typeface cached = mTypefaceMap.get(fontPath);
        if (cached == null) {
            cached = Typeface.createFromAsset(mAssetManager, fontPath);
            mTypefaceMap.put(fontPath, cached);
        }
        return cached;
    }
}