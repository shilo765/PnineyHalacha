// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFeedbackBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView bChap2;

  @NonNull
  public final Button bContentFix;

  @NonNull
  public final EditText etContent;

  @NonNull
  public final TextView headr;

  @NonNull
  public final EditText lastSearch;

  @NonNull
  public final LinearLayout lnrOption3;

  @NonNull
  public final LinearLayout main;

  @NonNull
  public final ImageView menu;

  @NonNull
  public final TextView sendFeedback;

  @NonNull
  public final EditText title;

  @NonNull
  public final ImageView toMain;

  private ActivityFeedbackBinding(@NonNull LinearLayout rootView, @NonNull ImageView bChap2,
      @NonNull Button bContentFix, @NonNull EditText etContent, @NonNull TextView headr,
      @NonNull EditText lastSearch, @NonNull LinearLayout lnrOption3, @NonNull LinearLayout main,
      @NonNull ImageView menu, @NonNull TextView sendFeedback, @NonNull EditText title,
      @NonNull ImageView toMain) {
    this.rootView = rootView;
    this.bChap2 = bChap2;
    this.bContentFix = bContentFix;
    this.etContent = etContent;
    this.headr = headr;
    this.lastSearch = lastSearch;
    this.lnrOption3 = lnrOption3;
    this.main = main;
    this.menu = menu;
    this.sendFeedback = sendFeedback;
    this.title = title;
    this.toMain = toMain;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFeedbackBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFeedbackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_feedback, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFeedbackBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.b_chap2;
      ImageView bChap2 = ViewBindings.findChildViewById(rootView, id);
      if (bChap2 == null) {
        break missingId;
      }

      id = R.id.bContentFix;
      Button bContentFix = ViewBindings.findChildViewById(rootView, id);
      if (bContentFix == null) {
        break missingId;
      }

      id = R.id.etContent;
      EditText etContent = ViewBindings.findChildViewById(rootView, id);
      if (etContent == null) {
        break missingId;
      }

      id = R.id.headr;
      TextView headr = ViewBindings.findChildViewById(rootView, id);
      if (headr == null) {
        break missingId;
      }

      id = R.id.last_search;
      EditText lastSearch = ViewBindings.findChildViewById(rootView, id);
      if (lastSearch == null) {
        break missingId;
      }

      id = R.id.lnrOption3;
      LinearLayout lnrOption3 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption3 == null) {
        break missingId;
      }

      LinearLayout main = (LinearLayout) rootView;

      id = R.id.menu;
      ImageView menu = ViewBindings.findChildViewById(rootView, id);
      if (menu == null) {
        break missingId;
      }

      id = R.id.send_feedback;
      TextView sendFeedback = ViewBindings.findChildViewById(rootView, id);
      if (sendFeedback == null) {
        break missingId;
      }

      id = R.id.title;
      EditText title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.to_main;
      ImageView toMain = ViewBindings.findChildViewById(rootView, id);
      if (toMain == null) {
        break missingId;
      }

      return new ActivityFeedbackBinding((LinearLayout) rootView, bChap2, bContentFix, etContent,
          headr, lastSearch, lnrOption3, main, menu, sendFeedback, title, toMain);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}