// Generated by view binder compiler. Do not edit!
package com.rafraph.pnineyHalachaHashalem.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rafraph.pnineyHalachaHashalem.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TextMainDownBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton autoScrool;

  @NonNull
  public final TextView bookname;

  @NonNull
  public final ImageButton ibFindNext;

  @NonNull
  public final ImageButton ibFindPrevious;

  @NonNull
  public final ImageButton ibNext;

  @NonNull
  public final ImageButton ibNextPage;

  @NonNull
  public final ImageButton ibPrevious;

  @NonNull
  public final ImageButton ibPreviousPage;

  @NonNull
  public final LinearLayout lnrFindOptions;

  @NonNull
  public final LinearLayout lnrOption3;

  @NonNull
  public final LinearLayout lnrOptions;

  @NonNull
  public final ImageView makeMark;

  @NonNull
  public final ImageView menu;

  @NonNull
  public final ImageView pageSearch;

  @NonNull
  public final ImageButton setNote;

  @NonNull
  public final ImageButton toMain;

  @NonNull
  public final LinearLayout tooBooks;

  @NonNull
  public final ImageView tooMain;

  @NonNull
  public final WebView webView1;

  private TextMainDownBinding(@NonNull LinearLayout rootView, @NonNull ImageButton autoScrool,
      @NonNull TextView bookname, @NonNull ImageButton ibFindNext,
      @NonNull ImageButton ibFindPrevious, @NonNull ImageButton ibNext,
      @NonNull ImageButton ibNextPage, @NonNull ImageButton ibPrevious,
      @NonNull ImageButton ibPreviousPage, @NonNull LinearLayout lnrFindOptions,
      @NonNull LinearLayout lnrOption3, @NonNull LinearLayout lnrOptions,
      @NonNull ImageView makeMark, @NonNull ImageView menu, @NonNull ImageView pageSearch,
      @NonNull ImageButton setNote, @NonNull ImageButton toMain, @NonNull LinearLayout tooBooks,
      @NonNull ImageView tooMain, @NonNull WebView webView1) {
    this.rootView = rootView;
    this.autoScrool = autoScrool;
    this.bookname = bookname;
    this.ibFindNext = ibFindNext;
    this.ibFindPrevious = ibFindPrevious;
    this.ibNext = ibNext;
    this.ibNextPage = ibNextPage;
    this.ibPrevious = ibPrevious;
    this.ibPreviousPage = ibPreviousPage;
    this.lnrFindOptions = lnrFindOptions;
    this.lnrOption3 = lnrOption3;
    this.lnrOptions = lnrOptions;
    this.makeMark = makeMark;
    this.menu = menu;
    this.pageSearch = pageSearch;
    this.setNote = setNote;
    this.toMain = toMain;
    this.tooBooks = tooBooks;
    this.tooMain = tooMain;
    this.webView1 = webView1;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TextMainDownBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TextMainDownBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.text_main_down, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TextMainDownBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.auto_scrool;
      ImageButton autoScrool = ViewBindings.findChildViewById(rootView, id);
      if (autoScrool == null) {
        break missingId;
      }

      id = R.id.bookname;
      TextView bookname = ViewBindings.findChildViewById(rootView, id);
      if (bookname == null) {
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

      id = R.id.ibNext;
      ImageButton ibNext = ViewBindings.findChildViewById(rootView, id);
      if (ibNext == null) {
        break missingId;
      }

      id = R.id.ibNextPage;
      ImageButton ibNextPage = ViewBindings.findChildViewById(rootView, id);
      if (ibNextPage == null) {
        break missingId;
      }

      id = R.id.ibPrevious;
      ImageButton ibPrevious = ViewBindings.findChildViewById(rootView, id);
      if (ibPrevious == null) {
        break missingId;
      }

      id = R.id.ibPreviousPage;
      ImageButton ibPreviousPage = ViewBindings.findChildViewById(rootView, id);
      if (ibPreviousPage == null) {
        break missingId;
      }

      id = R.id.lnrFindOptions;
      LinearLayout lnrFindOptions = ViewBindings.findChildViewById(rootView, id);
      if (lnrFindOptions == null) {
        break missingId;
      }

      id = R.id.lnrOption3;
      LinearLayout lnrOption3 = ViewBindings.findChildViewById(rootView, id);
      if (lnrOption3 == null) {
        break missingId;
      }

      id = R.id.lnrOptions;
      LinearLayout lnrOptions = ViewBindings.findChildViewById(rootView, id);
      if (lnrOptions == null) {
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

      id = R.id.set_note;
      ImageButton setNote = ViewBindings.findChildViewById(rootView, id);
      if (setNote == null) {
        break missingId;
      }

      id = R.id.to_main;
      ImageButton toMain = ViewBindings.findChildViewById(rootView, id);
      if (toMain == null) {
        break missingId;
      }

      LinearLayout tooBooks = (LinearLayout) rootView;

      id = R.id.too_main;
      ImageView tooMain = ViewBindings.findChildViewById(rootView, id);
      if (tooMain == null) {
        break missingId;
      }

      id = R.id.webView1;
      WebView webView1 = ViewBindings.findChildViewById(rootView, id);
      if (webView1 == null) {
        break missingId;
      }

      return new TextMainDownBinding((LinearLayout) rootView, autoScrool, bookname, ibFindNext,
          ibFindPrevious, ibNext, ibNextPage, ibPrevious, ibPreviousPage, lnrFindOptions,
          lnrOption3, lnrOptions, makeMark, menu, pageSearch, setNote, toMain, tooBooks, tooMain,
          webView1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
