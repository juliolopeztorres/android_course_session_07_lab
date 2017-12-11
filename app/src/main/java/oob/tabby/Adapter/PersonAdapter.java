package oob.tabby.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import oob.tabby.Model.Country;
import oob.tabby.Model.Person;
import oob.tabby.R;

public class PersonAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Person> personList;
    private int layout;

    public PersonAdapter(Context context, ArrayList<Person> personList, int layout) {
        this.context = context;
        this.personList = personList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return this.personList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = this.inflateView(view);

        PersonViewHolder personViewHolder = (PersonViewHolder) view.getTag();

        Person person = this.personList.get(i);
        Country personCountry = person.getCountry();

        personViewHolder.getTextViewName().setText(person.getName());
        personViewHolder.getTextViewCountry().setText(personCountry.getName());
        personCountry.getFlagUrl(this.context).into(personViewHolder.getImageViewFlag());

        return view;
    }

    private View inflateView(View view) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(this.layout, null);
            view.setTag(this.createViewHolder(view));
        }

        return view;
    }

    private PersonViewHolder createViewHolder(View view) {
        return (new PersonViewHolder())
            .setImageViewFlag((ImageView) view.findViewById(R.id.imageViewFlag))
            .setTextViewName((TextView) view.findViewById(R.id.textViewName))
            .setTextViewCountry((TextView) view.findViewById(R.id.textViewCountry))
            ;
    }
}
