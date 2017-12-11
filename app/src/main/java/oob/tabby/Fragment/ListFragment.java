package oob.tabby.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import oob.tabby.Adapter.PersonAdapter;
import oob.tabby.Model.Country;
import oob.tabby.Model.Person;
import oob.tabby.R;

public class ListFragment extends Fragment {

    private ArrayList<Person> personList;
    private PersonAdapter personAdapter;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        this.personList = new ArrayList<Person>(){{
            add(new Person().setName("Random").setCountry((new Country()).setCode("ES").setName("España")));
            add(new Person().setName("Test").setCountry((new Country()).setCode("MX").setName("Mexico")));
            add(new Person().setName("Person").setCountry((new Country()).setCode("CO").setName("Colombia")));
        }};

        ListView listViewPerson = view.findViewById(R.id.listViewPerson);
        this.personAdapter = new PersonAdapter(view.getContext(), this.personList, R.layout.person_item);
        listViewPerson.setAdapter(this.personAdapter);

        return view;
    }

    public void addPerson(Person person) {
        this.personList.add(0, person);
        this.personAdapter.notifyDataSetChanged();
    }
}
