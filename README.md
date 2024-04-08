# Documentatie PS
## 1.Pagina de start (Homepage):
-Prezentarea serviciilor oferite: livrare la domiciliu, opțiune de take-away, meniu disponibil etc.
-Imagini atractive cu feluri de mâncare delicioase pentru a atrage atenția vizitatorilor.
-Căutare rapidă a restaurantelor partenere sau a tipurilor de mâncare disponibile.

## 2.Meniu și Opțiuni de Comandă:

-Listă detaliată a restaurantelor partenere și a meniurilor acestora.
-Filtrare și categorizare a meniurilor după tip de mâncare (italiană, asiatică, fast-food etc.) sau după preferințele alimentare (vegetarian, vegan, fără gluten etc.).
-Opțiuni de personalizare a comenzilor, cum ar fi adăugarea de ingrediente suplimentare sau eliminarea unora.

## 3.Procesul de Comandă:

-Formular simplu și intuitiv pentru plasarea comenzilor.
-Posibilitatea de a alege adresa de livrare și intervalul orar dorit.
-Calcul automat al prețului total al comenzii, inclusiv taxele de livrare.

## 4.Autentificare și Cont de Utilizator:

-Posibilitatea de a crea un cont de utilizator pentru a salva informații precum adresele de livrare preferate sau istoricul comenzilor.
-Autentificare rapidă prin intermediul conturilor de social media sau a adresei de email.

## 5.Secțiunea de Promoții și Oferte Speciale:

-Vizualizare a promoțiilor curente și a ofertelor speciale de la restaurantele partenere.
-Cupoane de reduceri sau coduri promoționale pentru utilizatorii înregistrați.

## 6.Pagina de Contact și Suport:

-Informații de contact pentru întrebări, reclamații sau asistență.
-Formular de contact sau chat live pentru a permite utilizatorilor să întrebe rapid întrebări sau să solicite asistență.

## 7.Baza de Date:

1.Tabelul `clienti`:

client_id (INT)
nume (VARCHAR)
adresa (VARCHAR)
telefon (VARCHAR)
email (VARCHAR)
parola (VARCHAR)

2.Tabelul `comenzi`:

comanda_id (INT)
client_id (INT)
restaurant_id (INT)
meniu_id (INT)
adresa_livrare (VARCHAR)
data_ora (DATETIME)
suma_totala (INT)

3.Tabelul `meniuri`:

meniu_id (INT)
restaurant_id (INT)
nume (VARCHAR)
descriere (VARCHAR)
categorie (VARCHAR)

4.Tabelul `produse`:

produs_id (INT)
nume (VARCHAR)
descriere (VARCHAR)
pret (INT)
meniu_id (INT)

5.Tabelul `promotii`:

promotie_id (INT)
restaurant_id (INT)
cod_promotional (VARCHAR)
descriere (VARCHAR)
reducere (INT)

6.Tabelul `recenzii`:

recenzie_id (INT)
client_id (INT)
restaurant_id (INT)
rating (INT)
comentariu (VARCHAR)
data (DATE)

7.Tabelul `restaurante`:

restaurant_id (INT)
nume (VARCHAR)
adresa (VARCHAR)
oras (VARCHAR)
telefon (VARCHAR)
email (VARCHAR)
rating (INT)

8.Tabelul `stocuri`:

stoc_id (INT)
restaurant_id (INT)
produs_id (INT)
cantitate (INT)

## 8.Clasele din Java:
1.Clasa Clienti este o entitate JPA (Java Persistence API) care este mapată la tabela "clienti" din baza de date. Această clasă reprezintă informațiile despre clienții unui site web sau a unei aplicații web.

Atribute:
- client_id: int - Identificatorul unic al clientului în baza de date.
- nume: String - Numele clientului.
- adresa: String - Adresa clientului.
- telefon: String - Numărul de telefon al clientului.
- email: String - Adresa de email a clientului.
- parola: String - Parola asociată contului clientului.

Relații:
- Clasa Clienti are o relație de tipul "One-to-Many" cu clasa Comenzi. Aceasta înseamnă că un client poate avea mai multe comenzi asociate. Această relație este gestionată prin atributul comenzi.


2.Clasa Comenzi reprezintă o entitate utilizată pentru gestionarea informațiilor despre comenzile efectuate în cadrul aplicației web.

Atribute:
- comanda_id: int - identificatorul unic al comenzii
- client: Clienti - clientul care a plasat comanda
- restaurant: Restaurante - restaurantul de la care s-a efectuat comanda
- meniu: Meniuri - meniul comandat
- adresa_livrare: String - adresa la care se livrează comanda
- data_ora: LocalDateTime - data și ora la care s-a plasat comanda
- suma_totala: int - suma totală a comenzii
- 
Relații:
- Clasa Comenzi are o relație Many-to-One cu clasa Clienti. Aceasta înseamnă că o comandă este asociată unui singur client, iar un client poate avea mai multe comenzi.
- De asemenea, clasa Comenzi are o relație Many-to-One cu clasa Restaurante. Asta înseamnă că o comandă este asociată unui singur restaurant, iar un restaurant poate avea mai multe comenzi.
- Clasa Comenzi are și o relație Many-to-One cu clasa Meniuri, ceea ce înseamnă că o comandă este asociată unui singur meniu, iar un meniu poate fi asociat cu mai multe comenzi.



3.Această clasă reprezintă entitatea Comenzi și este utilizată pentru gestionarea informațiilor despre comenzile efectuate.

Atribute:
- comanda_id: int - ID-ul comenzii.
- client: Clienti - Clientul care a plasat comanda.
- restaurant: Restaurante - Restaurantul de la care s-a comandat.
- meniu: Meniuri - Meniul comandat.
- adresa_livrare: String - Adresa la care se livrează comanda.
- data_ora: LocalDateTime - Data și ora la care s-a plasat comanda.
- suma_totala: int - Suma totală a comenzii.

Relații:
- Clasa Comenzi are o relație Many-to-One cu clasa Clienti. Aceasta înseamnă că o comandă este asociată unui singur client, iar un client poate avea mai multe comenzi.
- De asemenea, clasa Comenzi are o relație Many-to-One cu clasa Restaurante. Asta înseamnă că o comandă este asociată unui singur restaurant, iar un restaurant poate avea mai multe comenzi.
- Clasa Comenzi are și o relație Many-to-One cu clasa Meniuri, ceea ce înseamnă că o comandă este asociată unui singur meniu, iar un meniu poate fi asociat cu mai multe comenzi.

4.Această clasă reprezintă o entitate pentru gestionarea informațiilor despre produsele disponibile în meniuri.

Atribute:
- produs_id: int - ID-ul produsului.
- nume: String - Numele produsului.
- descriere: String - Descrierea produsului.
- pret: int - Prețul produsului.
- meniu: Meniuri - Meniul asociat produsului.
- stocuri: List<Stocuri> - Lista de stocuri pentru acest produs.

Relații:
- Clasa Produse are o relație Many-to-One cu clasa Meniuri. Aceasta înseamnă că un produs este asociat unui singur meniu, iar un meniu poate fi asociat cu mai multe produse.
- De asemenea, clasa Produse are o relație One-to-Many cu clasa Stocuri. Aceasta înseamnă că un produs poate fi asociat cu mai multe înregistrări de stocuri, în timp ce fiecare înregistrare de stocuri este legată de un singur produs.

5.Această clasă reprezintă o entitate pentru gestionarea informațiilor despre promoțiile disponibile în restaurante.

Atribute:
- promotie_id: int - ID-ul promoției.
- restaurant_id: int - ID-ul restaurantului la care este asociată promoția.
- cod_promotional: String - Codul promoțional asociat promoției.
- descriere: String - Descrierea promoției.
- reducere: int - Valoarea reducerii oferite de promoție.

6.Această clasă reprezintă entitatea Recenzii și este utilizată pentru gestionarea recenziilor clienților asupra restaurantelor.

Atribute:
- recenzie_id: int - ID-ul recenziei.
- client_id: int - ID-ul clientului care a realizat recenzia.
- restaurant_id: int - ID-ul restaurantului care este recenzat.
- rating: int - Rating-ul acordat de client.
- comentariu: String - Comentariul asociat recenziei.
- data: LocalDate - Data la care a fost realizată recenzia.


7.Această clasă reprezintă entitatea Restaurante și este utilizată pentru gestionarea informațiilor despre restaurante.

Atribute:
- restaurant_id: int - Identificatorul unic al restaurantului.
- nume: String - Numele restaurantului.
- adresa: String - Adresa restaurantului.
- oras: String - Orașul în care se află restaurantul.
- telefon: String - Numărul de telefon al restaurantului.
- email: String - Adresa de email a restaurantului.
- rating: int - Ratingul restaurantului.

Relații:
- Clasa Restaurante are o relație One-to-Many cu clasa Meniuri. Aceasta înseamnă că un restaurant poate avea mai multe meniuri asociate.
- De asemenea, clasa Restaurante are o relație One-to-Many cu clasa Stocuri. Aceasta înseamnă că un restaurant poate avea mai multe stocuri de produse.
- Clasa Restaurante are și o relație One-to-Many cu clasa Comenzi. Asta înseamnă că un restaurant poate primi mai multe comenzi de la clienți.


8.Această clasă reprezintă entitatea Stocuri și este utilizată pentru gestionarea informațiilor despre stocurile de produse ale restaurantelor.

Atribute:
- stoc_id: int - Identificatorul unic al stocului.
- restaurant: Restaurante - Restaurantul asociat stocului.
- produs: Produse - Produsul asociat stocului.
- cantitate: int - Cantitatea de produs disponibilă în stoc.

Relații:
- Clasa Stocuri are o relație Many-to-One cu clasa Restaurante. Aceasta înseamnă că un stoc este asociat unui singur restaurant, iar un restaurant poate avea mai multe stocuri.
- De asemenea, clasa Stocuri are o relație Many-to-One cu clasa Produse. Asta înseamnă că un stoc este asociat unui singur produs, iar un produs poate fi asociat cu mai multe stocuri.



