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

public class Calligrapher {

    private AssetManager mAssetManager; // AsetManger needs to create Typeface from a path
    private Map<String, Typeface> mTypefaceMap; // fontPath vs Typeface map used for caching Typeface


    /**
     * Constructor for creating calligrapher object
     * @param context Android Context
     */
    public Calligrapher(Context context) {
        mTypefaceMap = new HashMap<>();
        mAssetManager = context.getAssets();
    }


    /**
     * Set font to every view that supports typeface of the given activity layout
     * @param activity Target activity
     * @param fontPath Font file source path (Font must be in the assets directory of the application)
     * @param includeActionbar Flag to determine if the Actionbar title font need to be changed or not
     */
    public void setFont(Activity activity, String fontPath, boolean includeActionbar) {
        Typeface typeface = cacheFont(fontPath);
        View rootView = includeActionbar ? activity.getWindow().getDecorView()
                : ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        traverseView(rootView, typeface);
    }


    /**
     * Set font to target view and it's child (if any)
     * @param view Target view
     * @param fontPath Font file source path (Font must be in the assets directory of the application)
     */
    public void setFont(View view, String fontPath) {
        Typeface typeface = cacheFont(fontPath);
        traverseView(view, typeface);
    }


    /**
     * Traverse view recursively from the given target view
     * @param view Target view
     * @param typeface Typeface which needs to be set from the given target view to it's children
     */
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


    /**
     * Creates a cached copy of a typeface from the given path
     * @param fontPath Path from where a Typeface needs to be created
     * @return Cached copy of the typeface built from the font path
     */
    private Typeface cacheFont(String fontPath) {
        Typeface cached = mTypefaceMap.get(fontPath);
        if (cached == null) {
            cached = Typeface.createFromAsset(mAssetManager, fontPath);
            mTypefaceMap.put(fontPath, cached);
        }
        return cached;
    }


}