// Generated code from Butter Knife. Do not modify!
package com.example.dailynews.dashboard;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.dailynews.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentCategory_ViewBinding implements Unbinder {
  private FragmentCategory target;

  private View view7f0800fb;

  private View view7f0800f6;

  private View view7f080104;

  private View view7f080100;

  private View view7f0800ff;

  private View view7f0800fd;

  private View view7f080105;

  @UiThread
  public FragmentCategory_ViewBinding(final FragmentCategory target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lin_eco, "method 'onClickEco' and method 'onClickEng'");
    view7f0800fb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickEco();
        target.onClickEng();
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_bussines, "method 'onClickBus'");
    view7f0800f6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickBus();
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_tec, "method 'onClickTec'");
    view7f080104 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTec();
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_pol, "method 'onClickPol'");
    view7f080100 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickPol();
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_manual, "method 'onClickManu'");
    view7f0800ff = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickManu();
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_hel, "method 'onClickHel'");
    view7f0800fd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickHel();
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_test, "method 'onClickTest'");
    view7f080105 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTest();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0800fb.setOnClickListener(null);
    view7f0800fb = null;
    view7f0800f6.setOnClickListener(null);
    view7f0800f6 = null;
    view7f080104.setOnClickListener(null);
    view7f080104 = null;
    view7f080100.setOnClickListener(null);
    view7f080100 = null;
    view7f0800ff.setOnClickListener(null);
    view7f0800ff = null;
    view7f0800fd.setOnClickListener(null);
    view7f0800fd = null;
    view7f080105.setOnClickListener(null);
    view7f080105 = null;
  }
}
