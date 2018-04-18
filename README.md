# PropertyApp
This app get data from the given link and load it in a recyclerView. It’s a complete MVVM project that use dependency injection
and lifecycle aware components. It use all features of <a href="https://developer.android.com/topic/libraries/architecture/index.html">
Android Architecture Components</a> library like Room, ViewModels, LiveData and other Lifecycle-aware components.

I used <a href="https://google.github.io/dagger/">Dagger 2 </a>Dependency Injection in this project to manage dependencies, simplified 
acces to shared dependency like use of <a href="http://square.github.io/retrofit/"> Retrofit</a> to make asynchronous API calls,
also for scope instances like Singleton repositories. Used Googles's <a href="https://developer.android.com/topic/libraries/data-binding/index.html">Android Data Binding</a>
for continuous data integration with UI in a MVVM design pattern. Here the MainActivity act as a controller and controls the flow to 
fragment. Inside fragment used Livedata to observe data changes in ViewModel. Used the repository to maintain separation of concern and also to keep the ViewModel lean. In Repository class the decision to access data from network or from Room database is made. Used framework provide utility classes like <a href="https://developer.android.com/topic/libraries/architecture/guide.html#addendum">NetworkBoundResouce </a> to manage multiple data sources (DB and network) and some others factory pattern classes as well.

Lazy loading is achieved using <a href="http://bumptech.github.io/glide/"> Glide </a>library with android data binding component. With 
Glide I resized bitmap before loading into imageView along with cropping for faster imageLoad. By deafult all images will be loaded to 
memory. Disk cache is also possible with few strategy for caching (did not added any disk cache in this project).

<b>List of android libraries used</b>
<ol>
  <li><a href="https://developer.android.com/topic/libraries/architecture/index.html">Android Architecture Components</a></li>
  <li><a href="https://google.github.io/dagger/">Dagger 2 </a> </li>  
  <li><a href="https://developer.android.com/topic/libraries/data-binding/index.html">Android Data Binding</a></li>
  <li> <a href="https://developer.android.com/topic/libraries/support-library/index.html">Android Support Library</a></li>
  <li><a href="https://developer.android.com/training/testing/espresso/index.html"> Espresso </a></li>  
</ol>

<b>List of 3rd Party libraries</b>
<ol>
  <li> <a href="http://square.github.io/retrofit/"> Retrofit</a></li>
  <li> <a href="http://bumptech.github.io/glide/"> Glide </a></li>
  <li> <a href="http://site.mockito.org/"> Mockito</a></li>  
</ol>

Coding architecture/ Design Pattern:
 <ol>
<li> <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel">MVVM (Model View ViewModel)</a></li>
</ol>


