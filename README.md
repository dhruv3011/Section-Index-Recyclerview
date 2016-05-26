# Section-Index-Recyclerview

A simple `Section Index Scroller` for Android's **RecyclerView**.

<img src="http://i.giphy.com/3oEjHG9AAwNUMx55iE.gif">

### Gradle

`compile 'com.dhruvvaishnav.sectionindexrecyclerviewlib:sectionindexrecyclerviewlib:1.0.2'`

### Usage

Replace your `Recyclerview` with `IndicatorScrollRecyclerView` in xml. 

```sh
<com.dhruvvaishnav.sectionindexrecyclerviewlib.IndicatorScrollRecyclerView
        android:id="@+id/rvCountry"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginRight="5dp"
        app:indexScrollAutoHide="false"
        app:indexScrollAutoHideDelay="1500"
        app:indexScrollPopupBgColor="@color/colorPrimary"
        app:indexScrollPopupTextColor="@android:color/white"
        app:indexScrollPopupTextSize="35"
        app:indexScrollThumbColor="@color/colorAccent" />
```
        
        
<table >
  <tr>
    <th >Name</th>
    <th >Description</th>
  </tr>
  <tr>
    <td >app:indexScrollPopupTextSize</td>
    <td >Set Text size in the bubble (Default is 30 according to bubble size)</td>
  </tr>
  <tr>
    <td >app:indexScrollThumbColor</td>
    <td >Scroll thumb color</td>
  </tr>
  <tr>
    <td >app:indexScrollAutoHide</td>
    <td >Hide scroll panel</td>
  </tr>
  <tr>
    <td >app:indexScrollAutoHideDelay</td>
    <td >Bubble show/hide delay</td>
  </tr>
  <tr>
    <td >app:indexScrollPopupBgColor</td>
    <td >Set bubble background color</td>
  </tr>
  <tr>
    <td >app:indexScrollPopupTextColor</td>
    <td >Set bubble text color</td>
  </tr>
</table>


* To show character in bubble you need to implement `IndicatorScrollRecyclerView.SectionedAdapter` in your adapter class and add necessary methods. 

```sh
    @Override
    public String getSectionName(int position) {
        return String.valueOf(getItem(position).getCountryName().charAt(0));
    }
```

Above override method will display first character in bubble.



