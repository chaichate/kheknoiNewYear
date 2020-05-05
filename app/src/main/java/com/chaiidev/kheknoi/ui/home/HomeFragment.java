package com.chaiidev.kheknoi.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.chaiidev.kheknoi.R;
import com.chaiidev.kheknoi.SliderAdapter;
import com.chaiidev.kheknoi.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    SliderView sliderView;
    private SliderAdapter adapter;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        WebView myWebView = (WebView) root.findViewById(R.id.webview);
////        myWebView.loadUrl("https://www.facebook.com/");
//
//        String unencodedHtml =
//                "&lt;html&gt;&lt;body&gt;'%23' is the percent code for ‘#‘ &lt;/body&gt;&lt;/html&gt;";
//        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
//                Base64.NO_PADDING);
//        myWebView.loadData(encodedHtml, "text/html", "base64");

        sliderView = root.findViewById(R.id.imageSlider);

        adapter = new SliderAdapter(this.getActivity());
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(false);

        renewItems();
        return root;

    }

    public void renewItems() {
        List<SliderItem> sliderItemList = new ArrayList<>();

        SliderItem sliderItem = new SliderItem();
        sliderItem.setImageUrl("https://scontent.fbkk5-8.fna.fbcdn.net/v/t1.0-9/76756967_2551029195127589_569597192700952576_o.jpg?_nc_cat=106&_nc_sid=730e14&_nc_eui2=AeFQov6pZST5lUQxC88nGHIvZqaQHhuGlX5mppAeG4aVfgOVeDKXNOZJ6MMh3Sm_VVH3oxYjb10myzHodNYUPEUV&_nc_ohc=82QlqoQjP7IAX_eYqyg&_nc_ht=scontent.fbkk5-8.fna&oh=07d55b1a23475dc85392bbc41bde5f4b&oe=5EB95FA8");
        sliderItemList.add(sliderItem);


        SliderItem sliderItem1 = new SliderItem();
        sliderItem1.setImageUrl("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/80389400_2601697300060778_1948770131282755584_n.jpg?_nc_cat=105&_nc_sid=8bfeb9&_nc_eui2=AeHtTqjnZn5PRet6_riGt2bHZUD7qdrjzudlQPup2uPO5yVqz0FPia1u9pJ1m8t5l1y5IKY2RPSrm_NLKboU_bmv&_nc_ohc=fIP90wbxt3gAX9LuC2d&_nc_ht=scontent.fbkk5-3.fna&oh=7f6459c4ab260158ab1f989734d13335&oe=5EB94B4F");
        sliderItemList.add(sliderItem1);

        SliderItem sliderIte2 = new SliderItem();
        sliderIte2.setImageUrl("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/80544842_2601698493393992_4472797041046585344_n.jpg?_nc_cat=102&_nc_sid=8bfeb9&_nc_eui2=AeEZV0UgSBqAvdHny887sDeCprPrTEigFQCms-tMSKAVAE0WZf3p-eevj1sEFyuOnREJ6dltqlIkvoSweUH_i4iN&_nc_ohc=h39nkFcvxe4AX_2ku1M&_nc_ht=scontent.fbkk5-6.fna&oh=70cef1dfb6f525e0c60959673a5dceb4&oe=5EB88012");
        sliderItemList.add(sliderIte2);



        SliderItem sliderItem3 = new SliderItem();
        sliderItem3.setImageUrl("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/80664428_2601698580060650_1505772545649934336_n.jpg?_nc_cat=105&_nc_sid=8bfeb9&_nc_eui2=AeEqirs_C2Bt569M7-0E44SOiP23TfrCjl-I_bdN-sKOX03dp-SE1DeGM0LUFs3aMhccq5hhUpn9BEsq2T0avSwW&_nc_ohc=Cv--d_V7J5kAX_OQNQM&_nc_ht=scontent.fbkk5-3.fna&oh=a16d61012bdfed316b6d296f726a49de&oe=5EB6460B");
        sliderItemList.add(sliderItem3);



        adapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view) {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(String _imageUrl) {
        SliderItem sliderItem = new SliderItem();
//        sliderItem.setDescription("Slider Item Added Manually");
//        sliderItem.getImageUrl(_imageUrl);
//        sliderItem.setImageUrl("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/80389400_2601697300060778_1948770131282755584_n.jpg?_nc_cat=105&_nc_sid=8bfeb9&_nc_eui2=AeHtTqjnZn5PRet6_riGt2bHZUD7qdrjzudlQPup2uPO5yVqz0FPia1u9pJ1m8t5l1y5IKY2RPSrm_NLKboU_bmv&_nc_ohc=fIP90wbxt3gAX9LuC2d&_nc_ht=scontent.fbkk5-3.fna&oh=7f6459c4ab260158ab1f989734d13335&oe=5EB94B4F");
        adapter.addItem(sliderItem);
    }
}
