// Generated code from Butter Knife. Do not modify!
package com.example.dailynews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f0800fe;

  private View view7f0800f7;

  private View view7f0800b6;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.imgHome = Utils.findRequiredViewAsType(source, R.id.img_home, "field 'imgHome'", ImageView.class);
    target.imgCategory = Utils.findRequiredViewAsType(source, R.id.img_category, "field 'imgCategory'", ImageView.class);
    target.tvHome = Utils.findRequiredViewAsType(source, R.id.tv_home, "field 'tvHome'", TextView.class);
    target.tvCategory = Utils.findRequiredViewAsType(source, R.id.tv_category, "field 'tvCategory'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lin_home, "method 'onclickHome'");
    view7f0800fe = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclickHome();
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_category, "method 'onClickCategory'");
    view7f0800f7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickCategory();
      }
    });
    view = Utils.findRequiredView(source, R.id.fab, "method 'onClickSearch'");
    view7f0800b6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickSearch();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgHome = null;
    target.imgCategory = null;
    target.tvHome = null;
    target.tvCategory = null;

    view7f0800fe.setOnClickListener(null);
    view7f0800fe = null;
    view7f0800f7.setOnClickListener(null);
    view7f0800f7 = null;
    view7f0800b6.setOnClickListener(null);
    view7f0800b6 = null;
  }
}
