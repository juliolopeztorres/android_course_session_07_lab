package oob.tabby.Adapter;

import android.widget.ImageView;
import android.widget.TextView;

class PersonViewHolder {
    private ImageView imageViewFlag;
    private TextView textViewName;
    private TextView textViewCountry;

    ImageView getImageViewFlag() {
        return imageViewFlag;
    }

    PersonViewHolder setImageViewFlag(ImageView imageViewFlag) {
        this.imageViewFlag = imageViewFlag;
        return this;
    }

    TextView getTextViewName() {
        return textViewName;
    }

    PersonViewHolder setTextViewName(TextView textViewName) {
        this.textViewName = textViewName;
        return this;
    }

    TextView getTextViewCountry() {
        return textViewCountry;
    }

    PersonViewHolder setTextViewCountry(TextView textViewCountry) {
        this.textViewCountry = textViewCountry;
        return this;
    }
}
