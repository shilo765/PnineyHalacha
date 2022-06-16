// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TochenActionbarLayBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageButton autoScrool;

  @NonNull
  public final ImageView bChap2;

  @NonNull
  public final ImageButton ibFindNext;

  @NonNull
  public final ImageButton ibFindPrevious;

  @NonNull
  public final LinearLayout lnrOption3;

  @NonNull
  public final ImageView makeMark;

  @NonNull
  public final ImageView menu;

  @NonNull
  public final ImageView pageSearch;

  @NonNull
  public final ImageView toMain;

  private TochenActionbarLayBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageButton autoScrool, @NonNull ImageView bChap2, @NonNull ImageButton ibFindNext,
      @NonNull ImageButton ibFindPrevious, @NonNull LinearLayout lnrOption3,
      @NonNull ImageView makeMark, @NonNull ImageView menu, @NonNull ImageView pageSearch,
      @NonNull ImageView toMain) {
    this.rootView = rootView;
    this.autoScrool = autoScrool;
    this.bChap2 = bChap2;
    this.ibFindNext = ibFindNext;
    this.ibFindPrevious = ibFindPrevious;
    this.lnrOption3 = lnrOption3;
    this.makeMark = makeMark;
    this.menu = menu;
    this.pageSearch = pageSearch;
    this.toMain = toMain;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TochenActionbarLayBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TochenActionbarLayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.tochen_actionbar_lay, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TochenActionbarLayBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.auto_scrool;
      ImageButton autoScrool = ViewBindings.findChildViewById(rootView, id);
      if (autoScrool == null) {
        break missingId;
      }

      id = R.id.b_chap2;
      ImageView bChap2 = ViewBindings.findChildViewById(rootView, id);
      if (bChap2 == null) {
        break missingId;
      }

      id = R.id.ibFindNext;
      ImageButton ibFindNext = ViewBindings.findChildViewById(rootView, id);
      if (ibFindNext == null) {
        break missingId;
      }

      id = R.id.ibFindPrevious;
      ImageButton ibFindPrevious = ViewBindings.findChildViewById(rootView, id);
      if (ibFindPrevious == null) {
        break missingId;
      }

      id = R.id.lnrOption3;
      LinearLayout lnrOption3 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption3 == null) {
        break missingId;
      }

      id = R.id.make_mark;
      ImageView makeMark = ViewBindings.findChildViewById(rootView, id);
      if (makeMark == null) {
        break missingId;
      }

      id = R.id.menu;
      ImageView menu = ViewBindings.findChildViewById(rootView, id);
      if (menu == null) {
        break missingId;
      }

      id = R.id.page_search;
      ImageView pageSearch = ViewBindings.findChildViewById(rootView, id);
      if (pageSearch == null) {
        break missingId;
      }

      id = R.id.to_main;
      ImageView toMain = ViewBindings.findChildViewById(rootView, id);
      if (toMain == null) {
        break missingId;
      }

      return new TochenActionbarLayBinding((RelativeLayout) rootView, autoScrool, bChap2,
          ibFindNext, ibFindPrevious, lnrOption3, makeMark, menu, pageSearch, toMain);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
