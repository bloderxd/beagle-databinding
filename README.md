# Beagle DataBinding extensions

This project is an example of a [Beagle](https://github.com/ZupIT/beagle) Databinding adapter. This has the purpose of decrease the learning curve of Beagle declarative views, offer all support for Beagle developing that Android Studio has for DataBinding such layout previews, etc.

# Adapter

With this we can develop a simple xml view and transform it in a Beagle view struct:

Then for a simple example we have this xml normal view:

`activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/test1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:layout_centerInParent="true"/>

    <TextView
        android:id="@+id/test2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:layout_alignBottom="@+id/test1"/>


</RelativeLayout>
</layout>
```

Once we've created that we can generate our DataBinding class for it:

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  val binding: ActivityMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
  ...
}
```

Then now we can transform our `ActivityMainBinding` in a Beagle view struct using `toBeagle()` extension function

```kotlin
...
val beagleView = binding.toBeagle()
/**
  Screen(
    child = Container(children = listOf(
      Text(text = "Hello World!"),
      Text(text = "Hello World!")
    ))
  )
**/
...
```
