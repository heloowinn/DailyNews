// Generated code from Butter Knife. Do not modify!
package com.example.dailynews;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListNewsActivity_ViewBinding implements Unbinder {
  private ListNewsActivity target;

  private View view7f0800da;

  @UiThread
  public ListNewsActivity_ViewBinding(ListNewsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListNewsActivity_ViewBinding(final ListNewsActivity target, View source) {
    this.target = target;

    View view;
    target.rvListNews = Utils.findRequiredViewAsType(source, R.id.rv_list_news, "field 'rvListNews'", RecyclerView.class);
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
    ListNewsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvListNews = null;

    view7f0800da.setOnClickListener(null);
    view7f0800da = null;
  }
}
