# Guía de Colaboración

👽👻

## Flujo de Trabajo

### 1. Clonar el repositorio
Primero, debes clonar el repositorio en tu máquina local. Creas una carpeta y abres una terminal allí.
Ejecutas el siguiente comando:

```bash
git clone https://github.com/alhexmbs/pry_dae_farmacia.git
````
#### luego cambias de directorio

```bash
cd pry_dae_farmacia
````
## ⚠️ No modifiques el main. Solo modifica partes de tu módulo. No toques el módulo ni las interfaces de otro :) ⚠️

Si es la primera vez que entras, vas a estar en la rama main, debe crear una rama para poder hacer cambios y no generar errores. Así:
```bash
git checkout -b rama-alex
````
Ahora estás en tu rama. A partir de aquí puedes ir modificando el proyecto.

## ⚠️ No cierres la terminal durante el proceso ⚠️
Una vez hayas hecho todos los cambios, ejecutas lo siguiente en la terminal:
```bash
git add .
````
```bash
git commit -m "Implementé la validación de formularios"
````
```bash
git push origin rama-alex
````
