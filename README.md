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
cost (DOUBLE)

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

## 9.Endpoint-uri noi:
1.Endpoint-uri pentru Restaurante:

- Căutare Restaurante după Literă
    - Endpoint: /searchByLetter
    - Metodă: GET
    - Descriere:
    - Acest endpoint permite căutarea restaurantelor ale căror nume conțin o literă specifică.
    - Parametri:
letter (char) - Litera după care se face căutarea în numele restaurantelor.
    - Răspuns:
HTTP Status 200 (OK): Returnează o listă cu numele restaurantelor care conțin litera specificată.

- Obține Recenzii după ID-ul Restaurantului
    - Endpoint: /{id}/recenzii
    - Metodă: GET
    - Descriere:
     Acest endpoint returnează toate recenziile pentru un anumit restaurant, identificat prin ID-ul său.
    - Parametri:
    id (int) - ID-ul restaurantului pentru care se dorește obținerea recenziilor.   
    - Răspuns:
HTTP Status 200 (OK): Returnează o listă de recenzii pentru restaurantul specificat.
HTTP Status 404 (Not Found): Dacă nu sunt găsite recenzii pentru restaurantul specificat.

- Creează o Recenzie pentru un Restaurant
    - Endpoint: /{restaurantId}/reviews
    - Metodă: POST
    - Descriere:
Acest endpoint permite crearea unei noi recenzii pentru un restaurant specificat prin ID-ul său.
    - Parametri: restaurantId (int) - ID-ul restaurantului pentru care se dorește crearea recenziei.
Corp cerere (Request Body): Un obiect de tip Recenzii care conține detaliile recenziei (comentariu, rating etc.).
    - Răspuns:
HTTP Status 201 (Created): Returnează recenzia creată.

2.Endpoint pentru Clienti:
- Login
    - Endpoint: /login
    - Metodă: POST
    - Descriere: Acest endpoint permite autentificarea unui client pe baza email-ului și parolei.
    - Corp cerere (Request Body): Un obiect JSON care conține email și parola.
    - Răspuns:
HTTP Status 200 (OK): Returnează obiectul Clienti dacă autentificarea este reușită.
HTTP Status 401 (Unauthorized): Returnează mesajul "Email sau parolă incorecte" dacă autentificarea eșuează.

3.Endpoint-uri pentru Meniuri:

- Obține Meniuri după ID-ul Restaurantului
    - Endpoint: /restaurant/{restaurantId}
    - Metodă: GET
    - Descriere: Acest endpoint returnează toate meniurile pentru un restaurant specificat prin ID-ul său.
    - Parametri: restaurantId (int) - ID-ul restaurantului pentru care se dorește obținerea meniurilor.
    - Răspuns:
HTTP Status 200 (OK): Returnează o listă de obiecte Meniuri pentru restaurantul specificat.

- Creează Comenzi Multiple
    - Endpoint: /bulk
    - Metodă: POST
    - Descriere: Acest endpoint permite crearea mai multor comenzi simultan.
    - Corp cerere (Request Body): O listă de obiecte Comenzi care conțin detaliile comenzilor.
    - Răspuns: 
     HTTP Status 201 (Created): Returnează o listă cu comenzile create.

4.Endpoint pentru Comenzi:

- Obține Comenzi după ID-ul Clientului
    - Endpoint: /client/{clientId}/orders
    - Metodă: GET
    - Descriere: Acest endpoint returnează toate comenzile pentru un client specificat prin ID-ul său.
    - Parametri: clientId (int) - ID-ul clientului pentru care se dorește obținerea comenzilor.
    - Răspuns:
HTTP Status 200 (OK): Returnează o listă de obiecte Comenzi pentru clientul specificat.

## 10.Decuplare + Teste:
##### Decuplare:
1. Interfața ClientiContract
    - Definirea Operațiilor: ClientiContract definește operațiile esențiale pentru gestionarea clienților, cum ar fi găsirea, salvarea, ștergerea și autentificarea clienților.
    - Flexibilitate: Această interfață oferă flexibilitate prin permiterea mai multor implementări, în funcție de cerințele specifice ale aplicației.
2. Clasa ClientiData
    - Implementare Specifică: ClientiData implementează interfața ClientiContract și gestionează operațiile concrete asupra datelor clienților, folosind un repository (ClientiRepository).
    - Repository Pattern: Utilizează pattern-ul repository pentru a separa logica de acces la date de restul aplicației, facilitând testarea și schimbarea implementărilor fără a afecta alte părți ale aplicației.
3. Interfața ClientiServiceInterfata
    - Definirea Serviciilor: ClientiServiceInterfata definește operațiile de nivel serviciu pentru gestionarea clienților, oferind o abstractizare a operațiilor disponibile.
4. Clasa ClientiService
    - Implementare Servicii: ClientiService implementează ClientiServiceInterfata și conține logica de afaceri pentru gestionarea clienților. Aceasta interacționează cu ClientiContract pentru a accesa și manipula datele clienților.
    - Centralizarea Logicii: Concentrează logica de afaceri, cum ar fi crearea, actualizarea, ștergerea și autentificarea clienților, într-un singur loc, facilitând astfel întreținerea și extensibilitatea codului.
5. Repository-ul ClientiRepository
    - Acces la Date: ClientiRepository extinde JpaRepository și oferă metode standard pentru operațiile CRUD, precum și metode personalizate, cum ar fi findByEmailAndParola, pentru a facilita autentificarea clienților.

##### Teste:
1. Testele pentru ClientiService
Testele pentru ClientiService se concentrează pe verificarea operațiunilor CRUD și a autentificării clienților:
    - Setup: Metoda setUp inițializează Mockito și injectează mock-ul ClientiContract în instanța de ClientiService.
    - getAllUsersTest: Verifică dacă metoda getAllClients returnează toți clienții așa cum sunt furnizați de mock-ul ClientiContract.
Asigură că metoda findAll din ClientiContract este apelată.
    - testGetClientById: Verifică dacă metoda getClientById returnează clientul corect pentru un ID dat.
Utilizează Optional.of pentru a simula găsirea unui client și asigură că findById este apelată.
    - testCreateClient: Testează crearea unui nou client și verifică dacă clientul returnat este cel așteptat.
Asigură că metoda save din ClientiContract este apelată cu clientul corect.
    - testUpdateClient:Verifică actualizarea unui client existent.
Asigură că findById și save sunt apelate corespunzător și că detaliile clientului sunt actualizate corect.
    - testDeleteClient: Verifică dacă un client este șters corect prin apelarea metodei deleteById.
    - testPartiallyUpdateClient: Testează actualizarea parțială a unui client și verifică dacă doar câmpurile specificate sunt actualizate.
Asigură că findById și save sunt apelate corespunzător.

2. Testele pentru RestauranteService
Testele pentru RestauranteService se concentrează pe operațiunile CRUD și pe gestionarea datelor asociate restaurantelor:
    - Setup: Metoda setUp inițializează Mockito și injectează mock-urile necesare în instanța de RestauranteService.
    - testGetAllRestaurante: Verifică dacă metoda getAllRestaurante returnează lista de restaurante așteptată.
Asigură că findAll din RestauranteContract este apelată.
    - testGetRestauranteById_ExistingId: Testează recuperarea unui restaurant după ID când acesta există.
Asigură că findById din RestauranteContract este apelată și returnează restaurantul corect.
    - testGetRestauranteById_NonExistingId: Verifică comportamentul metodei getRestauranteById atunci când restaurantul nu există.
Asigură că metoda returnează null când findById nu găsește un restaurant.
    - testCreateRestaurante: Testează crearea unui nou restaurant și verifică dacă restaurantul creat este cel așteptat.
Asigură că metoda save din RestauranteContract este apelată cu restaurantul corect.
    - testUpdateRestaurante: Verifică actualizarea unui restaurant existent.
Asigură că findById și save sunt apelate corespunzător și că detaliile restaurantului sunt actualizate corect.
    - testDeleteRestaurantAndAssociatedData: Testează ștergerea unui restaurant și a datelor asociate (recenzii, comenzi, meniuri, promoții).
Verifică că toate metodele deleteById pentru entitățile asociate sunt apelate corect.

## 11. Interfata Angular:

##### Home component:
    
- Componenta home contine imagini + butoane
- Ca si butoane avem :
    - Sign up
    - Log in
    - About Us
    - Contact

##### Sign in component:

- Componenta sign in ajuta utilizatorul sa isi creeze un nou cont pentru a putea da comenzi
- Utilizatorul trebuie sa completeze campurile corect pentru a putea crea un nou cont
- Se face legatura cu endpoint-ul din backend /post pentru Clienti


##### Log in component:
- Componenta log in ajuta utilizatorul sa aceeseze panoul utilizatorului de unde isi poate alege restaurantele de unde sa dea comanda.
- Utilizatorul trebuie sa introduca corect email-ul si parola pentru a se putea loga
- Daca utilizatorul nu are un cont avem un buton Creeaza cont ce il va redirectiona pe utilizator la pagina de sign in
- Metoda din backend care verifica daca email-ul si parola coincid pentru utilizator

##### User-panel component:

- In aceasta componenta utilizatorul are un search bar unde poate cauta restaurantele
- Apare o iconita de profil de unde utilizatorul poate sa se deconecteze sa isi vada ultimele comenzi efectuate si detaliile contului 
- In plus, avem si cateva restaurante afisate si butoane pentru a adauga o recenzie sau pentru a naviga catre pagina de meniuri ale restaurantului
- Avem metodele din backend care returneaza detaliile unui client, care returneaza o lista cu restaurante pentru a le afisa, metoda pentru a cauta un restaurant dupa nume.


##### Meniu component: 

- In aceasta componenta utilizatorul isi adauga meniul in cosul de cumparaturi
- Poate sa adauge 1 sau mai multe meniuri 
- Cand apasa pe comanda acum este redirectionat catre pagina utilizatorului si isi poate vizualiza comenzile dand click pe comenzile mele
- Folosim metodele din backend de adaugare a mai multor meniuri si de a returna tote meniurile pe care un client le-a comandat 


##### Admin component : 
- Aceasta este componenta pentru admin, unde admin-ul sterge adauga sau modifica restaurante deja existente
- Apar toate restaurantele si le poate edita sau sterge
- Poate sterge clienti
- Folosim metodele din backend de sterge actualizare si creare pentru restaurante si clienti 


##### Restaurante-page component:

- Aceasta componenta afiseaza toate restaurantele existente 
- Se pot vizualiza toate recenziile date de clienti pentru fiecare restaurant
- Legatura cu backend, avem metoda de get care returneaza toate recenziile unui restaurant anume


##### Service-uri din frontend:
- Pentru a face legatura cu backend-ul am folosit service-uri pentru Clienti, Meniuri, Restaurante si Comenzi, in care am scris codul necesar pentru a ne folosi de api-urile create in backend 





