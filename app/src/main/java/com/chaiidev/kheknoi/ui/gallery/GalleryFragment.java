package com.chaiidev.kheknoi.ui.gallery;

import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaiidev.kheknoi.R;
import com.squareup.picasso.Picasso;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }
    private Context thiscontext;
    Dialog imageDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.gallery_fragment, container, false);

        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        thiscontext = container.getContext();

        GridView gridView = (GridView)root.findViewById(R.id.gridview);
        final GalleryAdapter booksAdapter = new GalleryAdapter(thiscontext , books);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(thiscontext, "" + position, Toast.LENGTH_SHORT).show();
                ShowPopup(root,position);
            }
        });


        imageDialog = new Dialog(thiscontext);

        return root;
    }


    public  void ShowPopup(View view ,int position ) {
        ImageView imageView ;
        TextView textView ;
        imageDialog.setContentView(R.layout.image_popup  );
        imageView = (ImageView) imageDialog.findViewById(R.id.imagepopup);
        textView = (TextView) imageDialog.findViewById(R.id.close);
        Picasso.get().load(books[position].getImageUrl())
                .into(imageView);

        textView.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onClick(View view) {
                imageDialog.dismiss();
            }
        });

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;

        imageDialog.show();
        Window window = imageDialog.getWindow();
        window.setLayout(width,height );

    }


    private Gallery[] books = {
            new Gallery("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/81002289_10206516285101523_8378764291439853568_o.jpg?_nc_cat=102&_nc_sid=cdbe9c&_nc_eui2=AeE0AIbA600rvcMKni9wezq9ZBi7AsNJlkNkGLsCw0mWQ_H1WV08ZZQUZUpyXZN1lRy_e-ny22gveVg8XKmQuPw6&_nc_ohc=PXxY1jQJhUYAX_jzsje&_nc_ht=scontent.fbkk5-6.fna&oh=f3ada4b4eb4831950111e3fb52f13a68&oe=5ED2905C"),
            new Gallery("https://scontent.fbkk5-4.fna.fbcdn.net/v/t1.0-9/80631941_10206516325262527_8151166977923088384_o.jpg?_nc_cat=110&_nc_sid=cdbe9c&_nc_eui2=AeFpNQouyGtnGWL9_cajboWq93kfTQ6UCTr3eR9NDpQJOgQej9FCv2InnH0BUWW7kUiqLMPV2NHwH41atmZkO7aW&_nc_ohc=U9r6EqCgTpkAX8CmH1H&_nc_ht=scontent.fbkk5-4.fna&oh=adf3f204492706020619401f1916a068&oe=5ED05B0C"),
            new Gallery("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/81207912_10206516407744589_5278298366202085376_o.jpg?_nc_cat=105&_nc_sid=cdbe9c&_nc_eui2=AeHaThr0XUO52OMYJDvQmgonLqrrhJj0x1MuquuEmPTHUytEq_5HZv7L7Kb_NvZLfVgEPT38mFaxrlg6EfpOaP9Y&_nc_ohc=OzCc0FXpbpAAX9VoT5L&_nc_ht=scontent.fbkk5-3.fna&oh=4de836fc31f2e1d31fd0d6c08c71cb9e&oe=5ED105BE"),
            new Gallery("https://scontent.fbkk5-1.fna.fbcdn.net/v/t1.0-9/80603442_10206519950673160_7820030299391131648_o.jpg?_nc_cat=109&_nc_sid=cdbe9c&_nc_eui2=AeEq3SfA4jfoZcxKRXiLadEaeMP6ONAAlb54w_o40ACVvuwCnFCnPC98dobwDHJHPLP0k7aVZW5KZf6gWGZwbu9B&_nc_ohc=RYZkwId4Zr0AX_-tLrA&_nc_ht=scontent.fbkk5-1.fna&oh=172ccc721e220583f7cd2aa75ddd560e&oe=5ECFD63B"),
            new Gallery("https://scontent.fbkk5-1.fna.fbcdn.net/v/t1.0-9/80951349_10206520107877090_3259825025988952064_o.jpg?_nc_cat=109&_nc_sid=cdbe9c&_nc_eui2=AeGqBUP9UDagDJiOtl0ocDAJhQ6oHeRvpCyFDqgd5G-kLCBrZhagj84VmKFYsTHqQkAdDTm1b-jrm2VlD2bjAGiX&_nc_ohc=GFssatxp-J8AX85fPsa&_nc_ht=scontent.fbkk5-1.fna&oh=d1b8c9362b42b22bf56704580b58f86d&oe=5ED115FB"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/81894927_10206528325442524_4939725269624684544_o.jpg?_nc_cat=100&_nc_sid=cdbe9c&_nc_eui2=AeHQ01x3LeVgm8drN-gXn18TTpeS6ExC-y5Ol5LoTEL7LkQntnzIorwqB0oXWt5SpukXcOH1zApFCrMpOkU4zvKp&_nc_ohc=9YlGIhxuuysAX_oYdfk&_nc_ht=scontent.fbkk5-5.fna&oh=a650fb00b67a8672b6307a7574a2f303&oe=5ED17BDD"),
            new Gallery("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/81633024_10206528549928136_5103926370476490752_o.jpg?_nc_cat=105&_nc_sid=cdbe9c&_nc_eui2=AeFM7boVh3jfiIM7jHW5YLqNXdDGpCzFcdFd0MakLMVx0fKUDUzvnEZq44Yq306mnc9DsvD3O_fGGPNpJN9OL487&_nc_ohc=yM39VZ1LmFcAX_w1_0V&_nc_ht=scontent.fbkk5-3.fna&oh=b04b423569b36e663a4c1819a9465c97&oe=5ED06C27"),
            new Gallery("https://scontent.fbkk5-7.fna.fbcdn.net/v/t1.0-9/81825163_10206538593019207_6814296731312717824_o.jpg?_nc_cat=108&_nc_sid=0debeb&_nc_eui2=AeHN3hSlrjVwis8MU72pDvVTNDlu8OIpXAE0OW7w4ilcAbu2NHM2selGJGQxSBTmH_lqQTiNH9TXNsE2WPlWN0dE&_nc_ohc=XFP9Kbesa8AAX-ai8Vi&_nc_ht=scontent.fbkk5-7.fna&oh=9e586c18fffc3741cf1a59e728bb24b4&oe=5ED18987"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/82083016_10206538760823402_4818922111764529152_o.jpg?_nc_cat=100&_nc_sid=0debeb&_nc_eui2=AeHTKRL6C_vDruDm2C6BHFkoxPLlMGk6s6fE8uUwaTqzp3LRqKgUr54l_VbWWlhv0ZLwgdn3CFfxm78wlpHfy4EF&_nc_ohc=mpT96NZuHpsAX9bBFTP&_nc_ht=scontent.fbkk5-5.fna&oh=b040713fa8131a242ceca9d3d86de9c5&oe=5ED0B209"),
            new Gallery("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/81102636_10206547460280883_6968710696913600512_o.jpg?_nc_cat=102&_nc_sid=cdbe9c&_nc_eui2=AeE8P1dNYCm51CnNN7JWulLBBDYwi1BztpUENjCLUHO2lV1dnEikoW-Vz9iuyaHXWttQPb7nGy5sym6ry8KVPAGA&_nc_ohc=w4Z7M7YwV94AX9mmbXf&_nc_ht=scontent.fbkk5-6.fna&oh=d7c31c03741b7de354c48fe62f6527ae&oe=5ED1C9EF"),
            new Gallery("https://scontent.fbkk5-1.fna.fbcdn.net/v/t1.0-9/81584591_10206549359448361_5603816724999700480_o.jpg?_nc_cat=109&_nc_sid=cdbe9c&_nc_eui2=AeH3pP-svquw75Wmyr0UElnOE944m05jSG8T3jibTmNIb7gduUbS2eK6M6OHyd4AiHLJQjpFpwGFEVHVxPOYwxyx&_nc_ohc=_KSucbWt_MgAX_hddc_&_nc_ht=scontent.fbkk5-1.fna&oh=142175043158ac79f15b8d0a424ee3d3&oe=5ED20771"),
            new Gallery("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/81474600_10206549401209405_3716408181589540864_o.jpg?_nc_cat=102&_nc_sid=cdbe9c&_nc_eui2=AeHAKipnuxIm41YusMF6SP18zztFVCJ6_5bPO0VUInr_liU4CP-0UEABq3RyigXfCRGiOfdPdynRYnGN9kvenxDD&_nc_ohc=jX2rolgBNz0AX-wYn5x&_nc_ht=scontent.fbkk5-6.fna&oh=57e8cb192a46737fd83c0681396215f8&oe=5ED10E40"),
            new Gallery("https://scontent.fbkk5-1.fna.fbcdn.net/v/t1.0-9/82276354_10206550399434360_8101956621330022400_o.jpg?_nc_cat=109&_nc_sid=cdbe9c&_nc_eui2=AeGzsYs8w7YOAmTJ_0jBERJAg6JOWFOQ5u6Dok5YU5Dm7qlxhPg9RHgY8D6wB1a0v4XwmSzNHWXlxNUpbtnrSV4Q&_nc_ohc=revVsz0BgaMAX-HoCwb&_nc_ht=scontent.fbkk5-1.fna&oh=91100013a5c60062bd23a4fb5d65ca1f&oe=5ED36548"),
            new Gallery("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/81301843_10206550409994624_6885625168752803840_o.jpg?_nc_cat=102&_nc_sid=cdbe9c&_nc_eui2=AeEHqix__2mJ9iFMX78QY4JqUblwf4UH5rNRuXB_hQfms-JetLD70HH-JiT2h6-Rs0Tbrml7JAodaphajg242YW0&_nc_ohc=sT_PVpK46BoAX9L3-XE&_nc_ht=scontent.fbkk5-6.fna&oh=d18b657d98fcc0583cb33d7be31bfc6f&oe=5ED20526"),
            new Gallery("https://scontent.fbkk5-4.fna.fbcdn.net/v/t1.0-9/82261679_10206550483076451_4636780773603540992_o.jpg?_nc_cat=110&_nc_sid=cdbe9c&_nc_eui2=AeEdIdyLWC422C1U67N0_C4p-yHpj6Daz5L7IemPoNrPkgcayswNlab5gYAPzTc24cAos3YpVLn1-LB9rYC6nXyr&_nc_ohc=PAj_3MlPw-0AX8N-wJk&_nc_ht=scontent.fbkk5-4.fna&oh=8bb1ee11fbbea621fbb49088205b8dad&oe=5ED0823B"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/81295145_10206550570278631_246865451634655232_o.jpg?_nc_cat=100&_nc_sid=cdbe9c&_nc_eui2=AeFGOtQsP1HH5QQz2LM1sDB8mnyz9uhf0AiafLP26F_QCD6OGQnKKGB3UACZBffOMcmCxrP8SUOjQ9-G0t62R-IJ&_nc_ohc=bqp2dw8IwQkAX-dqrwj&_nc_ht=scontent.fbkk5-5.fna&oh=b97aa04be4a57102624acda43a8de90b&oe=5ECFA383"),
            new Gallery("https://scontent.fbkk5-8.fna.fbcdn.net/v/t1.0-9/81957732_10206550575358758_3267030155750539264_o.jpg?_nc_cat=106&_nc_sid=cdbe9c&_nc_eui2=AeG7bN0vaHFpS5xQZX7y9AE7YPQNfKTPV5Zg9A18pM9Xlu-C_gTzvnKFrcKTh5U4q0E08tzUklKEnE0Jbq7CWSVl&_nc_ohc=J1kY2TlrhpIAX_vA6wh&_nc_ht=scontent.fbkk5-8.fna&oh=0ae04b1e7de38f20f6edd7f0c481a0af&oe=5ED347D2"),
            new Gallery("https://scontent.fbkk5-8.fna.fbcdn.net/v/t1.0-9/81377420_10206550589359108_9035596844062736384_o.jpg?_nc_cat=106&_nc_sid=cdbe9c&_nc_eui2=AeGucF1-5udlCe26t5i6I11UfM-EkVVLSSB8z4SRVUtJIN1gtqnbkhLy604vhfrski9-q5-4QDCbhIL2wgQGuq3I&_nc_ohc=aV_wAzoX9X8AX9kOt95&_nc_ht=scontent.fbkk5-8.fna&oh=ccd0f99af19a4795aff1971d2276d9aa&oe=5ECFDB9D"),
            new Gallery("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/81294561_10206550599559363_5873466522873102336_o.jpg?_nc_cat=105&_nc_sid=cdbe9c&_nc_eui2=AeGRI1dlr4QOP1vkjdGsXGog3uHIyg24Dv3e4cjKDbgO_eV9Q-w1RxhyvWc2d3BnUzzUtMk2FxD_We7kRPmnYTzS&_nc_ohc=DkSZ5HmWrq8AX8N2ueS&_nc_ht=scontent.fbkk5-3.fna&oh=d4169ba4959142c5617c8e4f1db60253&oe=5ED346D5"),
            new Gallery("https://scontent.fbkk5-8.fna.fbcdn.net/v/t1.0-9/81965206_10206550608439585_6203072792888344576_o.jpg?_nc_cat=106&_nc_sid=cdbe9c&_nc_eui2=AeGq0SS5naoiR7itJbUgRZ5iHZ79IT7JOJcdnv0hPsk4lygpzZRpBWWgdTX6vBE_U_RYP9OwzhaFBFid4GeToCpE&_nc_ohc=2Qh1jszwVOEAX_vbMDD&_nc_ht=scontent.fbkk5-8.fna&oh=d5b74f90b9a41b30aae99fd8af7bba79&oe=5ED1982B"),
            new Gallery("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/82334698_10206550618519837_4779961651673694208_o.jpg?_nc_cat=101&_nc_sid=cdbe9c&_nc_eui2=AeELO2vHqxXBwglE-MxOa4FgTarSJYDZoBdNqtIlgNmgF_vOVKYzhfIDUo8pxIKYbjw2KNYXQVabRpWX_HwUHjJh&_nc_ohc=eODW3J6rNDkAX9wU-JV&_nc_ht=scontent.fbkk5-6.fna&oh=348aa071edea869246f334069a27940c&oe=5ED076B3"),
            new Gallery("https://scontent.fbkk5-4.fna.fbcdn.net/v/t1.0-9/82288129_10206550623719967_9163691155584450560_o.jpg?_nc_cat=103&_nc_sid=cdbe9c&_nc_eui2=AeFYAChQJquCYhsrs8iUcl0ffFOVsa7_J318U5Wxrv8nffdhY73tfn0-a53LRplvUve1sMj2-CmvgqF5EdfbJQBQ&_nc_ohc=KLyDAZAFM-YAX_NELxY&_nc_ht=scontent.fbkk5-4.fna&oh=09c759758d85c3283a64d50c96145d85&oe=5ED0DE5A"),
            new Gallery("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/81510716_10206550668001074_602100001958526976_o.jpg?_nc_cat=101&_nc_sid=cdbe9c&_nc_eui2=AeHU2gXVxH9HbpQ59aVZ5_lZhvPY3ODw0JWG89jc4PDQlbtm5PjyUlpFPUAg7H7renq8-v30sNHXMEQjICuFhC-j&_nc_ohc=pVZZIDRBaQ4AX8740rs&_nc_ht=scontent.fbkk5-6.fna&oh=a9108d9abd585c7a731a3c61b7d30c48&oe=5ED0672D"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/81293988_10206552896096775_1104881015500832768_o.jpg?_nc_cat=104&_nc_sid=cdbe9c&_nc_eui2=AeGCaZMALvjq7hIwOBJhqkYfIl88YZCQmEEiXzxhkJCYQdO0eZWgzP-UdrV49sTyYnLroeNVkPGxbwATga1HKfpi&_nc_ohc=-owuZDabknQAX8FTklG&_nc_ht=scontent.fbkk5-5.fna&oh=f17b29072c5aab99a965454f473bf123&oe=5ED234C4"),
            new Gallery("https://scontent.fbkk5-1.fna.fbcdn.net/v/t1.0-9/82238184_10206554276731290_4600284379200094208_o.jpg?_nc_cat=109&_nc_sid=cdbe9c&_nc_eui2=AeF13mwbbl_1UvUMDY5BL09MOvndlp7LJcg6-d2WnsslyF024lHg3_ohVnOVcA7qnLF46tDzA0FshoR5sAzEqjA2&_nc_ohc=rIkiXYWei3cAX9_NUtV&_nc_ht=scontent.fbkk5-1.fna&oh=f0849804c4063bc7e98a4b388e4cea4f&oe=5ED241B7"),
            new Gallery("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/81958195_10206554766103524_8967727624822456320_o.jpg?_nc_cat=111&_nc_sid=cdbe9c&_nc_eui2=AeHpWaPvky7xrHHQNHnT-CfezCVBBaORgeDMJUEFo5GB4Kib7WsJvvvDCV9uTcHv67ZPGUDKuTIhZ3MQMX1iu5ay&_nc_ohc=SoF8UHgvkasAX9AbfX7&_nc_ht=scontent.fbkk5-3.fna&oh=a8634e768ae4b091c95ee982beb61df3&oe=5ED2E18E"),
            new Gallery("https://scontent.fbkk5-4.fna.fbcdn.net/v/t1.0-9/81694945_10206554773983721_5288475235375382528_o.jpg?_nc_cat=103&_nc_sid=cdbe9c&_nc_eui2=AeGakFR_3Ott_vXJJt5qW6zHZlo5Ht__E75mWjke3_8TvnAwGxnZ3bMrX-y04GDicxurhI-1GGq0w-UZA63KVT1U&_nc_ohc=9i5_dOse2DwAX-kpK89&_nc_ht=scontent.fbkk5-4.fna&oh=841261fe610a11a213f341b754b8f682&oe=5ED1EA65"),
            new Gallery("https://scontent.fbkk5-6.fna.fbcdn.net/v/t1.0-9/82227516_10206561454990742_8841797504371523584_o.jpg?_nc_cat=102&_nc_sid=cdbe9c&_nc_eui2=AeFsOuMFXuIYUtFAAJUMl4xla8Qmm1iiHgVrxCabWKIeBYy732PkMth4oouD0aLLKgcVf0sSDWDLKQqo2OyRoTFT&_nc_ohc=XrnHnxDJMDEAX-3FQwl&_nc_ht=scontent.fbkk5-6.fna&oh=40d4912124ec45143adbfcc32f80e8f6&oe=5ED34016"),
            new Gallery("https://scontent.fbkk5-8.fna.fbcdn.net/v/t1.0-9/82027322_10206561467671059_3095900254743035904_o.jpg?_nc_cat=106&_nc_sid=cdbe9c&_nc_eui2=AeFHZ6NZKMu29B427PIwDdNsiX33kGdMyj6JffeQZ0zKPoXygy9l1F6p0EiufnG8bWogcrDug8hEUUvfQg_mw_XJ&_nc_ohc=mnxpbvRtLiYAX8lmzr6&_nc_ht=scontent.fbkk5-8.fna&oh=97405b6c512c2d9342786215fb0d3a7f&oe=5ED034F8"),
            new Gallery("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/82042162_10206561483911465_5100564437580906496_o.jpg?_nc_cat=105&_nc_sid=cdbe9c&_nc_eui2=AeE0E0Zu7oPdYYl3EJmPLaVN6mHUOSGS3J3qYdQ5IZLcnY-90vcVpjOgOJfD3Y7lWFE91EbK-6F9UMhC2ibRUTVV&_nc_ohc=Mon42LnlTIwAX-3XJ3F&_nc_ht=scontent.fbkk5-3.fna&oh=a771bbb22c552faa0f809ca09c2aa9cc&oe=5ECF8D62"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/82053445_10206561492991692_9213398113476149248_o.jpg?_nc_cat=100&_nc_sid=cdbe9c&_nc_eui2=AeF2JUxJNEMsUfHIMTUidKRfySQ3mmWtpn3JJDeaZa2mfef9rATi8Ptm9ic1fGLOp1l9LyKhe1sYevOX3lQRW2VC&_nc_ohc=4R_SIElUvn0AX9QVL7y&_nc_ht=scontent.fbkk5-5.fna&oh=f13e6faaa217d64cbb2ba2d5a95cc368&oe=5ED31986"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/82260293_10206561517192297_1086774833540235264_o.jpg?_nc_cat=100&_nc_sid=cdbe9c&_nc_eui2=AeHBIHbIrMAm2cVqKavnbrH5E0GzbacNaVMTQbNtpw1pU6flA_BSVt5PIP1eVr4oD-5qOqIs6-HpUT_EjumWpsu1&_nc_ohc=Sm_57J8XxJsAX8z5l4b&_nc_ht=scontent.fbkk5-5.fna&oh=c2ed84f344afc1037af53722e7c11c79&oe=5ED0B49A"),
            new Gallery("https://scontent.fbkk5-1.fna.fbcdn.net/v/t1.0-9/82516608_10206561534512730_6486228622230159360_o.jpg?_nc_cat=109&_nc_sid=cdbe9c&_nc_eui2=AeE6CDrrcOhOhRzHjjMjVcaFnqlverpFnNSeqW96ukWc1MtOOHdfMphDYFmfn2TnqGx7UxS0eJ_XYW3GOxi1DQaG&_nc_ohc=56apQVfYmgEAX_Y1OI4&_nc_ht=scontent.fbkk5-1.fna&oh=1a2b6ea04a5ac172190372e96f0c2a6d&oe=5ED3422E"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/81545650_10206561775478754_9042576771509125120_o.jpg?_nc_cat=100&_nc_sid=cdbe9c&_nc_eui2=AeHCoXJNTzU11k2C9HnpHDPFnvqix3mYY0Oe-qLHeZhjQ9HIj6fTd-HQgRdJS49sowjYmu2dQk4LceUWFWrGDkZN&_nc_ohc=xXzgc5ww4iYAX85S9hF&_nc_ht=scontent.fbkk5-5.fna&oh=6206a17f6247e1407f9d83a794788e23&oe=5ED2B258"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/82395518_10206565244165469_7737926510559887360_o.jpg?_nc_cat=104&_nc_sid=cdbe9c&_nc_eui2=AeE-yBVLzNW1cLVAsoUoGNp_ga4WLEG_IY6BrhYsQb8hjo0Eaiak8UVHBrrO_zp8J8HXgnaCdZi3QCIv6HQleFZ_&_nc_ohc=LV9q6sf7hT8AX-Pzw25&_nc_ht=scontent.fbkk5-5.fna&oh=08f6d19f40e3043f8d4c0d8fdfd5c194&oe=5ED06911"),
            new Gallery("https://scontent.fbkk5-7.fna.fbcdn.net/v/t1.0-9/81969358_10206565849620605_4202773993335291904_o.jpg?_nc_cat=108&_nc_sid=cdbe9c&_nc_eui2=AeFiEW_3V1uCd-nx6-IwCp3r0ny45XGBMQzSfLjlcYExDBXnbsIjOtcgRyXlb66iDIFNO0yPh4UKwL-EnJ93hgp0&_nc_ohc=QfLUzk07U3IAX-omOj_&_nc_ht=scontent.fbkk5-7.fna&oh=243960f392564ddb1b7f3f0f4269edb6&oe=5ED0A49C"),
            new Gallery("https://scontent.fbkk5-7.fna.fbcdn.net/v/t1.0-9/82519288_10206565981103892_8745556933764710400_o.jpg?_nc_cat=108&_nc_sid=cdbe9c&_nc_eui2=AeG_ylym7pjjKsVrUOapMqWgCXKyleJjYzQJcrKV4mNjNB6ou2E3t5Oug2SKQ6WAvhAhx3EMFAMY-UFu0O9Em66j&_nc_ohc=TV5h2GaChlEAX8Fd_7G&_nc_ht=scontent.fbkk5-7.fna&oh=703ccffa78e8540cb00a3134f35d2e9e&oe=5ED36A73"),
            new Gallery("https://scontent.fbkk5-3.fna.fbcdn.net/v/t1.0-9/82797839_10206584829535091_6169557977666682880_o.jpg?_nc_cat=105&_nc_sid=0debeb&_nc_eui2=AeEI0qPueNQQpgO_ZlqsYX4L2GkCekUFXBHYaQJ6RQVcET8C92hvNMjjzYZTe3HqPVT985RTpXGNHJe3jcTafvRp&_nc_ohc=osqhOq31IrYAX-977_v&_nc_ht=scontent.fbkk5-3.fna&oh=cd1fc43eec7f0c630c598973e3b2f81f&oe=5ED1A0E8"),
            new Gallery("https://scontent.fbkk5-4.fna.fbcdn.net/v/t1.0-9/83393345_10206589790539113_5761604322987081728_o.jpg?_nc_cat=103&_nc_sid=0debeb&_nc_eui2=AeFeL8Xr_HGdmgwIhy1yWiPo_4IDPH03BXT_ggM8fTcFdPREUCNgqPWybWEFGshhJ458oqPGkVJjhFo_lcDPkI7G&_nc_ohc=7L-lX7xzt1AAX8VHUye&_nc_ht=scontent.fbkk5-4.fna&oh=417dbdec3fedcc7439d80f460a4d14ea&oe=5ED34AD1"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/48426211_10205176549328966_2506990226199543808_o.jpg?_nc_cat=104&_nc_sid=cdbe9c&_nc_eui2=AeG9wVsq2xjedhnyeBayhGG-EfI3ROj17oYR8jdE6PXuhqhPH_ceScZAbah7l65y3eyx77F3NTE80Z84EtWfd90-&_nc_ohc=ALrkg5xMpRkAX9-MtFf&_nc_ht=scontent.fbkk5-5.fna&oh=2d79ed7c136a3cd6e675cc216222756f&oe=5ED20599"),
            new Gallery("https://scontent.fbkk5-5.fna.fbcdn.net/v/t1.0-9/48389965_10205179710007981_6485294415303671808_o.jpg?_nc_cat=104&_nc_sid=cdbe9c&_nc_eui2=AeGFd4BbUpgARzrX77Z-0cDOOnLjW21Qktc6cuNbbVCS16LZW5mK9jaRX0Q1U_OQ0fNGVyuQI5VyA_iAAdRD4Kex&_nc_ohc=ErozBH34i6gAX-5_Mim&_nc_ht=scontent.fbkk5-5.fna&oh=346f0d6f63acd19cd135df9b7929ca9a&oe=5ED3481D"),
            new Gallery("https://scontent.fbkk5-1.fna.fbcdn.net/v/t1.0-9/49005353_10205189512773044_748683185616846848_o.jpg?_nc_cat=109&_nc_sid=cdbe9c&_nc_eui2=AeEbdZv1e1SjROtHLuQMp-S9vSS5xu6tgI29JLnG7q2AjYsH2fN-BCMyKURZe81Jy9chYCnAAy1Og3skhhwqxqK4&_nc_ohc=bBfcv2nVYYoAX-9y6my&_nc_ht=scontent.fbkk5-1.fna&oh=6e66124f7d096dcedeff04fcbe78ce7e&oe=5ED182C4")




    };


}
