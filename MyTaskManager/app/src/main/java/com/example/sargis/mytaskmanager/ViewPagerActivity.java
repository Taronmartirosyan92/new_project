package com.example.sargis.mytaskmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        final ViewPager viewPager = findViewById(R.id.viewPager);
        final InnerPagerAdapter adapter = new InnerPagerAdapter(this, setData());
        viewPager.setAdapter(adapter);

    }

    private List<PagerModel> setData() {
        List<PagerModel> list = new ArrayList<>();
        PagerModel pagerModel = PagerModel.newBuilder()
                .setTitle("Welcome To Task Manager")
                .setContent("you will remember everything that you want," +
                        "while you don't need nothing to ремембер,we will do it for you")
                .build();
        list.add(pagerModel);
        return list;
    }


//Inner adapter
/*Smbo mi hat kanradarnas eli sa
 lav praktikaya te che nu henc es pahin vor urish tex indz es adapter@ petq chi */

    public class InnerPagerAdapter extends PagerAdapter {
        private Context context;
        private List<PagerModel> list;

       private InnerPagerAdapter(Context context, List<PagerModel> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            final View view = inflater.inflate(R.layout.card_view_pager_item, container, false);
            initializationContentPager(position);
            container.addView(view);
            return view;
        }

        private void initializationContentPager(int position) {
            final PagerModel pagerModel = list.get(position);
            final TextView titlePager = findViewById(R.id.card_title);
            final TextView contentPager = findViewById(R.id.card_content);
            final ImageButton skipButton = findViewById(R.id.card_skip);

            titlePager.setText(pagerModel.getTitle());
            contentPager.setText(pagerModel.getContent());
            skipButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO skipButton functional
                }
            });

        }
    }
}
