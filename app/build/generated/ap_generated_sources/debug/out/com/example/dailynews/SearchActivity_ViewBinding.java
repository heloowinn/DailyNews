// Generated code from Butter Knife. Do not modify!
package com.example.dailynews;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  private View view7f0800da;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(final SearchActivity target, View source) {
    this.target = target;

    View view;
    target.rvSearch = Utils.findRequiredViewAsType(source, R.id.rv_search, "field 'rvSearch'", RecyclerView.class);
    target.inpSearch = Utils.findRequiredViewAsType(source, R.id.inp_search, "field 'inpSearch'", EditText.class);
    view = Utils.findRequiredView(source, R.id.img_back, "method 'onBack'");
    view7f0800da = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBack();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvSearch = null;
    target.inpSearch = null;

    view7f0800da.setOnClickListener(null);
    view7f0800da = null;
  }
}
