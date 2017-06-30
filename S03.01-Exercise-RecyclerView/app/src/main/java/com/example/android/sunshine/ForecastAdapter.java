package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ppatel87 on 6/24/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {


    private String[] mWeatherData;

    public ForecastAdapter()
    {

    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView)
        {
            super(itemView);

            mWeatherTextView= (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }



    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup,int viewtype)
    {

        Context context=viewGroup.getContext();
        int layoutIdforListItem = R.layout.forecast_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttachToParentImmediatly = false;

        View view =inflater.inflate(layoutIdforListItem ,viewGroup,shouldAttachToParentImmediatly);

        return  new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder,int position){

        String waetherForThisDay = mWeatherData[position];
        forecastAdapterViewHolder.mWeatherTextView.setText(waetherForThisDay);
    }

    @Override
    public  int getItemCount()
    {
        if(mWeatherData ==  null)
        {
            return 0;
        }

        return mWeatherData.length;
    }


    public void setWeatherData(String[] mWData)
    {
           mWeatherData = mWData;
        notifyDataSetChanged();
    }

}
