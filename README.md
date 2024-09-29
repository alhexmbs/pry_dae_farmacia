# Guía de Colaboración

👽👻

## Flujo de Trabajo

### 1. Clonar el repositorio
Primero, debes clonar el repositorio en tu máquina local. Creas una carpeta y abres una terminal allí.
Ejecutas el siguiente comando:

```bash
git clone https://github.com/alhexmbs/pry_dae_farmacia.git
````

Luego cambias de directorio

```bash
cd pry_dae_farmacia
````
Abres ese proyecto en NetBeans.

> ⚠️ Importante: A partir de ahora, abre la terminal siempre en este directorio para ejecutar los comandos de Git. Esto se llama la "carpeta del proyecto" (pry_dae_farmacia).

## ⚠️ REGLAS BÁSICAS DE COLABORACIÓN
- No modifiques el main: Solo trabaja en tu propio módulo o sección asignada.
- Respeta el trabajo de tus compañeros: No modifiques los módulos o interfaces de otros sin su consentimiento.

# PRIMEROS PASOS
## 1. Crea una rama nueva
Si es la primera vez que trabajas en el proyecto, estarás en la rama **main**. Crea tu propia rama para trabajar y evitar conflictos con el código principal:
```bash
git checkout -b rama-tuNombre
````

>Ahora estás en tu rama. Puedes realizar cambios en tu módulo sin afectar el trabajo de los demás.

#### 🐼 Consejos mientras trabajas
- No cierres la terminal mientras haces cambios.
- Guarda y haz commits con frecuencia para no perder el progreso.

## 2. Subir tus cambios
Cuando hayas hecho todos los cambios en tu módulo, sigue estos pasos para guardarlos en GitHub:
```bash
git add .
````
```bash
git commit -m "Implementé la validación de formularios"
````
```bash
git push origin rama-alex
````

Si ya terminaste y todo está correcto regresa a la rama principal (**main**):
```bash
git checkout main
````

⚠️ Esto para que la proxima que quieras modificar hagas lo siguiente: ⚠️

# SI EL PROYECTO YA HA SIDO MODIFICADO
Traer los cambios más recientes:
```bash
git pull origin main
````
Cambiar de vuelta a tu rama de trabajo:
```bash
git checkout rama-alex
````

#### Y así repites el proceso

Happy coding :)
