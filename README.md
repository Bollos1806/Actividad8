# 📱 Aplicación Android - Anime Explorer

## 📋 Descripción del Proyecto

Aplicación Android integral que demuestra la implementación de conceptos avanzados de desarrollo móvil a través de una plataforma dedicada a los entusiastas del anime. Esta aplicación integra múltiples funcionalidades técnicas en un entorno atractivo y funcional para los usuarios.

## 🎯 Objetivo

Desarrollar una aplicación Android que integre todos los conocimientos aprendidos en el primer y segundo parcial, implementando de manera práctica los temas 4 al 15 del programa académico en una solución cohesiva y funcional.

## 🔧 Especificaciones Técnicas

### Plataforma y Versiones

-  **Plataforma**: Android
-  **Lenguaje**: Java
-  **API Mínima**: 28 (Android 9.0)
-  **API Target**: 36
-  **Build Tool**: Gradle con Kotlin DSL

### Arquitectura

-  **Patrón**: MVVM (Model-View-ViewModel)
-  **Inyección de dependencias**: Dagger Hilt
-  **Base de datos local**: Room Database
-  **Sincronización**: Firebase Firestore

## 📚 Requerimientos por Tema

### ✅ Tema 4: Fragmentos, flujo maestro-detalle y menú

-  **Fragments**: Implementación de múltiples fragmentos para navegación modular
-  **Master-Detail Flow**: Lista de animes con vista detallada de personajes
-  **Navigation Drawer**: Menú lateral con opciones principales
-  **Bottom Navigation**: Navegación entre secciones principales
-  **Toolbar personalizado**: Con opciones de búsqueda y filtros

### ✅ Tema 5: Elementos de interfaz gráfica

-  **RecyclerView**: Listas optimizadas de animes y personajes
-  **CardView**: Tarjetas para mostrar información de animes
-  **ImageView**: Gestión de imágenes con Glide/Picasso
-  **TextView personalizados**: Fuentes custom y estilos
-  **Layouts responsivos**: ConstraintLayout y LinearLayout

### ✅ Tema 6: Más sobre interfaz gráfica

-  **Material Design Components**: Buttons, FAB, Chips, TextInputLayout
-  **ViewPager2**: Slider de imágenes y contenido
-  **TabLayout**: Pestañas para categorización
-  **Animations**: Transiciones entre vistas
-  **Custom Views**: Componentes personalizados para rating

### ✅ Tema 7: Transiciones

-  **Activity Transitions**: Transiciones compartidas entre activities
-  **Fragment Transitions**: Animaciones entre fragmentos
-  **Shared Element Transitions**: Elementos compartidos (imágenes)
-  **Custom Animations**: Animaciones personalizadas con Property Animation
-  **Motion Layout**: Transiciones complejas y gestos

### ✅ Tema 8: Uso de aplicaciones externas

-  **Intent Explícitos**: Navegación entre activities
-  **Intent Implícitos**: Compartir contenido, abrir navegador
-  **Camera Intent**: Captura de fotos para perfil de usuario
-  **Gallery Intent**: Selección de imágenes desde galería
-  **Share Intent**: Compartir animes favoritos en redes sociales

### ✅ Tema 9: Emisiones, hilos y servicios

-  **AsyncTask/Executor**: Tareas en segundo plano
-  **Handler y Looper**: Comunicación entre hilos
-  **BroadcastReceiver**: Recepción de eventos del sistema
-  **Notifications**: Notificaciones push para nuevos animes
-  **WorkManager**: Tareas programadas y sincronización

### ✅ Tema 10: Servicios

-  **Foreground Service**: Descarga de contenido en segundo plano
-  **Background Service**: Sincronización periódica
-  **Bound Service**: Comunicación con componentes
-  **IntentService**: Servicios para tareas específicas
-  **JobScheduler**: Programación de tareas eficiente

### ✅ Tema 11: Bases de datos

-  **Room Database**: Almacenamiento local estructurado
-  **Entities**: Modelos de datos (Anime, Character, User)
-  **DAO (Data Access Objects)**: Operaciones CRUD
-  **Database Migration**: Versionado y migración de esquemas
-  **Repository Pattern**: Abstracción de acceso a datos

### ✅ Tema 12: Multimedia

-  **MediaPlayer**: Reproducción de opening/ending de animes
-  **ExoPlayer**: Streaming de videos
-  **Audio Focus**: Gestión de audio del sistema
-  **Image Loading**: Carga optimizada con Glide
-  **Video Thumbnails**: Previsualizaciones de videos

### ✅ Tema 13: Mapeo

-  **Google Maps API**: Localización de eventos de anime
-  **Geolocation**: Ubicación actual del usuario
-  **Markers**: Puntos de interés (tiendas, eventos)
-  **Custom Info Windows**: Información personalizada en mapas
-  **Location Services**: Servicios de ubicación

### ✅ Tema 14: Sensores

-  **Accelerometer**: Shake para funciones aleatorias
-  **Gyroscope**: Interacciones gestuales
-  **Light Sensor**: Modo oscuro automático
-  **Proximity Sensor**: Pausar contenido multimedia
-  **Step Counter**: Gamificación con pasos diarios

### ✅ Tema 15: Publicación en Google Play

-  **App Bundle**: Formato de distribución optimizado
-  **Signing**: Configuración de firmado de APK
-  **Play Console**: Configuración para publicación
-  **Screenshots**: Capturas para la tienda
-  **App Description**: Descripción y metadatos

## 🏗️ Estructura de la Aplicación

### Funcionalidades Principales

1. **Catálogo de Animes**: Exploración y búsqueda de series
2. **Información de Personajes**: Detalles completos de personajes
3. **Lista de Favoritos**: Gestión personal de contenido preferido
4. **Reproductor Multimedia**: Audio y video de animes
5. **Mapa de Eventos**: Localización de eventos relacionados
6. **Perfil de Usuario**: Gestión de cuenta y preferencias
7. **Notificaciones**: Alertas de nuevo contenido
8. **Modo Offline**: Funcionalidad sin conexión

### Base de Datos Local (Room)

```
Tables:
- animes (id, title, description, genre, rating, image_url, release_date)
- characters (id, name, anime_id, description, image_url, role)
- favorites (user_id, anime_id, date_added)
- user_preferences (user_id, theme, notifications_enabled)
```

## 📁 Estructura del Proyecto

```
anime-explorer/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/bollos18/animeexplorer/
│   │   │   │   ├── data/
│   │   │   │   │   ├── database/
│   │   │   │   │   │   ├── entities/
│   │   │   │   │   │   │   ├── Anime.java
│   │   │   │   │   │   │   ├── Character.java
│   │   │   │   │   │   │   ├── Favorite.java
│   │   │   │   │   │   │   └── UserPreference.java
│   │   │   │   │   │   ├── dao/
│   │   │   │   │   │   │   ├── AnimeDao.java
│   │   │   │   │   │   │   ├── CharacterDao.java
│   │   │   │   │   │   │   └── FavoriteDao.java
│   │   │   │   │   │   └── AnimeDatabase.java
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   ├── AnimeRepository.java
│   │   │   │   │   │   └── UserRepository.java
│   │   │   │   │   ├── network/
│   │   │   │   │   │   ├── ApiService.java
│   │   │   │   │   │   └── NetworkModule.java
│   │   │   │   │   └── models/
│   │   │   │   │       ├── AnimeResponse.java
│   │   │   │   │       └── CharacterResponse.java
│   │   │   │   ├── ui/
│   │   │   │   │   ├── activities/
│   │   │   │   │   │   ├── MainActivity.java
│   │   │   │   │   │   ├── DetailActivity.java
│   │   │   │   │   │   └── PlayerActivity.java
│   │   │   │   │   ├── fragments/
│   │   │   │   │   │   ├── HomeFragment.java
│   │   │   │   │   │   ├── FavoritesFragment.java
│   │   │   │   │   │   ├── SearchFragment.java
│   │   │   │   │   │   ├── ProfileFragment.java
│   │   │   │   │   │   └── MapFragment.java
│   │   │   │   │   ├── adapters/
│   │   │   │   │   │   ├── AnimeAdapter.java
│   │   │   │   │   │   ├── CharacterAdapter.java
│   │   │   │   │   │   └── FavoriteAdapter.java
│   │   │   │   │   ├── viewmodels/
│   │   │   │   │   │   ├── AnimeViewModel.java
│   │   │   │   │   │   ├── FavoriteViewModel.java
│   │   │   │   │   │   └── UserViewModel.java
│   │   │   │   │   └── customs/
│   │   │   │   │       ├── RatingView.java
│   │   │   │   │       └── LoadingView.java
│   │   │   │   ├── services/
│   │   │   │   │   ├── SyncService.java
│   │   │   │   │   ├── NotificationService.java
│   │   │   │   │   └── MediaPlayerService.java
│   │   │   │   ├── utils/
│   │   │   │   │   ├── Constants.java
│   │   │   │   │   ├── ImageLoader.java
│   │   │   │   │   ├── SensorManager.java
│   │   │   │   │   └── NetworkUtils.java
│   │   │   │   ├── receivers/
│   │   │   │   │   ├── ConnectivityReceiver.java
│   │   │   │   │   └── ShakeReceiver.java
│   │   │   │   └── Application.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_detail.xml
│   │   │   │   │   ├── fragment_home.xml
│   │   │   │   │   ├── fragment_favorites.xml
│   │   │   │   │   ├── fragment_search.xml
│   │   │   │   │   ├── fragment_profile.xml
│   │   │   │   │   ├── fragment_map.xml
│   │   │   │   │   ├── item_anime.xml
│   │   │   │   │   ├── item_character.xml
│   │   │   │   │   └── toolbar_custom.xml
│   │   │   │   ├── navigation/
│   │   │   │   │   ├── nav_graph.xml
│   │   │   │   │   └── bottom_nav_menu.xml
│   │   │   │   ├── menu/
│   │   │   │   │   ├── drawer_menu.xml
│   │   │   │   │   ├── toolbar_menu.xml
│   │   │   │   │   └── context_menu.xml
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── ic_anime.xml
│   │   │   │   │   ├── ic_favorite.xml
│   │   │   │   │   ├── ic_search.xml
│   │   │   │   │   ├── ic_profile.xml
│   │   │   │   │   └── background_gradient.xml
│   │   │   │   ├── anim/
│   │   │   │   │   ├── slide_in_right.xml
│   │   │   │   │   ├── slide_out_left.xml
│   │   │   │   │   ├── fade_in.xml
│   │   │   │   │   └── fade_out.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── styles.xml
│   │   │   │   │   └── dimens.xml
│   │   │   │   ├── values-night/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── styles.xml
│   │   │   │   └── xml/
│   │   │   │       ├── network_security_config.xml
│   │   │   │       └── data_extraction_rules.xml
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   │   └── java/com/bollos18/animeexplorer/
│   │   │       ├── database/
│   │   │       │   ├── AnimeDaoTest.java
│   │   │       │   └── DatabaseTest.java
│   │   │       ├── repository/
│   │   │       │   └── AnimeRepositoryTest.java
│   │   │       ├── viewmodels/
│   │   │       │   └── AnimeViewModelTest.java
│   │   │       └── utils/
│   │   │           └── NetworkUtilsTest.java
│   │   └── androidTest/
│   │       └── java/com/bollos18/animeexplorer/
│   │           ├── ui/
│   │           │   ├── MainActivityTest.java
│   │           │   └── FragmentTest.java
│   │           └── database/
│   │               └── DatabaseInstrumentedTest.java
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle/
│   ├── libs.versions.toml
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── google-services.json
└── README.md
```

## 🎨 Diseño y UX

-  **Material Design 3**: Implementación de las últimas guías de diseño
-  **Tema Dinámico**: Adaptación a colores del sistema (Android 12+)
-  **Modo Oscuro**: Soporte completo para tema claro/oscuro
-  **Accesibilidad**: Cumplimiento de estándares de accesibilidad
-  **Responsive Design**: Adaptación a tablets y diferentes densidades

## 📱 Compatibilidad

-  **Dispositivos**: Smartphones y tablets Android
-  **Orientación**: Portrait y landscape
-  **Resoluciones**: Desde HDPI hasta XXXHDPI
-  **Arquitecturas**: ARM64, x86_64

## 🚀 Instalación y Desarrollo

### Prerrequisitos

-  Android Studio Arctic Fox o superior
-  JDK 11 o superior
-  Android SDK API 28-36
-  Gradle 7.0+

### Configuración del Proyecto

1. Clonar el repositorio
2. Abrir en Android Studio
3. Sincronizar dependencias de Gradle
4. Configurar Firebase (google-services.json)
5. Ejecutar en dispositivo o emulador

## 🧪 Testing

-  **Unit Tests**: JUnit para lógica de negocio
-  **Integration Tests**: Testing de base de datos Room
-  **UI Tests**: Espresso para interfaces
-  **Performance Tests**: Análisis de memoria y rendimiento

## 🏆 Criterios de Evaluación

### Implementación Técnica (40%)

-  Correcta implementación de fragmentos y navegación
-  Uso adecuado de elementos de interfaz gráfica
-  Implementación de transiciones y animaciones
-  Integración con aplicaciones externas
-  Manejo de hilos y servicios
-  Implementación de base de datos local

### Funcionalidad (30%)

-  Reproducción de contenido multimedia
-  Integración con mapas y geolocalización
-  Uso de sensores del dispositivo
-  Sincronización de datos
-  Notificaciones push
-  Funcionalidad offline

### Diseño y UX (20%)

-  Adherencia a Material Design
-  Responsividad en diferentes dispositivos
-  Accesibilidad y usabilidad
-  Consistencia visual
-  Flujo de navegación intuitivo

### Documentación y Calidad (10%)

-  Calidad del código y comentarios
-  Tests unitarios y de integración
-  Documentación técnica
-  Versionado y control de cambios

## 📅 Roadmap de Desarrollo

### 📋 Evidencia 2: Funcionalidades Base (Temas 4-10)

#### Fase 1: Configuración y Estructura Base

-  Configuración del proyecto Android con API 28 mínimo
-  Implementación de arquitectura MVVM
-  **Tema 4**: Implementación de fragmentos, navigation drawer y bottom navigation
-  **Tema 4**: Flujo maestro-detalle para catálogo de animes
-  **Tema 5**: RecyclerView, CardView, ImageView para listas de animes
-  **Tema 5**: Layouts responsivos (ConstraintLayout, LinearLayout)
-  **Tema 6**: Material Design Components (FAB, Chips, TextInputLayout)
-  **Tema 6**: ViewPager2 y TabLayout para navegación

#### Fase 2: Interactividad y Navegación

-  **Tema 7**: Activity y Fragment transitions
-  **Tema 7**: Shared element transitions y animaciones personalizadas
-  **Tema 8**: Intent explícitos e implícitos
-  **Tema 8**: Integración con cámara y galería
-  **Tema 9**: AsyncTask/Executor para tareas en segundo plano
-  **Tema 9**: BroadcastReceiver y notificaciones push
-  **Tema 10**: Implementación de servicios (Foreground, Background, Bound)
-  **Tema 10**: WorkManager para tareas programadas

### 📋 Evidencia 3: Funcionalidades Avanzadas (Temas 10-15)

#### Fase 1: Multimedia, Geolocalización y Sensores

-  **Tema 10**: Optimización y refinamiento de servicios
-  **Tema 11**: Room Database con entities y DAOs completos
-  **Tema 11**: Repository pattern y migration de base de datos
-  **Tema 12**: MediaPlayer y ExoPlayer para contenido multimedia
-  **Tema 12**: Gestión de audio focus y video thumbnails
-  **Tema 13**: Google Maps API para eventos de anime
-  **Tema 13**: Geolocation y markers personalizados
-  **Tema 14**: Implementación de sensores (Accelerometer, Light, Proximity)
-  **Tema 14**: Funcionalidades basadas en sensores (shake, modo oscuro automático)

#### Fase 4: Testing y Distribución

-  **Tema 15**: Configuración de App Bundle y signing
-  **Tema 15**: Preparación para Google Play Console
-  Tests unitarios e integración completos
-  Optimización de rendimiento final
-  Documentación técnica completa
-  Screenshots y metadatos para publicación
-  Validación de todos los requerimientos
-  Entrega final del proyecto

## 🔗 Enlaces Útiles

-  [Android Developer Documentation](https://developer.android.com/)
-  [Material Design Guidelines](https://material.io/design)
-  [Firebase Documentation](https://firebase.google.com/docs)
-  [Room Database Guide](https://developer.android.com/training/data-storage/room)

## 👥 Equipo de Desarrollo

**Desarrollador Principal**:  
**Materia**: Desarrollo de Aplicaciones Móviles

## 📞 Contacto

Para dudas técnicas o consultas sobre el proyecto:

-  **Email**: [email del estudiante]
-  **GitHub**: [usuario de GitHub]

---

_Este proyecto ha sido desarrollado como evidencia académica para demostrar la integración de conceptos avanzados de desarrollo Android._
