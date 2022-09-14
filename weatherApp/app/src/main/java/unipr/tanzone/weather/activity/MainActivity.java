package unipr.tanzone.weather.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unipr.tanzone.weather.api.ApiManagment;
import unipr.tanzone.weather.api.WeatherApi;
import unipr.tanzone.weather.location.GPS;
import unipr.tanzone.weather.model.Address;
import unipr.tanzone.weather.model.Schema;
import unipr.tanzone.weather.settings.UserSettings;
import unipr.tanzone.weather.thread.FetchImage;

public class MainActivity extends AppCompatActivity {
	
	private ConstraintLayout mainView;
	private EditText search;
	private ImageView star, location, imgCondition, sky, field, cloud;
	private TextView txtLocation, txtTemp, txtCondition;
	private List<TextView> numHours = new ArrayList<>();
	private List<ImageView> imgHours= new ArrayList<>();
	private List<TextView> tempHours= new ArrayList<>();
	private List<ImageView> imgDay	= new ArrayList<>();
	private List<TextView> dayWeek	= new ArrayList<>();
	private List<TextView> tempDay	= new ArrayList<>();
	private List<TextView> condDay	= new ArrayList<>();

	private WeatherApi myApi;
	private List<String> weekList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//Create view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Set object to use
		setObjects();
		createClickFunctions();
		//content text with current weather in my location
		setTextCurrWeather();
	}

	private void setObjects() {
		this.mainView = this.findViewById(R.id.mainView);
		this.search = this.findViewById(R.id.search);
		this.location = this.findViewById(R.id.location);
		this.star = this.findViewById(R.id.star);
		this.sky = this.findViewById(R.id.sky);
		this.field = this.findViewById(R.id.field);
		this.cloud = this.findViewById(R.id.cloud);
		this.weekList = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");

		this.seDimension();
		this.infoBox();
		this.hoursBox();
		this.weekBox();
	}

	private void seDimension() {
		this.mainView.setMaxWidth(getWindowManager().getDefaultDisplay().getWidth());
	}


	private void infoBox() {
		this.txtLocation = this.findViewById(R.id.txtLocation);
		this.txtTemp = this.findViewById(R.id.txtTemp);
		this.txtCondition = this.findViewById(R.id.txtCondition);
		this.imgCondition = this.findViewById(R.id.imgCondition);
	}

	private void hoursBox() {
		this.numHours.add(this.findViewById(R.id.hour1));
		this.numHours.add(this.findViewById(R.id.hour2));
		this.numHours.add(this.findViewById(R.id.hour3));
		this.numHours.add(this.findViewById(R.id.hour4));

		this.imgHours.add(this.findViewById(R.id.imgHour1));
		this.imgHours.add(this.findViewById(R.id.imgHour2));
		this.imgHours.add(this.findViewById(R.id.imgHour3));
		this.imgHours.add(this.findViewById(R.id.imgHour4));

		this.tempHours.add(this.findViewById(R.id.temp1));
		this.tempHours.add(this.findViewById(R.id.temp2));
		this.tempHours.add(this.findViewById(R.id.temp3));
		this.tempHours.add(this.findViewById(R.id.temp4));
	}

	private void weekBox() {
		this.imgDay.add(this.findViewById(R.id.imgDay6));
		this.imgDay.add(this.findViewById(R.id.imgDay5));
		this.imgDay.add(this.findViewById(R.id.imgDay4));
		this.imgDay.add(this.findViewById(R.id.imgDay3));
		this.imgDay.add(this.findViewById(R.id.imgDay2));
		this.imgDay.add(this.findViewById(R.id.imgDay1));

		this.dayWeek.add(this.findViewById(R.id.dayWeek6));
		this.dayWeek.add(this.findViewById(R.id.dayWeek5));
		this.dayWeek.add(this.findViewById(R.id.dayWeek4));
		this.dayWeek.add(this.findViewById(R.id.dayWeek3));
		this.dayWeek.add(this.findViewById(R.id.dayWeek2));
		this.dayWeek.add(this.findViewById(R.id.dayWeek1));

		this.tempDay.add(this.findViewById(R.id.tempDay6));
		this.tempDay.add(this.findViewById(R.id.tempDay5));
		this.tempDay.add(this.findViewById(R.id.tempDay4));
		this.tempDay.add(this.findViewById(R.id.tempDay3));
		this.tempDay.add(this.findViewById(R.id.tempDay2));
		this.tempDay.add(this.findViewById(R.id.tempDay1));

		this.condDay.add(this.findViewById(R.id.conditionDay6));
		this.condDay.add(this.findViewById(R.id.conditionDay5));
		this.condDay.add(this.findViewById(R.id.conditionDay4));
		this.condDay.add(this.findViewById(R.id.conditionDay3));
		this.condDay.add(this.findViewById(R.id.conditionDay2));
		this.condDay.add(this.findViewById(R.id.conditionDay1));
	}


	private void setTextCurrWeather() {
		GPS location = new GPS(this, MainActivity.this, (LocationManager) getSystemService(Context.LOCATION_SERVICE));
		this.requestAddress(location.getLat(), location.getLon());
	}

	private void requestAddress(String lat, String lon)
	{
		this.myApi = ApiManagment.getApiAddress();
		Call<List<Address>> currAddress = myApi.getCurrAddress(lat, lon, "1", ApiManagment.key);
		currAddress.enqueue(new Callback<List<Address>>() {
			@Override
			public void onResponse(Call<List<Address>> call, Response<List<Address>> response) {
				if(response.code()==404) {
					Toast.makeText(MainActivity.this, "Error to take coordinate", Toast.LENGTH_LONG).show();
					requestWeather("Parma", "3");
				}
				else if(!(response.isSuccessful())) {
					Toast.makeText(MainActivity.this, "Bad request Address", Toast.LENGTH_LONG).show();
					requestWeather("Parma", "3");
				}
				else
					requestWeather(response.body().get(0).getName(), "3");
			}
			@Override
			public void onFailure(Call<List<Address>> call, Throwable t) {
				Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
				requestWeather("Parma", "3");
			}
		});
	}

	private void requestWeather(String cityName, String numDays)
	{
		this.myApi = ApiManagment.getApiWeather();
		Call<Schema> currWeather = myApi.getWeather(cityName, numDays);
		currWeather.enqueue(new Callback<Schema>() {
			@Override
			public void onResponse(Call<Schema> call, Response<Schema> response) {
				if(response.code()==404)
					Toast.makeText(MainActivity.this, "Error to take city name", Toast.LENGTH_LONG).show();

				else if(!(response.isSuccessful()))
					Toast.makeText(MainActivity.this, "Bad request Weather", Toast.LENGTH_LONG).show();
				else
					setTextWeather(response.body());
			}
			@Override
			public void onFailure(Call<Schema> call, Throwable t) {
				Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
			}
		});
	}


	@SuppressLint("SetTextI18n")
	private void setTextWeather(Schema data)
	{
		Calendar calendar = Calendar.getInstance();

		this.txtLocation.setText(data.getLocation().getName());
		this.txtTemp.setText(data.getCurrent().getTemp_c() + "°");
		this.txtCondition.setText(data.getCurrent().getCondition().getText());
		this.setImgPref(false);

		new FetchImage("https:"+data.getCurrent().getCondition().getIcon(), this, this.imgCondition).start();

		this.setTextWeatherHours(data, data.getLocation().getLocaltime().split(" ")[1]);
		this.setTextWeatherDays(data, calendar);
		this.setBackgroundHours(data.getLocation().getLocaltime().split(" ")[1]);
	}

	@SuppressLint("SetTextI18n")
	private void setTextWeatherHours(Schema data, String localtime) {
		for(int i = 0; i < 4; i++)
		{
			int day = 0;
			int hour = Integer.parseInt(localtime.split(":")[0])+i+1;
			if(hour > 23) {hour -= 24; day=1;}

			this.numHours.get(i).setText(" "+String.format("%02d:00", hour)+" ");
			new FetchImage("https:"+data.getForecast().getForecastday().get(day).getHour().get(hour).getCondition().getIcon(), this, this.imgHours.get(i)).start();
			this.tempHours.get(i).setText(data.getForecast().getForecastday().get(day).getHour().get(hour).getTemp_c()+"° ");
		}
	}

	@SuppressLint("SetTextI18n")
	private void setTextWeatherDays(Schema data, Calendar calendar)
	{
		int jumpDays = data.getForecast().getForecastday().size();
		for(int i = 0; i < 6;)
			for(int j=0; j<jumpDays; j++)
			{
				new FetchImage("https:"+data.getForecast().getForecastday().get(j).getDay().getCondition().getIcon(), this, this.imgDay.get(i)).start();
				this.dayWeek.get(i).setText(this.weekList.get(calendar.get(Calendar.DAY_OF_WEEK)+i));
				this.tempDay.get(i).setText(data.getForecast().getForecastday().get(j).getDay().getAvgtemp_c()+"°");
				this.condDay.get(i).setText(data.getForecast().getForecastday().get(j).getDay().getCondition().getText());
				i++;
			}
	}

	//Function for button search
	public void findWeather(View view)
	{
		if(!this.search.getText().toString().equals(""))
			requestWeather(this.search.getText().toString(), "3");
		this.search.setText("");
	}

	private void createClickFunctions()
	{
		star.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setImgPref(true);
			}
		});

		location.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				openMaps();
			}
		});
	}

	private void setImgPref(boolean action)
	{
		List<String> list = UserSettings.readListPref(this);
		if(list == null)
			list = new ArrayList<>();

		String cityName = (String) txtLocation.getText();

		if(!action)
		{
			if(!list.contains(cityName)) removePref(list, cityName, action);
			else addPref(list, cityName, action);
		}
		else
		{
			if(list.contains(cityName)) removePref(list, cityName, action);
			else addPref(list, cityName, action);
		}
	}

	private void addPref(List<String> list, String cityName, boolean action)
	{
		if(action)
		{
			list.add(cityName);
			UserSettings.writeListPref(getApplicationContext(), list);
		}
		star.setImageResource(R.drawable.favourite);
	}

	private void removePref(List<String> list, String cityName, boolean action)
	{
		if(action)
		{
			list.remove(cityName);
			UserSettings.writeListPref(getApplicationContext(), list);
		}
		star.setImageResource(R.drawable.star);
	}

	private void setBackgroundHours(String localtime) {
		int hour = Integer.parseInt(localtime.split(":")[0]);

		//Day
		if(hour >= 6 && hour <= 13)
			this.setBackground(R.drawable.morning_shape, R.drawable.morning_clouds, R.drawable.morning_field);
		else if(hour>= 14 && hour <= 21)
			this.setBackground(R.drawable.evening_shape, R.drawable.evening_clouds, R.drawable.evening_field);
		else
			this.setBackground(R.drawable.night_shape, R.drawable.night_clouds, R.drawable.night_field);

		if(this.txtCondition.getText().toString().toLowerCase().contains("rain"))
			this.setBackground(R.drawable.rain_shape, R.drawable.rain_clouds, R.drawable.rain_field);
	}

	private void setBackground(int shape, int cloud, int field)
	{
		this.sky.setImageResource(shape);
		this.cloud.setImageResource(cloud);
		this.field.setImageResource(field);
	}

	private void openMaps() {
		Intent intent =  new Intent(this, MapsActivity.class);
		startActivity(intent);
	}

}



	
	