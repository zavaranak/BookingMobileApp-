# Mobile Frontend for Hotel Booking
## Jetpack compose + Material 3
## App structure:
### packakge "presentation": top level package
### package "api": fake call api (asynchronous). Updatable for real API
### package "screen": endpoint for routes (composable) of Navigation (NavHost - NavGrahp)
### package "store": state managements ViewModel
### package "theme": restyled components (Text, Button, TextField, Outline..) base on parameters (size, color)
### package "ui": components, used by screens from package screens. And common reusable component (scrollable column, centered items column, inputfield with label)
### package "utils": middleware and constants - static data.
### Design at: https://www.figma.com/design/MN79NDAMDNe9U8tlHVZQD3/Dang.932102.Wireframe_Mobile_App?node-id=0-1&p=f&t=tuUOI94nadEH84SQ-0
