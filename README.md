# Mercadopago API
Libreria para facilitar la utilización de los servicios de MercadoPago del lado del servidor (Java)

# Requisitos
Java Development Kit 7 (1.7)

Eclipse o Netbeans 8.1

Apache Maven 3.0

# Inicializando
Antes de hacer cualquier operación debes contar con tu CLIENT_ID y CLIENTE_SECRET (Te las da MercadoPago 
en https://www.mercadopago.com/mla/herramientas/aplicaciones
```java
MercadoPagoConnector.init(CLIENT_ID,CLIENT_SECRET);
```
Si no colocas cualquiera de estos parametros recibiras una excepción NoCredentialException. Una vez que se invoca
el método testea la conexión con tus credenciales, si te has equivocado en alguna recibiras otra excepción
esta vez del tipo Request400Exception.

Listo, con eso ya podes empezar a operar con la API

# Obten la instancia de MP (es un singleton)
```java
MP m = MercadoPagoConnector.getInstance();
```
# Operaciones con los items a ofrecer (Checkout preference)
Debes crear una instancia del controlador de preferences así
```java
PreferenceController pc = new PreferenceController();
```
## Obteniendo los datos de un item por su ID
```java
PreferenceController pc = new PreferenceController();
Preference p = pc.byId("COLOCA_ACA_EL_ID_DEL_ITEM"); //Si no conoces el item podes buscarlo en las herramientas de soluciones de pago que creaste alguna vez (los botones de pago por ejemplo, en algun lado dice pref_id = ID)
```
Advertencia: Este ultimo método lanzara varias excepciones dependiendo de lo siguiente:

1. UninitializedException: El CLIENT_ID o el CLIENT_SECRET no fue especificado, llamar al método init(..) de la clase MercadoPagoConnector
2. Request404Exception: si no se encuentra el item (recurso en la base de datos de MercadoPago)
3. Exception: por defecto el servidor de MercadoPago lanza esta excepción al hacer cualquier tipo de request

Si va todo bien te deberia quedar un objeto serializable POJO que se vería en JSON así: 

```json
{

    "additional_info": "",
    "auto_return": "",
    "back_urls": 

{

    "failure": "",
    "pending": "",
    "success": ""

},
"client_id": "913",
"collector_id": ​139929231,
"date_created": "2015-08-10T23:44:13.071-04:00",
"expiration_date_from": null,
"expiration_date_to": null,
"expires": false,
"external_reference": "",
"id": "139929231-0c1e3aaa-ea1k-49b9-859e-a8da2d001369",
"init_point": "https://www.mercadopago.com/mla/checkout/start?pref_id=139929231-0c1e3aaa-ea1d-4944-809e-a8da2d001369",
"items": 
[

    {
        "id": "",
        "currency_id": "ARS",
        "title": "Titulo de tu producto",
        "picture_url": "https://www.mercadopago.com.ar/tools/picture/get?button_id=d15aedeb-239d-4da3-8b68-38db0589b575",
        "description": "",
        "category_id": "",
        "quantity": ​1,
        "unit_price": ​18
    }

],
"marketplace": "NONE",
"marketplace_fee": ​0,
"notification_url": null,
"operation_type": "regular_payment",
"payer": 
{

    "phone": 

{

    "area_code": "",
    "number": ""

},
"email": "",
"address": 
{

    "zip_code": "",
    "street_name": "",
    "street_number": null

},
"identification": 

    {
        "number": "",
        "type": ""
    },
    "name": "",
    "surname": "",
    "date_created": ""

},
"payment_methods": 
{

    "excluded_payment_methods": 

[

    {
        "id": ""
    }

],
"default_installments": null,
"default_payment_method_id": null,
"excluded_payment_types": 
[

        {
            "id": ""
        }
    ],
    "installments": null

},
"sandbox_init_point": "https://sandbox.mercadopago.com/mla/checkout/pay?pref_id=139929231-0c1e3aaa-ea1d-49b5-855e-a8da2d001369",
"shipments": 
{

    "receiver_address": 

        {
            "floor": "",
            "zip_code": "",
            "street_name": "",
            "apartment": "",
            "street_number": null
        }
    }

}
```
# Agregar un nuevo item 
Esto es relativamente sencillo, debes nuevamente inicializar el MercadoLibreConnector, obtener una instancia MP y
luego crear el controlador de Preferences. Te quedaria algo asi:
```java
String CLIENT_ID = "TU_CLIENT_ID";
String CLIENT_SECRET = "TU_CLIENT_SECRET";
MercadoPagoConnector.init(CLIENT_ID,CLIENT_SECRET);
MP m = MercadoPagoConnector.getInstance();
PreferenceController pc = new PreferenceController();
Item i = new Item();
i.setCurrency_id(CurrencyId.ARS); //Tenes ARS,BRL,VEF,CLP,MXN,COP,UYU para elegir
i.setPicture_url("http://www.imgur/pic_de_tu_item.png"); //Foto de tu item
i.setQuantity(1); //Cantidad del item
i.setUnit_price(45.2f); //Precio del item (En la web se mostrará el producto del precio multiplicado por la cantidad
i.setTitle("Mi primer item"); // Titulo del item
i.setDescripcion("Descripcion no obligatoria, pero recomendable");
List<Item> items = new ArrayList<>();
items.add(i); //Agrega todos los items que necesites
Preference p = pc.addPreference(items); //Cuidado: lanzara excepciones si no lo controlas
```
# Actualizar un item
Esto sigue la lógica anterior, con la salvedad de que debes conocer el ID del item y darle una lista de items con sus correspondientes datos. Se pueden presentar excepciones como las anteriores mas una del tipo Request400Exception que engloba todas las posibilidades declaradas por la API de MercadoPago (no dejes de darle un vistazo https://www.mercadopago.com.ar/developers/es/api-docs/basic-checkout/checkout-preferences/)
```java
String CLIENT_ID = "TU_CLIENT_ID";
String CLIENT_SECRET = "TU_CLIENT_SECRET";
MercadoPagoConnector.init(CLIENT_ID,CLIENT_SECRET);
MP m = MercadoPagoConnector.getInstance();
PreferenceController pc = new PreferenceController();
Item i = new Item();
i.setCurrency_id(CurrencyId.ARS); //Tenes ARS,BRL,VEF,CLP,MXN,COP,UYU para elegir
i.setPicture_url("http://www.imgur/pic_de_tu_item.png"); //Foto de tu item
i.setQuantity(1); //Cantidad del item
i.setUnit_price(45.2f); //Precio del item (En la web se mostrará el producto del precio multiplicado por la cantidad
i.setTitle("Mi primer item"); // Titulo del item
i.setDescripcion("Descripcion no obligatoria, pero recomendable");
List<Item> items = new ArrayList<>();
items.add(i); //Agrega todos los items que necesites
Preference p = pc.updatePreference("ID_DE_TU_ITEM_YA_EXISTENTE",items); //Cuidado: lanzara excepciones 
```
# Licencia
MIT
# Comentarios
El proyecto lo comencé solo pero acepto cualquier tipo de ayuda, falta hacer mucho antes de obtener el primer release, pero me parece interesante aportar con algo así ya que es muy util en el Mercosur. Gracias a todos por su interes. 

Cualquier cosa estoy en Youtube haciendo videotutoriales (https://www.youtube.com/channel/UCmTo3RyFzlcox7lx0CVl3ww)

## No dejes de compartir tu conocimiento! Saludos!
