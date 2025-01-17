// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AudioListBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout androidListView;

  @NonNull
  public final TextView listviewItemTitle;

  private AudioListBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout androidListView,
      @NonNull TextView listviewItemTitle) {
    this.rootView = rootView;
    this.androidListView = androidListView;
    this.listviewItemTitle = listviewItemTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AudioListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AudioListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.audio_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AudioListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout androidListView = (LinearLayout) rootView;

      id = R.id.listview_item_title;
      TextView listviewItemTitle = ViewBindings.findChildViewById(rootView, id);
      if (listviewItemTitle == null) {
        break missingId;
      }

      return new AudioListBinding((LinearLayout) rootView, androidListView, listviewItemTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
