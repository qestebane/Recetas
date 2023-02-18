
# RecetarioApp


#### Arquitectura

- MVVM: Para la organización del código

#### Design pattern:
- Observer: Para notificar cambios en la lista


#### Endpoint:
[API](https://63e9bbba4f3c6aa6e7d13957.mockapi.io/api/v1/recipe)

#### Diseño:
[Figma](https://www.figma.com/file/nevh2tqh3hYhlWciOKHvI1/Receta?node-id=0%3A1&t=XGeMn3Gd9qtHAb76-1)

#### Librerías:

```Java
// ViewModel
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0'
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    // Fragment
    implementation "androidx.fragment:fragment-ktx:1.3.2"
    // Activity
    implementation "androidx.activity:activity-ktx:1.2.2"

    //Corrutinas
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'
    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"

    //images
    implementation 'com.squareup.picasso:picasso:2.8'
    ```