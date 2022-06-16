// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListGroupBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout LLlistGroup;

  @NonNull
  public final ImageView ListHeaderIconPlay;

  @NonNull
  public final ImageView ListHeaderIconPlay2;

  @NonNull
  public final TextView lblListHeader;

  private ListGroupBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout LLlistGroup,
      @NonNull ImageView ListHeaderIconPlay, @NonNull ImageView ListHeaderIconPlay2,
      @NonNull TextView lblListHeader) {
    this.rootView = rootView;
    this.LLlistGroup = LLlistGroup;
    this.ListHeaderIconPlay = ListHeaderIconPlay;
    this.ListHeaderIconPlay2 = ListHeaderIconPlay2;
    this.lblListHeader = lblListHeader;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListGroupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListGroupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_group, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListGroupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout LLlistGroup = (LinearLayout) rootView;

      id = R.id.ListHeaderIconPlay;
      ImageView ListHeaderIconPlay = ViewBindings.findChildViewById(rootView, id);
      if (ListHeaderIconPlay == null) {
        break missingId;
      }

      id = R.id.ListHeaderIconPlay2;
      ImageView ListHeaderIconPlay2 = ViewBindings.findChildViewById(rootView, id);
      if (ListHeaderIconPlay2 == null) {
        break missingId;
      }

      id = R.id.lblListHeader;
      TextView lblListHeader = ViewBindings.findChildViewById(rootView, id);
      if (lblListHeader == null) {
        break missingId;
      }

      return new ListGroupBinding((LinearLayout) rootView, LLlistGroup, ListHeaderIconPlay,
          ListHeaderIconPlay2, lblListHeader);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}