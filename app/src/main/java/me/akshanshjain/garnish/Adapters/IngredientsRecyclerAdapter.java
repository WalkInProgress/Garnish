package me.akshanshjain.garnish.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.akshanshjain.garnish.Objects.IngredientItem;
import me.akshanshjain.garnish.R;

public class IngredientsRecyclerAdapter extends RecyclerView.Adapter<IngredientsRecyclerAdapter.IngredientsViewHolder> {

    private Context context;
    private List<IngredientItem> ingredientItemList;
    private Typeface QLight;

    public IngredientsRecyclerAdapter(Context context, List<IngredientItem> ingredientItemList) {
        this.context = context;
        this.ingredientItemList = ingredientItemList;
        QLight = Typeface.createFromAsset(context.getAssets(), "fonts/Quicksand-Light.ttf");
    }

    public class IngredientsViewHolder extends RecyclerView.ViewHolder {

        private TextView quantityMeasureTv, ingredientNameTv;

        public IngredientsViewHolder(View view) {
            super(view);
            quantityMeasureTv = view.findViewById(R.id.quantity_measure_ingredient);
            ingredientNameTv = view.findViewById(R.id.ingredient_name);
        }
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_recycler_item, parent, false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        IngredientItem ingredientItem = ingredientItemList.get(position);

        int quantity = ingredientItem.getQuantity();
        String measure = ingredientItem.getMeasure();
        String quantityMeasure = String.valueOf(quantity) + "\n" + measure;

        holder.quantityMeasureTv.setTypeface(QLight);
        holder.quantityMeasureTv.setText(quantityMeasure);

        holder.ingredientNameTv.setText(ingredientItem.getIngredient());
    }

    @Override
    public int getItemCount() {
        return ingredientItemList.size();
    }
}