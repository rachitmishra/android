package com.example.fragments;

import com.example.fragmnt_test.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	public static final String TAG = "Fragments";

	private FragmentOne fragmentOne;
	private FragmentTwo fragmentTwo;
	private FragmentThree fragmentThree;
	private Button changeFragmentsButton;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private int currentFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		changeFragmentsButton = (Button) findViewById(R.id.button1);

		init();
		//changeFragmentsByAdd();
		changeFragmentsByReplace();

		currentFragment = 1;
	}

	public void init() {
		fragmentOne = new FragmentOne();
		fragmentTwo = new FragmentTwo();
		fragmentThree = new FragmentThree();
	}

	public void changeFragmentsByAdd() {

		fragmentManager = getSupportFragmentManager();
		changeFragmentsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				fragmentTransaction = fragmentManager.beginTransaction();
				switch (currentFragment) {
				case 1:
					fragmentTransaction.add(R.id.container, fragmentTwo);
					currentFragment = 2;
					break;
				case 2:
					fragmentTransaction.add(R.id.container, fragmentThree);
					currentFragment = 3;
					break;
				case 3:
					fragmentTransaction.add(R.id.container, fragmentOne);
					currentFragment = 1;
					break;
				default:
					fragmentTransaction.add(R.id.container, fragmentOne);
					break;

				}
				fragmentTransaction.commit();
			}
		});
	}

	public void changeFragmentsByReplace() {
		fragmentManager = getSupportFragmentManager();
		changeFragmentsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				fragmentTransaction = fragmentManager.beginTransaction();
				switch (currentFragment) {
				case 1:
					fragmentTransaction.replace(R.id.container, fragmentTwo);
					currentFragment = 2;
					break;
				case 2:
					fragmentTransaction.replace(R.id.container, fragmentThree);
					currentFragment = 3;
					break;
				case 3:
					fragmentTransaction.replace(R.id.container, fragmentOne);
					currentFragment = 1;
					break;
				default:
					fragmentTransaction.replace(R.id.container, fragmentOne);
					break;

				}
				fragmentTransaction.commit();
			}
		});
	}

	public static class FragmentOne extends Fragment {

		@Override
		public void onCreate(Bundle savedInstanceState) {
			Log.w(TAG, "FragmentOne onCreate");
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Log.w(TAG, "FragmentOne onCreateView");
			View view = inflater.inflate(R.layout.fragment_main, null);
			TextView textView = (TextView) view.findViewById(R.id.textView1);
			textView.setText("Fragment name : " + getClass().getName());
			return view;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			Log.w(TAG, "FragmentOne onActivityCreated");
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public void onStart() {
			Log.w(TAG, "FragmentOne onStart");
			super.onStart();
		}

		@Override
		public void onResume() {
			Log.w(TAG, "FragmentOne onResume");
			super.onResume();
		}

		@Override
		public void onPause() {
			Log.w(TAG, "FragmentOne onPause");
			super.onPause();
		}

		@Override
		public void onStop() {
			Log.w(TAG, "FragmentOne onStop");
			super.onStop();
		}

		@Override
		public void onDestroyView() {
			Log.w(TAG, "FragmentOne onDestoryView");
			super.onDestroyView();
		}

		@Override
		public void onDestroy() {
			Log.w(TAG, "FragmentOne onDestory");
			super.onDestroy();
		}

		@Override
		public void onDetach() {
			Log.w(TAG, "FragmentOne onDetach");
			super.onDetach();
		}
	}

	public static class FragmentTwo extends Fragment {

		@Override
		public void onCreate(Bundle savedInstanceState) {
			Log.w(TAG, "FragmentTwo onCreate");
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Log.w(TAG, "FragmentTwo onCreateView");
			View view = inflater.inflate(R.layout.fragment_main, null);
			TextView textView = (TextView) view.findViewById(R.id.textView1);
			textView.setText("Fragment name : " + getClass().getName());
			return view;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			Log.w(TAG, "FragmentTwo onActivityCreated");
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public void onStart() {
			Log.w(TAG, "FragmentTwo onStart");
			super.onStart();
		}

		@Override
		public void onResume() {
			Log.w(TAG, "FragmentTwo onResume");
			super.onResume();
		}

		@Override
		public void onPause() {
			Log.w(TAG, "FragmentTwo onPause");
			super.onPause();
		}

		@Override
		public void onStop() {
			Log.w(TAG, "FragmentTwo onStop");
			super.onStop();
		}

		@Override
		public void onDestroyView() {
			Log.w(TAG, "FragmentTwo onDestoryView");
			super.onDestroyView();
		}

		@Override
		public void onDestroy() {
			Log.w(TAG, "FragmentTwo onDestory");
			super.onDestroy();
		}

		@Override
		public void onDetach() {
			Log.w(TAG, "FragmentTwo onDetach");
			super.onDetach();
		}
	}

	public static class FragmentThree extends Fragment {

		@Override
		public void onCreate(Bundle savedInstanceState) {
			Log.w(TAG, "FragmentOne onCreate");
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Log.w(TAG, "FragmentThree onCreateView");
			View view = inflater.inflate(R.layout.fragment_main, null);
			TextView textView = (TextView) view.findViewById(R.id.textView1);
			textView.setText("Fragment name : " + getClass().getName());
			return view;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			Log.w(TAG, "FragmentThree onActivityCreated");
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public void onStart() {
			Log.w(TAG, "FragmentThree onStart");
			super.onStart();
		}

		@Override
		public void onResume() {
			Log.w(TAG, "FragmentThree onResume");
			super.onResume();
		}

		@Override
		public void onPause() {
			Log.w(TAG, "FragmentThree onPause");
			super.onPause();
		}

		@Override
		public void onStop() {
			Log.w(TAG, "FragmentThree onStop");
			super.onStop();
		}

		@Override
		public void onDestroyView() {
			Log.w(TAG, "FragmentThree onDestoryView");
			super.onDestroyView();
		}

		@Override
		public void onDestroy() {
			Log.w(TAG, "FragmentThree onDestory");
			super.onDestroy();
		}

		@Override
		public void onDetach() {
			Log.w(TAG, "FragmentThree onDetach");
			super.onDetach();
		}
	}
}
