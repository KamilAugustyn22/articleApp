# ArticleApp

Aby uruchomić aplikację należy ją zbudować poprzez mavena. Wcześniej jednak w pliku application.properties należy podmienić dane logowania do bazy danych na wybraną przez siebie.

Po zbudowaniu plik .jar znajduje się w katalogu target. Po uruchomieniu aplikacja zajmie domyślnie 
port lokalny 8080.
- Endpoint zwracający wszystkie artykuły prasowe posortowane malejąco po dacie publikacji znajduje się pod adresem /api/all.
- Endpoint zwracający pojedynczy artykuł prasowy po id znajdziemy używając metody GET na adresie /api?id=# gdzie zamiast # podajemy id szukanego artykułu.
- Endpoint zwracający listę wszystkich artykułów prasowych po słowie kluczowym zawartym w tytule lub treści publikacji znajduje się pod adresem /api/allWithKeyword/# gdzie zamiast # podajemy słowo kluczowe
- Aby zapisać nowy artykuł prasowy w bazie danych należy pod adresem /api użyć metody POST oraz podać wszystkie dane artykułu
- Endpoint do aktualizacji istniejącego artykułu prasowego działa dokładnie w taki sam sposób jak ten do zapisu. Musimy stare dane, które chcemy zmienić zastąpić nowymi.
- Endpoint do usuwania wybranego artykułu prasowego znajduje się pod adresem /api?id=# gdzie zamiast # podajemy id artykułu, który chcemy usunąć. 

Wszystkie endpointy były przeze mnie testowane przy użyciu Postmana zarówno po 
odpaleniu aplikacji z poziomu IntelliJ, jak również po zbudowaniu jej i uruchomieniu z pliku .jar.


