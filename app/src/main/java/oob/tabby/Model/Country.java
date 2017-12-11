package oob.tabby.Model;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import oob.tabby.R;

public class Country {

    private static String uri = "http://www.geognos.com/api/en/countries/flag/%s.png";

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }

    public RequestCreator getFlagUrl(Context context) {
        String hola = String.format(Country.uri, this.code);
        return Picasso.with(context).load(String.format(Country.uri, this.code))
                .placeholder(R.drawable.ic_no_image_found).fit();
    }
}
