package bootcamp.android.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.util.ArrayList;

import bootcamp.android.R;
import bootcamp.android.fragments.ProductDetailsFragment;
import bootcamp.android.models.Product;

import static bootcamp.android.constants.Constants.CURRENT_PRODUCT_KEY;
import static bootcamp.android.constants.Constants.PRODUCTS_KEY;
import static bootcamp.android.constants.Constants.PRODUCT_KEY;

public class ProductDetailsActivity extends FragmentActivity {

  private ArrayList<Product> products;
  private int current;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.product_details_container);

    Bundle extraArguments = getIntent().getExtras();

    products = extraArguments.getParcelableArrayList(PRODUCTS_KEY);
    current = extraArguments.getInt(CURRENT_PRODUCT_KEY);
    replaceFragment();
  }

  public void previous(View view) {
    current--;
    replaceFragment();

  }

  private void replaceFragment() {
    Product product = products.get(current);

    ProductDetailsFragment productDetailsFragment = new ProductDetailsFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(PRODUCT_KEY, product);
    productDetailsFragment.setArguments(bundle);
    getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, productDetailsFragment, "products_fragment").commit();
  }

  public void next(View view) {
    current++;
    replaceFragment();
  }
}
