Данг Фыонг Нам
гр. 932102

# Mobile Frontend for Hotel Booking
## Jetpack compose + Material 3
## App structure:
### packakge "presentation": top level package.
### package "api": fake call api (asynchronous). Be able to updated for real API.
### package "screen": endpoint for routes (composable), which are navigated by (NavHost).
### package "store": state managements ViewModel.
### package "theme": restyled components (Text, Button, TextField, Outline..) base on parameters (size, color).
### package "ui": components, used by screens from package screens. Common reusable components (scrollable column, centered items column, inputfield with label).
### package "utils": middlewares and constants - static data.
### Design at: https://www.figma.com/design/MN79NDAMDNe9U8tlHVZQD3/Dang.932102.Wireframe_Mobile_App?node-id=0-1&p=f&t=tuUOI94nadEH84SQ-0.
