// Generated code from Butter Knife. Do not modify!
package com.example.dailynews;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailNewsActivity_ViewBinding implements Unbinder {
  private DetailNewsActivity target;

  private View view7f0800e5;

  private View view7f0800da;

  @UiThread
  public DetailNewsActivity_ViewBinding(DetailNewsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailNewsActivity_ViewBinding(final DetailNewsActivity target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvPublis = Utils.findRequiredViewAsType(source, R.id.tv_publis, "field 'tvPublis'", TextView.class);
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'tvDate'", TextView.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
    target.imgContent = Utils.findRequiredViewAsType(source, R.id.img_content, "field 'imgContent'", ImageView.class);
    target.linView = Utils.findRequiredViewAsType(source, R.id.lin_preview, "field 'linView'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.img_share, "method 'onShare'");
    view7f0800e5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onShare();
      }
    });
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
    DetailNewsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.tvPublis = null;
    target.tvDate = null;
    target.tvContent = null;
    target.imgContent = null;
    target.linView = null;

    view7f0800e5.setOnClickListener(null);
    view7f0800e5 = null;
    view7f0800da.setOnClickListener(null);
    view7f0800da = null;
  }
}
