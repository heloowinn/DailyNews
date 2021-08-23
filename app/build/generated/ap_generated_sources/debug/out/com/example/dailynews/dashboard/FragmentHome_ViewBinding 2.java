// Generated code from Butter Knife. Do not modify!
package com.example.dailynews.dashboard;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.dailynews.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentHome_ViewBinding implements Unbinder {
  private FragmentHome target;

  private View view7f0801ed;

  private View view7f0801ec;

  private View view7f0801ee;

  @UiThread
  public FragmentHome_ViewBinding(final FragmentHome target, View source) {
    this.target = target;

    View view;
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    target.rvNews = Utils.findRequiredViewAsType(source, R.id.rv_news, "field 'rvNews'", RecyclerView.class);
    target.rvNewsFavorite = Utils.findRequiredViewAsType(source, R.id.rv_news_favorit, "field 'rvNewsFavorite'", RecyclerView.class);
    target.linDasboard = Utils.findRequiredViewAsType(source, R.id.lin_dashboard, "field 'linDasboard'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_see_all_headlines, "method 'onClickHeadLine'");
    view7f0801ed = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickHeadLine();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_see_all_favorit, "method 'onClickFavorite'");
    view7f0801ec = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickFavorite();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_see_all_update, "method 'onClickUpdate'");
    view7f0801ee = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickUpdate();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentHome target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.rvNews = null;
    target.rvNewsFavorite = null;
    target.linDasboard = null;

    view7f0801ed.setOnClickListener(null);
    view7f0801ed = null;
    view7f0801ec.setOnClickListener(null);
    view7f0801ec = null;
    view7f0801ee.setOnClickListener(null);
    view7f0801ee = null;
  }
}
