package oob.tabby.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import oob.tabby.Exception.MustImplementFormFragmentEventsInterfaceException;
import oob.tabby.Model.Country;
import oob.tabby.Model.Person;
import oob.tabby.R;

public class FormFragment extends Fragment {

    private EditText editTextPersonName;
    private Spinner spinnerPersonCountry;
    private Button buttonCreatePerson;
    private FormFragmentEvents callback;

    public FormFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FormFragmentEvents) {
            this.callback = (FormFragmentEvents) context;
        } else {
            Log.e(
                String.valueOf(context.getApplicationInfo().processName),
                String.format(
                    MustImplementFormFragmentEventsInterfaceException.message,
                    context.getClass().getName()
                )
            );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        this.bindUI(view);
        final String[] codes = getResources().getStringArray(R.array.countries_code);
        this.buttonCreatePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateInputData()) {
                    Toast.makeText(FormFragment.this.getContext(), "Please, enter a valid name", Toast.LENGTH_SHORT).show();
                    return;
                }

                callback.onCreatePerson(
                    (new Person())
                        .setName(editTextPersonName.getEditableText().toString())
                        .setCountry(
                            (new Country())
                                .setName(spinnerPersonCountry.getSelectedItem().toString())
                                .setCode(codes[spinnerPersonCountry.getSelectedItemPosition()])
                        )
                );
                clearInputData();
            }
        });

        return view;
    }

    private void bindUI(View view) {
        this.buttonCreatePerson = view.findViewById(R.id.buttonCreatePerson);
        this.editTextPersonName = view.findViewById(R.id.editTextName);
        this.spinnerPersonCountry = view.findViewById(R.id.spinnerCountry);
    }

    private boolean validateInputData() {
        return !TextUtils.isEmpty(this.editTextPersonName.getEditableText().toString());
    }

    private void clearInputData() {
        this.editTextPersonName.setText("");
        this.spinnerPersonCountry.setSelection(0);
    }

    public interface FormFragmentEvents {
        void onCreatePerson(Person person);
    }
}
